/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.utils;

import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityConfigVo;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityFieldMappingVo;
import neatlogic.framework.cmdb.enums.RelDirectionType;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SubSelect;
import net.sf.jsqlparser.util.cnfexpression.MultiOrExpression;

import java.util.*;

public class ResourceViewGenerateSqlUtil {

    private CiVo mainCiVo;
    private List<ResourceEntityFieldMappingVo> fieldMappingList;
    //sql语句中已经存在的表
    private Map<String, Table> joinedTableMap;
    //sql语句关联表中相等的列
    private Map<String, Column> equalColumnMap;

    public ResourceViewGenerateSqlUtil(ResourceEntityConfigVo config) {
        this.mainCiVo = config.getMainCiVo();
        this.fieldMappingList = config.getFieldMappingList();
    }

    public String getSql() {
        PlainSelect plainSelect = initPlainSelectByMainResourceId(mainCiVo);
        for (ResourceEntityFieldMappingVo fieldMappingVo : fieldMappingList) {
            addJoinTableByFieldMapping(fieldMappingVo, plainSelect);
        }
        return plainSelect.toString();
    }

    private void addJoinTable(Table table) {
        String key = table.getName();
        Alias alias = table.getAlias();
        if (alias != null) {
            key = alias.getName();
        }
        joinedTableMap.put(key, table);
    }

    private Table getTableByAlias(String alias) {
        return joinedTableMap.get(alias);
    }

    private void addEqualColumn(Column left, Column right) {
        equalColumnMap.put(left.toString(), right);
    }

    private Expression getExpiredExpression(Table mainTable) {
          /*
               (not exists (select 1 from cmdb_cientity_expiredtime xx where xx.cientity_id = `ci_base`.id) or exists
            (select 1 from cmdb_cientity_expiredtime xx where xx.cientity_id = `ci_base`.id
            and xx.expired_time &gt;= NOW()))
             */

        List<Expression> expressionList = new ArrayList<>();
        expressionList.add(new ExistsExpression()
                .withNot(true)
                .withRightExpression(new SubSelect()
                        .withSelectBody(new PlainSelect()
                                .withFromItem(new Table("cmdb_cientity_expiredtime").withAlias(new Alias("ex")))
                                .addSelectItems(new SelectExpressionItem(new Column("1")))
                                .withWhere(new EqualsTo(new Column("ex.cientity_id"), new Column(mainTable,"id"))))));
        expressionList.add(new ExistsExpression().withRightExpression(new SubSelect()
                .withSelectBody((new PlainSelect()
                        .withFromItem(new Table("cmdb_cientity_expiredtime").withAlias(new Alias("ex")))
                        .addSelectItems(new SelectExpressionItem(new Column("1")))
                        .withWhere(new AndExpression().withLeftExpression(new EqualsTo(new Column("ex.cientity_id"), new Column(mainTable,"id")))
                                .withRightExpression(new GreaterThanEquals().withLeftExpression(new Column("ex.expired_time")).withRightExpression(new Function().withName("now"))))))));
        return new MultiOrExpression(expressionList);
    }

    /**
     * 根据主资源id，初始化sql语句，例如SELECT * FROM cmdb_cientity IPObject JOIN cmdb_ci ci_IPObject ON ci_IPObject.id = IPObject.ci_id
     * @param mainCiVo
     * @return
     */
    private PlainSelect initPlainSelectByMainResourceId(CiVo mainCiVo) {
        joinedTableMap = new HashMap<>();
        equalColumnMap = new HashMap<>();
        String mainTableAlias = mainCiVo.getName();
        Table mainTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + mainTableAlias).withUseAs(false));
        PlainSelect plainSelect = new PlainSelect()
                .withFromItem(mainTable);
        addJoinTable(mainTable);
        Table cmdbCi = new Table("cmdb_ci").withAlias(new Alias("cientity_" + mainTableAlias + "_ci").withUseAs(false));
        Column cmdbCiIdColumn = new Column(cmdbCi, "id");
        Column mainTableCiIdColumn = new Column(mainTable, "ci_id");
        EqualsTo equalsTo = new EqualsTo(cmdbCiIdColumn, mainTableCiIdColumn);
        Column cmdbCiLftColumn = new Column(cmdbCi, "lft");
        Column cmdbCiRhtColumn = new Column(cmdbCi, "rht");
//        GreaterThanEquals greaterThanEquals = new GreaterThanEquals(">=").withLeftExpression(cmdbCiLftColumn).withRightExpression(new LongValue(mainCiVo.getLft()));
//        MinorThanEquals minorThanEquals = new MinorThanEquals("<=").withLeftExpression(cmdbCiRhtColumn).withRightExpression(new LongValue(mainCiVo.getRht()));
        Table cmdbCiTable = new Table("cmdb_ci");
        SubSelect subSelectLft = new SubSelect().withSelectBody(new PlainSelect().withFromItem(cmdbCiTable).addSelectItems(new SelectExpressionItem(new Column( "lft"))).withWhere(new EqualsTo(new Column("id"), new LongValue(mainCiVo.getId()))));
        SubSelect subSelectRht = new SubSelect().withSelectBody(new PlainSelect().withFromItem(cmdbCiTable).addSelectItems(new SelectExpressionItem(new Column( "rht"))).withWhere(new EqualsTo(new Column("id"), new LongValue(mainCiVo.getId()))));
        GreaterThanEquals greaterThanEquals = new GreaterThanEquals(">=").withLeftExpression(cmdbCiLftColumn).withRightExpression(subSelectLft);
        MinorThanEquals minorThanEquals = new MinorThanEquals("<=").withLeftExpression(cmdbCiRhtColumn).withRightExpression(subSelectRht);
        AndExpression andExpression = new AndExpression(greaterThanEquals, minorThanEquals);
        Join joinCmdbCi = new Join().withRightItem(cmdbCi).addOnExpression(new AndExpression(equalsTo, andExpression));
        plainSelect.addJoins(joinCmdbCi);
        addJoinTable(cmdbCi);
        addEqualColumn(cmdbCiIdColumn, mainTableCiIdColumn);
        plainSelect.withWhere(getExpiredExpression(mainTable));
        return plainSelect;
    }

    /**
     * 根据需要查询或过滤的列信息join表
     * @param fieldMappingVo
     * @param plainSelect
     * @return
     */
    private Column addJoinTableByFieldMapping(ResourceEntityFieldMappingVo fieldMappingVo, PlainSelect plainSelect) {
        Table mainTable = (Table) plainSelect.getFromItem();
        String field = fieldMappingVo.getField();
        String fromCi = fieldMappingVo.getFromCi();
        Long fromCiId = fieldMappingVo.getFromCiId();
        String fromAttr = fieldMappingVo.getFromAttr();
        Long fromAttrId = fieldMappingVo.getFromAttrId();
        Long fromAttrCiId = fieldMappingVo.getFromAttrCiId();
        String toAttrCiName = fieldMappingVo.getToAttrCiName();
        Long toAttrCiId = fieldMappingVo.getToAttrCiId();
        Long toCiId = fieldMappingVo.getToCiId();
        String toCi = fieldMappingVo.getToCi();
        Long toAttrId = fieldMappingVo.getToAttrId();
        String toAttr = fieldMappingVo.getToAttr();
        Integer attrCiIsVirtual = fieldMappingVo.getToCiIsVirtual();
        String direction = fieldMappingVo.getDirection();
        boolean left = true;
        String type = fieldMappingVo.getType();
        if (Objects.equals(type, "attr")) {
            Table resourceCiTable = getTableByAlias("cientity_" + fromCi);
            if (resourceCiTable == null) {
                resourceCiTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + fromCi).withUseAs(false));
                Column resourceCiTableIdColumn = new Column(resourceCiTable, "id");
                Column mainTableIdColumn = new Column(mainTable, "id");
                EqualsTo equalsTo = new EqualsTo(resourceCiTableIdColumn, mainTableIdColumn);
                Join join = new Join().withLeft(left).withRightItem(resourceCiTable).addOnExpression(equalsTo);
                plainSelect.addJoins(join);
                addJoinTable(resourceCiTable);
                addEqualColumn(resourceCiTableIdColumn, mainTableIdColumn);
            }
            // 下拉框类型属
            if (toCiId != null) {
                Table cmdbAttrentityTable = joinedTableMap.get("cmdb_attrentity_" + fromAttr);
                if (cmdbAttrentityTable == null) {
                    cmdbAttrentityTable = new Table("cmdb_attrentity").withAlias(new Alias("cmdb_attrentity_" + fromAttr).withUseAs(false));
                    Column cmdbAttrentityTableFromCientityIdColumn = new Column(cmdbAttrentityTable, "from_cientity_id");
                    Column resourceCiTableIdColumn = new Column(resourceCiTable, "id");
                    EqualsTo equalsTo1 = new EqualsTo(cmdbAttrentityTableFromCientityIdColumn, resourceCiTableIdColumn);
                    EqualsTo equalsTo2 = new EqualsTo(new Column(cmdbAttrentityTable, "attr_id"), new LongValue(fromAttrId));
                    Expression onExpression = new AndExpression(equalsTo1, equalsTo2);
                    Join join = new Join().withLeft(left).withRightItem(cmdbAttrentityTable).addOnExpression(onExpression);
                    plainSelect.addJoins(join);
                    addJoinTable(cmdbAttrentityTable);
                    addEqualColumn(cmdbAttrentityTableFromCientityIdColumn, resourceCiTableIdColumn);
                }
                if (Objects.equals(attrCiIsVirtual, 1)) {
                    //属性模型是虚拟模型时
                    Table cmdbCiIdTable = joinedTableMap.get("cmdb_" + toAttrCiId + "_" + toAttrCiName);
                    if (cmdbCiIdTable == null) {
                        cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), "cmdb_" + toAttrCiId)
                                .withAlias(new Alias("cmdb_" + toAttrCiId + "_" + toAttrCiName).withUseAs(false));
                        addJoinTable(cmdbCiIdTable);
                        Column cmdbCiIdTableIdColumn = new Column(cmdbCiIdTable, "id");
                        Column cmdbAttrentityTableToCientityIdColumn = new Column(cmdbAttrentityTable, "to_cientity_id");
                        Join join = new Join().withLeft(left).withRightItem(cmdbCiIdTable).addOnExpression(new EqualsTo(cmdbCiIdTableIdColumn, cmdbAttrentityTableToCientityIdColumn));
                        plainSelect.addJoins(join);
                        addEqualColumn(cmdbCiIdTableIdColumn, cmdbAttrentityTableToCientityIdColumn);
                    }
                    if (toAttrId == null) {
                        if (toAttr.startsWith("_")) {
                            toAttr = toAttr.substring(1);
                        }
                        Column column = new Column(cmdbCiIdTable, toAttr);
                        plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                        return column;
                    } else {
                        Column column = new Column(cmdbCiIdTable, "`" + toAttrId + "`");
                        plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                        return column;
                    }
                } else {
                    //属性模型是非虚拟模型时
                    Table attrCiTable = joinedTableMap.get("cientity_" + toCi);
                    if (attrCiTable == null) {
                        attrCiTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + toCi).withUseAs(false));
                        Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                        Column cmdbAttrentityTableToCientityIdColumn = new Column(cmdbAttrentityTable, "to_cientity_id");
                        EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbAttrentityTableToCientityIdColumn);
                        AndExpression andExpression = new AndExpression(equalsTo, getExpiredExpression(attrCiTable));
                        Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(andExpression);
                        plainSelect.addJoins(join);
                        addJoinTable(attrCiTable);
                        addEqualColumn(attrCiTableIdColumn, cmdbAttrentityTableToCientityIdColumn);
                    }
                    if (toAttrId == null) {
                        if (toAttr.startsWith("_")) {
                            toAttr = toAttr.substring(1);
                        }
                        Column column = new Column(attrCiTable, toAttr);
                        plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                        return column;
                    } else {
                        String tableName = "cmdb_" + toAttrCiId;
                        String tableAlias = tableName + "_" + toCi;
                        Table cmdbCiIdTable = joinedTableMap.get(tableAlias);
                        if (cmdbCiIdTable == null) {
                            cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), tableName).withAlias(new Alias(tableAlias).withUseAs(false));
                            Column cmdbCiIdTableCientityIdColumn = new Column(cmdbCiIdTable, "cientity_id");
                            Column table3IdColumn = new Column(attrCiTable, "id");
                            Join join = new Join().withLeft(left).withRightItem(cmdbCiIdTable).addOnExpression(new EqualsTo(cmdbCiIdTableCientityIdColumn, table3IdColumn));
                            plainSelect.addJoins(join);
                            addJoinTable(cmdbCiIdTable);
                            addEqualColumn(cmdbCiIdTableCientityIdColumn, table3IdColumn);
                        }
                        Column column = new Column(cmdbCiIdTable, "`" + toAttrId + "`");
                        plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                        return column;
                    }
                }
            } else {
                //非下拉框属性
                String tableName = "cmdb_" + fromAttrCiId;
                String tableAlias = tableName + "_" + fromCi;
                Table cmdbCiIdTable = joinedTableMap.get(tableAlias);
                if (cmdbCiIdTable == null) {
                    cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), tableName).withAlias(new Alias(tableAlias).withUseAs(false));
                    Column cmdbCiIdTableCientityIdColumn = new Column(cmdbCiIdTable, "cientity_id");
                    Column attrCiTableIdColumn = new Column(resourceCiTable, "id");
                    Join join = new Join().withLeft(left).withRightItem(cmdbCiIdTable).addOnExpression(new EqualsTo(cmdbCiIdTableCientityIdColumn, attrCiTableIdColumn));
                    plainSelect.addJoins(join);
                    addJoinTable(cmdbCiIdTable);
                    addEqualColumn(cmdbCiIdTableCientityIdColumn, attrCiTableIdColumn);
                }
                Column column = new Column(cmdbCiIdTable, "`" + fromAttrId + "`");
                plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                return column;
            }
        } else if (Objects.equals(type, "rel")) {
            //上游关系
            if (Objects.equals(direction, RelDirectionType.FROM.getValue())) {
                Table cmdbRelentityTable = joinedTableMap.get("cmdb_relentity_" + fromCi);
                if (cmdbRelentityTable == null) {
                    cmdbRelentityTable = new Table("cmdb_relentity").withAlias(new Alias("cmdb_relentity_" + fromCi).withUseAs(false));
                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable, "to_cientity_id");
                    Column toTableIdColumn = new Column(new Table("cientity_" + toCi), "id");
                    EqualsTo equalsTo = new EqualsTo(cmdbRelentityTableToCientityIdColumn, toTableIdColumn);

                    Column cmdbRelentityTableFromCientityIdColumn = new Column(cmdbRelentityTable, "from_cientity_id");
                    Table cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(),"cmdb_" + fromCiId);
                    SubSelect subSelect = new SubSelect().withSelectBody(new PlainSelect().withFromItem(cmdbCiIdTable).addSelectItems(new SelectExpressionItem(new Column(cmdbCiIdTable, "cientity_id"))));
                    InExpression inExpression = new InExpression(cmdbRelentityTableFromCientityIdColumn, subSelect);

                    Join join = new Join().withLeft(left).withRightItem(cmdbRelentityTable).addOnExpression(new AndExpression(equalsTo, inExpression));
                    plainSelect.addJoins(join);
                    addJoinTable(cmdbRelentityTable);
                    addEqualColumn(cmdbRelentityTableToCientityIdColumn, toTableIdColumn);
                }

                Table attrCiTable = joinedTableMap.get("cientity_" + fromCi);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + fromCi).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column cmdbRelentityTableFromCientityIdColumn = new Column(cmdbRelentityTable, "from_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbRelentityTableFromCientityIdColumn);
                    AndExpression andExpression = new AndExpression(equalsTo, getExpiredExpression(attrCiTable));
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(andExpression);
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, cmdbRelentityTableFromCientityIdColumn);
                }
                if (fromAttrId == null) {
                    if (fromAttr.startsWith("_")) {
                        if ("_typeId".equals(fromAttr)) {
                            fromAttr = "ci_id";
                        } else {
                            fromAttr = fromAttr.substring(1);
                        }
                    }
                    Column column = new Column(attrCiTable, fromAttr);
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                    return column;
                } else {
                    String tableName = "cmdb_" + fromAttrCiId;
                    String tableAlias = tableName + "_" + fromCi;
                    Table cmdbCiIdTable = joinedTableMap.get(tableAlias);
                    if (cmdbCiIdTable == null) {
                        cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), tableName).withAlias(new Alias(tableAlias).withUseAs(false));
                        Column cmdbCiIdTableCientityIdColumn = new Column(cmdbCiIdTable, "cientity_id");
                        Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                        Join join = new Join().withLeft(left).withRightItem(cmdbCiIdTable).addOnExpression(new EqualsTo(cmdbCiIdTableCientityIdColumn, attrCiTableIdColumn));
                        plainSelect.addJoins(join);
                        addJoinTable(cmdbCiIdTable);
                        addEqualColumn(cmdbCiIdTableCientityIdColumn, attrCiTableIdColumn);
                    }
                    Column column = new Column(cmdbCiIdTable, "`" + fromAttrId + "`");
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                    return column;
                }
            } else {
                //下游关系
                Table cmdbRelentityTable = joinedTableMap.get("cmdb_relentity_" + toCi);
                if (cmdbRelentityTable == null) {
                    cmdbRelentityTable = new Table("cmdb_relentity").withAlias(new Alias("cmdb_relentity_" + toCi).withUseAs(false));
                    Column cmdbRelentityTableFromCientityIdColumn = new Column(cmdbRelentityTable, "from_cientity_id");
                    Column toTableIdColumn = new Column(new Table("cientity_" + fromCi), "id");
                    EqualsTo equalsTo = new EqualsTo(cmdbRelentityTableFromCientityIdColumn, toTableIdColumn);
                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable, "to_cientity_id");
                    Table cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(),"cmdb_" + toCiId);
                    SubSelect subSelect = new SubSelect().withSelectBody(new PlainSelect().withFromItem(cmdbCiIdTable).addSelectItems(new SelectExpressionItem(new Column(cmdbCiIdTable, "cientity_id"))));
                    InExpression inExpression = new InExpression(cmdbRelentityTableToCientityIdColumn, subSelect);

                    Join join = new Join().withLeft(left).withRightItem(cmdbRelentityTable).addOnExpression(new AndExpression(equalsTo, inExpression));
                    plainSelect.addJoins(join);
                    addJoinTable(cmdbRelentityTable);
                    addEqualColumn(cmdbRelentityTableFromCientityIdColumn, toTableIdColumn);
                }

                Table attrCiTable = joinedTableMap.get("cientity_" + toCi);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + toCi).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable, "to_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbRelentityTableToCientityIdColumn);
                    AndExpression andExpression = new AndExpression(equalsTo, getExpiredExpression(attrCiTable));
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(andExpression);
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, cmdbRelentityTableToCientityIdColumn);
                }
                if (Objects.equals(field, "cluster_type_id")) {
                    System.out.println("");
                }
                if (toAttrId == null) {
                    if (toAttr.startsWith("_")) {
                        if ("_typeId".equals(toAttr)) {
                            toAttr = "ci_id";
                        } else {
                            toAttr = toAttr.substring(1);
                        }
                    }
                    Column column = new Column(attrCiTable, toAttr);
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                    return column;
                } else {
                    String tableName = "cmdb_" + toAttrCiId;
                    String tableAlias = tableName + "_" + toCi;
                    Table cmdbCiIdTable = joinedTableMap.get(tableAlias);
                    if (cmdbCiIdTable == null) {
                        cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), tableName).withAlias(new Alias(tableAlias).withUseAs(false));
                        Column cmdbCiIdTableCientityIdColumn = new Column(cmdbCiIdTable, "cientity_id");
                        Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                        Join join = new Join().withLeft(left).withRightItem(cmdbCiIdTable).addOnExpression(new EqualsTo(cmdbCiIdTableCientityIdColumn, attrCiTableIdColumn));
                        plainSelect.addJoins(join);
                        addJoinTable(cmdbCiIdTable);
                        addEqualColumn(cmdbCiIdTableCientityIdColumn, attrCiTableIdColumn);
                    }
                    Column column = new Column(cmdbCiIdTable, "`" + toAttrId + "`");
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                    return column;
                }
            }
        } else {
            //非下拉框属性
            if ("_id".equals(fromAttr)) {
                fromAttr = "id";
            } else if ("_uuid".equals(fromAttr)) {
                fromAttr = "uuid";
            } else if ("_name".equals(fromAttr)) {
                fromAttr = "name";
            } else if ("_fcu".equals(fromAttr)) {
                fromAttr = "fcu";
            } else if ("_fcd".equals(fromAttr)) {
                fromAttr = "fcd";
            } else if ("_lcu".equals(fromAttr)) {
                fromAttr = "lcu";
            } else if ("_lcd".equals(fromAttr)) {
                fromAttr = "lcd";
            } else if ("_inspectStatus".equals(fromAttr)) {
                fromAttr = "inspect_status";
            } else if ("_inspectTime".equals(fromAttr)) {
                fromAttr = "inspect_time";
            } else if ("_monitorStatus".equals(fromAttr)) {
                fromAttr = "monitor_status";
            } else if ("_monitorTime".equals(fromAttr)) {
                fromAttr = "monitor_time";
            } else if ("_typeId".equals(fromAttr)) {
                fromAttr = "ci_id";
            } else if ("_typeName".equals(fromAttr)) {
                fromCi = fromCi + "_ci";
                fromAttr = "name";
            } else if ("_typeLabel".equals(fromAttr)) {
                fromCi = fromCi + "_ci";
                fromAttr = "label";
            }
            Column column = new Column(new Table("cientity_" + fromCi), fromAttr);
            plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
            return column;
        }
    }
}
