/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.utils;

import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityConfigVo;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityFieldMappingVo;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityLeftJoinVo;
import neatlogic.framework.cmdb.enums.RelDirectionType;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SubSelect;
import net.sf.jsqlparser.util.cnfexpression.MultiOrExpression;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class ResourceViewGenerateSqlUtil {

    private CiVo mainCiVo;
    private List<ResourceEntityFieldMappingVo> fieldMappingList;
    private List<ResourceEntityLeftJoinVo> leftJoinList;
    //sql语句中已经存在的表
    private Map<String, Table> joinedTableMap;
    //sql语句关联表中相等的列
    private Map<String, Column> equalColumnMap;

    public ResourceViewGenerateSqlUtil(ResourceEntityConfigVo config) {
        this.mainCiVo = config.getMainCiVo();
        this.fieldMappingList = config.getFieldMappingList();
        this.leftJoinList = config.getLeftJoinList();
    }

    public String getSql() {
        PlainSelect plainSelect = initPlainSelectByMainResourceId(mainCiVo);
        for (ResourceEntityLeftJoinVo leftJoinVo : leftJoinList) {
            addJoinTable(leftJoinVo, plainSelect);
        }
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
        String tableName = "cmdb_" + mainCiVo.getId();
        String tableAlias = tableName + "_" + mainCiVo.getName();
        Table cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), tableName).withAlias(new Alias(tableAlias).withUseAs(false));
        PlainSelect plainSelect = new PlainSelect()
                .withFromItem(cmdbCiIdTable);
        addJoinTable(cmdbCiIdTable);

        String mainTableAlias = mainCiVo.getName();
        Table mainTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + mainTableAlias).withUseAs(false));
        Column cmdbCiIdTableCientityIdColumn = new Column(cmdbCiIdTable, "cientity_id");
        Column mainTableIdColumn = new Column(mainTable, "id");
        Join joinMainTable = new Join().withRightItem(mainTable).addOnExpression(new EqualsTo(cmdbCiIdTableCientityIdColumn, mainTableIdColumn));
        plainSelect.addJoins(joinMainTable);
        addJoinTable(mainTable);

        Table cmdbCiTable = new Table("cmdb_ci").withAlias(new Alias("cientity_" + mainTableAlias + "_ci").withUseAs(false));
        Column mainTableCiIdColumn = new Column(mainTable.getAlias().getName() + ".ci_id");
        Column cmdbCiIdColumn = new Column( cmdbCiTable.getAlias().getName() + ".id");
        Join joinCmdbCi = new Join().withRightItem(cmdbCiTable).addOnExpression(new EqualsTo(cmdbCiIdColumn, mainTableCiIdColumn));
        plainSelect.addJoins(joinCmdbCi);
        addEqualColumn(cmdbCiIdColumn, mainTableCiIdColumn);
        plainSelect.withWhere(getExpiredExpression(mainTable));
        return plainSelect;
    }

    private void addJoinTable(ResourceEntityLeftJoinVo leftJoinVo, PlainSelect plainSelect) {
        String fromCi = leftJoinVo.getFromCi();
        Long fromCiId = leftJoinVo.getFromCiId();
        String fromCiAlias = leftJoinVo.getFromCiAlias();
        String toCi = leftJoinVo.getToCi();
        Long toCiId = leftJoinVo.getToCiId();
        String toCiAlias = leftJoinVo.getToCiAlias();
        String direction = leftJoinVo.getDirection();
        boolean left = true;
        if (StringUtils.isNotBlank(fromCiAlias)) {
            fromCi += fromCiAlias;
        }
        if (StringUtils.isNotBlank(toCiAlias)) {
            toCi += toCiAlias;
        }
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
        }
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
        String fromCiAlias = fieldMappingVo.getFromCiAlias();
        Long fromCiId = fieldMappingVo.getFromCiId();
        String fromAttr = fieldMappingVo.getFromAttr();
        Long fromAttrId = fieldMappingVo.getFromAttrId();
        Long fromAttrCiId = fieldMappingVo.getFromAttrCiId();
        String toAttrCiName = fieldMappingVo.getToAttrCiName();
        Long toAttrCiId = fieldMappingVo.getToAttrCiId();
        Long toCiId = fieldMappingVo.getToCiId();
        String toCi = fieldMappingVo.getToCi();
        String toCiAlias = fieldMappingVo.getToCiAlias();
        Long toAttrId = fieldMappingVo.getToAttrId();
        String toAttr = fieldMappingVo.getToAttr();
        Integer attrCiIsVirtual = fieldMappingVo.getToCiIsVirtual();
        String direction = fieldMappingVo.getDirection();
        boolean left = true;
        if (StringUtils.isNotBlank(fromCiAlias)) {
            fromCi += fromCiAlias;
        }
        if (StringUtils.isNotBlank(toCiAlias)) {
            toCi += toCiAlias;
        }
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
        } else if (Objects.equals(type, "globalAttr")) {
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
            Table cmdbCientityGlobalattritemTable = getTableByAlias("globalattritem_" + fromAttr);
            if (cmdbCientityGlobalattritemTable == null) {
                cmdbCientityGlobalattritemTable = new Table("cmdb_cientity_globalattritem").withAlias(new Alias("globalattritem_" + fromAttr).withUseAs(false));
                Column cmdbCientityGlobalattritemTableCiEntityIdColumn = new Column(cmdbCientityGlobalattritemTable, "cientity_id");
                Column resourceCiTableIdColumn = new Column(resourceCiTable, "id");
                EqualsTo equalsTo = new EqualsTo(cmdbCientityGlobalattritemTableCiEntityIdColumn, resourceCiTableIdColumn);
                Join join = new Join().withLeft(left).withRightItem(cmdbCientityGlobalattritemTable).addOnExpression(equalsTo);
                plainSelect.addJoins(join);
                addJoinTable(cmdbCientityGlobalattritemTable);
                addEqualColumn(cmdbCientityGlobalattritemTableCiEntityIdColumn, resourceCiTableIdColumn);
            }
            Table globalAttrTable = getTableByAlias("global_attr_" + fromAttr);
            if (globalAttrTable == null) {
                globalAttrTable = new Table("cmdb_global_attr").withAlias(new Alias("global_attr_" + fromAttr).withUseAs(false));
                Column globalAttrTableIdColumn = new Column(globalAttrTable, "id");
                Column cmdbCientityGlobalattritemTableAttrIdColumn = new Column(cmdbCientityGlobalattritemTable, "attr_id");
                EqualsTo equalsTo = new EqualsTo(globalAttrTableIdColumn, cmdbCientityGlobalattritemTableAttrIdColumn);
                Column globalAttrTableNameColumn = new Column(globalAttrTable, "name");
                EqualsTo equalsTo2 = new EqualsTo(globalAttrTableNameColumn, new StringValue(fromAttr));
                Join join = new Join().withLeft(left).withRightItem(globalAttrTable).addOnExpression(new AndExpression(equalsTo, equalsTo2));
                plainSelect.addJoins(join);
                addJoinTable(globalAttrTable);
                addEqualColumn(globalAttrTableIdColumn, cmdbCientityGlobalattritemTableAttrIdColumn);
            }
            Table globalAttritemTable = getTableByAlias("global_attritem_" + fromAttr);
            if (globalAttritemTable == null) {
                globalAttritemTable = new Table("cmdb_global_attritem").withAlias(new Alias("global_attritem_" + fromAttr).withUseAs(false));
                Column globalAttritemTableIdColumn = new Column(globalAttritemTable, "id");
                Column cmdbCientityGlobalattritemTableItemIdColumn = new Column(cmdbCientityGlobalattritemTable, "item_id");
                EqualsTo equalsTo = new EqualsTo(globalAttritemTableIdColumn, cmdbCientityGlobalattritemTableItemIdColumn);
                Column globalAttritemTableAttrIdColumn = new Column(globalAttritemTable, "attr_id");
                Column cmdbCientityGlobalattritemTableAttrIdColumn = new Column(cmdbCientityGlobalattritemTable, "attr_id");
                EqualsTo equalsTo2 = new EqualsTo(globalAttritemTableAttrIdColumn, cmdbCientityGlobalattritemTableAttrIdColumn);
                Join join = new Join().withLeft(left).withRightItem(globalAttritemTable).addOnExpression(new AndExpression(equalsTo, equalsTo2));
                plainSelect.addJoins(join);
                addJoinTable(globalAttritemTable);
                addEqualColumn(globalAttritemTableIdColumn, cmdbCientityGlobalattritemTableItemIdColumn);
                addEqualColumn(globalAttritemTableAttrIdColumn, cmdbCientityGlobalattritemTableAttrIdColumn);
            }
            Column column = new Column(globalAttritemTable, toAttr);
            plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
            return column;
        }  else if (Objects.equals(type, "empty")) {
            plainSelect.addSelectItems(new SelectExpressionItem(new NullValue()).withAlias(new Alias(field)));
            return null;
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
