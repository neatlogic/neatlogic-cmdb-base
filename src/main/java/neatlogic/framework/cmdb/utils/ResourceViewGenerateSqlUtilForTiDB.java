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
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SubSelect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ResourceViewGenerateSqlUtilForTiDB {

    private CiVo mainCiVo;
    private List<ResourceEntityFieldMappingVo> fieldMappingList;
    //sql语句中已经存在的表
    private Map<String, Table> joinedTableMap;
    private Map<String, SubSelect> joinedSubSelectMap;
    //sql语句关联表中相等的列
    private Map<String, Column> equalColumnMap;

    public ResourceViewGenerateSqlUtilForTiDB(ResourceEntityConfigVo config) {
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

    private void addJoinSubSelect(SubSelect subSelect) {
        String key = subSelect.getAlias().getName();
        if (!joinedSubSelectMap.containsKey(key)) {
            joinedSubSelectMap.put(key, subSelect);
        }
    }

    private SubSelect getSubSelectByAlias(String alias) {
        return joinedSubSelectMap.get(alias);
    }

    private void addEqualColumn(Column left, Column right) {
        equalColumnMap.put(left.toString(), right);
    }

    private SubSelect getExpiredSubSelect(String ciName) {
        Table a = new Table("cmdb_cientity").withAlias(new Alias("a").withUseAs(false));
        Column aIdColumn = new Column(a, "id");

        Table b = new Table("cmdb_cientity_expiredtime").withAlias(new Alias("b").withUseAs(false));
        Column bCiEntityIdColumn = new Column(b, "cientity_id");
        Column bExpiredTimeColumn = new Column(b, "expired_time");

        GreaterThanEquals greaterThanEquals = new GreaterThanEquals(">=").withLeftExpression(bExpiredTimeColumn).withRightExpression(new Function().withName("NOW"));
        Join join = new Join().withLeft(true).withRightItem(b).addOnExpression(new EqualsTo(bCiEntityIdColumn, aIdColumn));

        SubSelect subSelect = new SubSelect().withSelectBody(
                new PlainSelect().withFromItem(a).addJoins(join)
                        .addSelectItems(new SelectExpressionItem(new Column(a, "*")))
                        .withWhere(new OrExpression().withLeftExpression(new IsNullExpression().withLeftExpression(bCiEntityIdColumn)).withRightExpression(greaterThanEquals))
        ).withAlias(new Alias("cientity_" + ciName).withUseAs(false));
        return subSelect;
    }

    /**
     * 根据主资源id，初始化sql语句，例如SELECT * FROM cmdb_cientity IPObject JOIN cmdb_ci ci_IPObject ON ci_IPObject.id = IPObject.ci_id
     * @param mainCiVo
     * @return
     */
    private PlainSelect initPlainSelectByMainResourceId(CiVo mainCiVo) {
        joinedTableMap = new HashMap<>();
        equalColumnMap = new HashMap<>();
        joinedSubSelectMap = new HashMap<>();
        String mainTableAlias = mainCiVo.getName();
        SubSelect mainTable = getExpiredSubSelect(mainTableAlias);
        PlainSelect plainSelect = new PlainSelect()
                .withFromItem(mainTable);
        addJoinSubSelect(mainTable);
        Table a = new Table("cmdb_ci").withAlias(new Alias("a").withUseAs(false));
        Column aLftColumn = new Column(a, "lft");
        Column aRhtColumn = new Column(a, "rht");

        Table b = new Table("cmdb_ci").withAlias(new Alias("b").withUseAs(false));
        Column bLftColumn = new Column(b, "lft");
        Column bRhtColumn = new Column(b, "rht");

        GreaterThanEquals greaterThanEquals = new GreaterThanEquals(">=").withLeftExpression(bLftColumn).withRightExpression(aLftColumn);
        MinorThanEquals minorThanEquals = new MinorThanEquals("<=").withLeftExpression(bRhtColumn).withRightExpression(aRhtColumn);
        Join join = new Join().withRightItem(b).addOnExpression(new AndExpression(greaterThanEquals, minorThanEquals));

        SubSelect subSelect = new SubSelect().withSelectBody(
                new PlainSelect().withFromItem(a).addJoins(join)
                        .addSelectItems(new SelectExpressionItem(new Column( b, "*")))
                        .withWhere(new EqualsTo(new Column(a, "id"), new LongValue(mainCiVo.getId())))
                ).withAlias(new Alias("cientity_" + mainTableAlias + "_ci").withUseAs(false));
        Column mainTableCiIdColumn = new Column(mainTable.getAlias().getName() + ".ci_id");
        addJoinSubSelect(subSelect);
        Column cmdbCiIdColumn = new Column( subSelect.getAlias().getName() + ".id");
        Join joinCmdbCi = new Join().withRightItem(subSelect).addOnExpression(new EqualsTo(cmdbCiIdColumn, mainTableCiIdColumn));
        plainSelect.addJoins(joinCmdbCi);
        addEqualColumn(cmdbCiIdColumn, mainTableCiIdColumn);
        return plainSelect;
    }

    /**
     * 根据需要查询或过滤的列信息join表
     * @param fieldMappingVo
     * @param plainSelect
     * @return
     */
    private Column addJoinTableByFieldMapping(ResourceEntityFieldMappingVo fieldMappingVo, PlainSelect plainSelect) {
        SubSelect mainTable = (SubSelect) plainSelect.getFromItem();
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
            SubSelect resourceCiTable = getSubSelectByAlias("cientity_" + fromCi);
            if (resourceCiTable == null) {
                resourceCiTable = getExpiredSubSelect(fromCi);
                Column resourceCiTableIdColumn = new Column(resourceCiTable.getAlias().getName() + ".id");
                Column mainTableIdColumn = new Column(mainTable.getAlias().getName() + ".id");
                EqualsTo equalsTo = new EqualsTo(resourceCiTableIdColumn, mainTableIdColumn);
                Join join = new Join().withLeft(left).withRightItem(resourceCiTable).addOnExpression(equalsTo);
                plainSelect.addJoins(join);
                addJoinSubSelect(resourceCiTable);
                addEqualColumn(resourceCiTableIdColumn, mainTableIdColumn);
            }
            // 下拉框类型属
            if (toCiId != null) {
                Table cmdbAttrentityTable = joinedTableMap.get("cmdb_attrentity_" + fromAttr);
                if (cmdbAttrentityTable == null) {
                    cmdbAttrentityTable = new Table("cmdb_attrentity").withAlias(new Alias("cmdb_attrentity_" + fromAttr).withUseAs(false));
                    Column cmdbAttrentityTableFromCientityIdColumn = new Column(cmdbAttrentityTable, "from_cientity_id");
                    Column resourceCiTableIdColumn = new Column(resourceCiTable.getAlias().getName() + ".id");
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
                    SubSelect attrCiTable = joinedSubSelectMap.get("cientity_" + toCi);
                    if (attrCiTable == null) {
                        attrCiTable = getExpiredSubSelect(toCi);
                        Column attrCiTableIdColumn = new Column(attrCiTable.getAlias().getName() + ".id");
                        Column cmdbAttrentityTableToCientityIdColumn = new Column(cmdbAttrentityTable, "to_cientity_id");
                        EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbAttrentityTableToCientityIdColumn);
                        Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(equalsTo);
                        plainSelect.addJoins(join);
                        addJoinSubSelect(attrCiTable);
                        addEqualColumn(attrCiTableIdColumn, cmdbAttrentityTableToCientityIdColumn);
                    }
                    if (toAttrId == null) {
                        if (toAttr.startsWith("_")) {
                            toAttr = toAttr.substring(1);
                        }
                        Column column = new Column(attrCiTable.getAlias().getName() + "." + toAttr);
                        plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                        return column;
                    } else {
                        String tableName = "cmdb_" + toAttrCiId;
                        String tableAlias = tableName + "_" + toCi;
                        Table cmdbCiIdTable = joinedTableMap.get(tableAlias);
                        if (cmdbCiIdTable == null) {
                            cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), tableName).withAlias(new Alias(tableAlias).withUseAs(false));
                            Column cmdbCiIdTableCientityIdColumn = new Column(cmdbCiIdTable, "cientity_id");
                            Column table3IdColumn = new Column(attrCiTable.getAlias().getName() + ".id");
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
                    Column attrCiTableIdColumn = new Column(resourceCiTable.getAlias().getName() + ".id");
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
                SubSelect cmdbRelentityTable = joinedSubSelectMap.get("cmdb_relentity_" + fromCi);
                if (cmdbRelentityTable == null) {
                    Table a = new Table("cmdb_relentity").withAlias(new Alias("a").withUseAs(false));
                    Column aFromCiEntityIdColumn = new Column(a, "from_cientity_id");

                    Table b = new Table(TenantContext.get().getDataDbName(),"cmdb_" + fromCiId).withAlias(new Alias("b").withUseAs(false));
                    Column bCiEntityIdColumn = new Column(b, "cientity_id");

                    Join join2 = new Join().withRightItem(b).addOnExpression(new EqualsTo(bCiEntityIdColumn, aFromCiEntityIdColumn));
                    cmdbRelentityTable = new SubSelect().withSelectBody(new PlainSelect().withFromItem(a).addJoins(join2).addSelectItems(new SelectExpressionItem(new Column(a, "*")))).withAlias(new Alias("cmdb_relentity_" + fromCi));

                    Column cmdbRelEntityTableToCiEntityIdColumn = new Column(cmdbRelentityTable.getAlias().getName() +  ".to_cientity_id");
                    Column toTableIdColumn = new Column(new Table("cientity_" + toCi), "id");
                    EqualsTo equalsTo = new EqualsTo(cmdbRelEntityTableToCiEntityIdColumn, toTableIdColumn);

                    Join join = new Join().withLeft(left).withRightItem(cmdbRelentityTable).addOnExpression(equalsTo);
                    plainSelect.addJoins(join);
                    addJoinSubSelect(cmdbRelentityTable);
                    addEqualColumn(cmdbRelEntityTableToCiEntityIdColumn, toTableIdColumn);
                }

                SubSelect attrCiTable = joinedSubSelectMap.get("cientity_" + fromCi);
                if (attrCiTable == null) {
                    attrCiTable = getExpiredSubSelect(fromCi);
                    Column attrCiTableIdColumn = new Column(attrCiTable.getAlias().getName() + ".id");
                    Column cmdbRelEntityTableFromCiEntityIdColumn = new Column(cmdbRelentityTable.getAlias().getName() + ".from_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbRelEntityTableFromCiEntityIdColumn);
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(equalsTo);
                    plainSelect.addJoins(join);
                    addJoinSubSelect(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, cmdbRelEntityTableFromCiEntityIdColumn);
                }
                if (fromAttrId == null) {
                    if (fromAttr.startsWith("_")) {
                        if ("_typeId".equals(fromAttr)) {
                            fromAttr = "ci_id";
                        } else {
                            fromAttr = fromAttr.substring(1);
                        }
                    }
                    Column column = new Column(attrCiTable.getAlias().getName() + "." + fromAttr);
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                    return column;
                } else {
                    String tableName = "cmdb_" + fromAttrCiId;
                    String tableAlias = tableName + "_" + fromCi;
                    Table cmdbCiIdTable = joinedTableMap.get(tableAlias);
                    if (cmdbCiIdTable == null) {
                        cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), tableName).withAlias(new Alias(tableAlias).withUseAs(false));
                        Column cmdbCiIdTableCientityIdColumn = new Column(cmdbCiIdTable, "cientity_id");
                        Column attrCiTableIdColumn = new Column(attrCiTable.getAlias().getName() + ".id");
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
                SubSelect cmdbRelentityTable = joinedSubSelectMap.get("cmdb_relentity_" + toCi);
                if (cmdbRelentityTable == null) {
                    Table a = new Table("cmdb_relentity").withAlias(new Alias("a").withUseAs(false));
                    Column aToCiEntityIdColumn = new Column(a, "to_cientity_id");

                    Table b = new Table(TenantContext.get().getDataDbName(),"cmdb_" + toCiId).withAlias(new Alias("b").withUseAs(false));
                    Column bCiEntityIdColumn = new Column(b, "cientity_id");

                    Join join2 = new Join().withRightItem(b).addOnExpression(new EqualsTo(bCiEntityIdColumn, aToCiEntityIdColumn));
                    cmdbRelentityTable = new SubSelect().withSelectBody(new PlainSelect().withFromItem(a).addJoins(join2).addSelectItems(new SelectExpressionItem(new Column(a, "*")))).withAlias(new Alias("cmdb_relentity_" + toCi));

                    Column cmdbRelEntityTableFromCiEntityIdColumn = new Column(cmdbRelentityTable.getAlias().getName() + ".from_cientity_id");
                    Column toTableIdColumn = new Column(new Table("cientity_" + fromCi), "id");
                    EqualsTo equalsTo = new EqualsTo(cmdbRelEntityTableFromCiEntityIdColumn, toTableIdColumn);

                    Join join = new Join().withLeft(left).withRightItem(cmdbRelentityTable).addOnExpression(equalsTo);
                    plainSelect.addJoins(join);
                    addJoinSubSelect(cmdbRelentityTable);
                    addEqualColumn(cmdbRelEntityTableFromCiEntityIdColumn, toTableIdColumn);
                }

                SubSelect attrCiTable = joinedSubSelectMap.get("cientity_" + toCi);
                if (attrCiTable == null) {
                    attrCiTable = getExpiredSubSelect(toCi);
                    Column attrCiTableIdColumn = new Column(attrCiTable.getAlias().getName() + ".id");
                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable.getAlias().getName() + ".to_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbRelentityTableToCientityIdColumn);
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(equalsTo);
                    plainSelect.addJoins(join);
                    addJoinSubSelect(attrCiTable);
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
                    Column column = new Column(attrCiTable.getAlias().getName() + "." + toAttr);
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                    return column;
                } else {
                    String tableName = "cmdb_" + toAttrCiId;
                    String tableAlias = tableName + "_" + toCi;
                    Table cmdbCiIdTable = joinedTableMap.get(tableAlias);
                    if (cmdbCiIdTable == null) {
                        cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), tableName).withAlias(new Alias(tableAlias).withUseAs(false));
                        Column cmdbCiIdTableCientityIdColumn = new Column(cmdbCiIdTable, "cientity_id");
                        Column attrCiTableIdColumn = new Column(attrCiTable.getAlias().getName() + ".id");
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
            SubSelect resourceCiTable = joinedSubSelectMap.get("cientity_" + fromCi);
            if (resourceCiTable == null) {
//                resourceCiTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + fromCi).withUseAs(false));
                Column resourceCiTableIdColumn = new Column(resourceCiTable.getAlias().getName() + ".id");
                Column mainTableIdColumn = new Column(mainTable.getAlias().getName() + ".id");
                EqualsTo equalsTo = new EqualsTo(resourceCiTableIdColumn, mainTableIdColumn);
                Join join = new Join().withLeft(left).withRightItem(resourceCiTable).addOnExpression(equalsTo);
                plainSelect.addJoins(join);
                addJoinSubSelect(resourceCiTable);
                addEqualColumn(resourceCiTableIdColumn, mainTableIdColumn);
            }
            Table cmdbCientityGlobalattritemTable = joinedTableMap.get("globalattritem_" + fromAttr);
            if (cmdbCientityGlobalattritemTable == null) {
                cmdbCientityGlobalattritemTable = new Table("cmdb_cientity_globalattritem").withAlias(new Alias("globalattritem_" + fromAttr).withUseAs(false));
                Column cmdbCientityGlobalattritemTableCiEntityIdColumn = new Column(cmdbCientityGlobalattritemTable, "cientity_id");
                Column resourceCiTableIdColumn = new Column(resourceCiTable.getAlias().getName() + ".id");
                EqualsTo equalsTo = new EqualsTo(cmdbCientityGlobalattritemTableCiEntityIdColumn, resourceCiTableIdColumn);
                Join join = new Join().withLeft(left).withRightItem(cmdbCientityGlobalattritemTable).addOnExpression(equalsTo);
                plainSelect.addJoins(join);
                addJoinTable(cmdbCientityGlobalattritemTable);
                addEqualColumn(cmdbCientityGlobalattritemTableCiEntityIdColumn, resourceCiTableIdColumn);
            }
            Table globalAttrTable = joinedTableMap.get("global_attr_" + fromAttr);
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
            Table globalAttritemTable = joinedTableMap.get("global_attritem_" + fromAttr);
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
