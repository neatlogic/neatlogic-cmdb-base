/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.utils;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.dto.resourcecenter.config.*;
import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.cmdb.enums.resourcecenter.JoinType;
import com.alibaba.fastjson.JSONObject;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectExpressionItem;
import net.sf.jsqlparser.statement.select.SubSelect;

import java.util.*;

public class SceneEntityGenerateSqlUtil {

    private final SceneEntityVo sceneEntityVo;
    //sql语句中已经存在的表
    private Map<String, Table> joinedTableMap;
    //sql语句关联表中相等的列
    private Map<String, Column> equalColumnMap;

    public SceneEntityGenerateSqlUtil(SceneEntityVo sceneEntityVo) {
        this.sceneEntityVo = sceneEntityVo;
    }

    public String getSql() {
        PlainSelect plainSelect = initPlainSelectByMainResourceId(sceneEntityVo.getCi());
        for (SceneEntityAttrVo sceneEntityAttrVo : sceneEntityVo.getAttrList()) {
            System.out.println("sceneEntityAttrVo:" + JSONObject.toJSONString(sceneEntityAttrVo));
            addJoinTableBySceneEntityAttr(sceneEntityAttrVo, plainSelect);
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

    private Column getEqualColumn(Column left) {
        Column result = left;
        for(int i = 0; i < 10; i++) {
            Column right = equalColumnMap.get(left.toString());
            if (right == null) {
                return result;
            }
            result = right;
        }
        return result;
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
        GreaterThanEquals greaterThanEquals = new GreaterThanEquals(">=").withLeftExpression(cmdbCiLftColumn).withRightExpression(new LongValue(mainCiVo.getLft()));
        MinorThanEquals minorThanEquals = new MinorThanEquals("<=").withLeftExpression(cmdbCiRhtColumn).withRightExpression(new LongValue(mainCiVo.getRht()));
        AndExpression andExpression = new AndExpression(greaterThanEquals, minorThanEquals);
        Join joinCmdbCi = new Join().withRightItem(cmdbCi).addOnExpression(new AndExpression(equalsTo, andExpression));
        plainSelect.addJoins(joinCmdbCi);
        addJoinTable(cmdbCi);
        addEqualColumn(cmdbCiIdColumn, mainTableCiIdColumn);
        return plainSelect;
    }

    /**
     * 根据需要查询或过滤的列信息join表
     * @param sceneEntityAttrVo
     * @param plainSelect
     * @return
     */
    private Column addJoinTableBySceneEntityAttr(SceneEntityAttrVo sceneEntityAttrVo, PlainSelect plainSelect) {
        Table mainTable = (Table) plainSelect.getFromItem();
        String field = sceneEntityAttrVo.getField();
        String fromCi = sceneEntityAttrVo.getFromCi();
        Long fromCiId = sceneEntityAttrVo.getFromCiId();
        String fromAttr = sceneEntityAttrVo.getFromAttr();
        Long fromAttrId = sceneEntityAttrVo.getFromAttrId();
        Long fromAttrCiId = sceneEntityAttrVo.getFromAttrCiId();
        String toAttrCiName = sceneEntityAttrVo.getToAttrCiName();
        Long toAttrCiId = sceneEntityAttrVo.getToAttrCiId();
        Long toCiId = sceneEntityAttrVo.getToCiId();
        String toCi = sceneEntityAttrVo.getToCi();
        Long toAttrId = sceneEntityAttrVo.getToAttrId();
        String toAttr = sceneEntityAttrVo.getToAttr();
        Integer attrCiIsVirtual = sceneEntityAttrVo.getToCiIsVirtual();
        String direction = sceneEntityAttrVo.getDirection();
        boolean left = true;
        JoinType joinType = sceneEntityAttrVo.getJoinType();
        if (joinType == JoinType.ATTR) {
            // 下拉框类型属
            // 例如状态属性state AS state_id
//            <resource id="resource_ipobject_state" ci="IPObject">
//                <attr field="resource_id" attr="_id"/>
//                <attr field="state_name" ci="CIState" attr="name"/>
//                <attr field="state_label" ci="CIState" attr="label"/>
//                <join>
//                    <attr field="state_id" ci="CIState" joinAttrName="state"/>
//                </join>
//            </resource>
//            (left) join cmdb_cientity IPObject ON IPObject.id = IPObject.id
//            (left) join cmdb_attrentity cmdb_attrentity_state ON cmdb_attrentity_state.from_cientity_id = IPObject.id and cmdb_attrentity_state.attr_id = #{attrId}
//            (left) join cmdb_cientity CIState ON CIState.id = cmdb_attrentity_state.to_cientity_id
            //负责人属性owner AS user_id
//            <resource id="resource_ipobject_owner" ci="IPObject">
//                <attr field="resource_id" attr="_id"/>
//                <attr field="user_name" ci="User" attr="user_name"/>
//                <attr field="user_uuid" ci="User" attr="_uuid"/>
//                <join>
//                    <attr field="user_id" ci="User" joinAttrName="owner"/>
//                </join>
//            </resource>
//            (left) join cmdb_cientity IPObject ON IPObject.id = IPObject.id
//            (left) join cmdb_attrentity cmdb_attrentity_owner ON cmdb_attrentity_owner.from_cientity_id = IPObject.id and cmdb_attrentity_owner.attr_id = #{attrId}
//            (LEFT) JOIN codedriver_develop_data.cmdb_479643459133440 cmdb_479643459133440_User ON cmdb_479643459133440_User.id = cmdb_attrentity_owner.to_cientity_id
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
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(equalsTo);
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
        } else if (joinType == JoinType.REL) {
            //关系
            if (Objects.equals(direction, RelDirectionType.FROM.getValue())) {
                Table cmdbRelentityTable = joinedTableMap.get("cmdb_relentity_" + toCi);
                if (cmdbRelentityTable == null) {
                    cmdbRelentityTable = new Table("cmdb_relentity").withAlias(new Alias("cmdb_relentity_" + toCi).withUseAs(false));
                    Column cmdbRelentityTableFromCientityIdColumn = new Column(cmdbRelentityTable, "from_cientity_id");
                    Column fromTableIdColumn = new Column(new Table("cientity_" + fromCi), "id");
                    EqualsTo equalsTo = new EqualsTo(cmdbRelentityTableFromCientityIdColumn, fromTableIdColumn);

                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable, "to_cientity_id");
                    Table cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(),"cmdb_" + toCiId);
                    SubSelect subSelect = new SubSelect().withSelectBody(new PlainSelect().withFromItem(cmdbCiIdTable).addSelectItems(new SelectExpressionItem(new Column(cmdbCiIdTable, "cientity_id"))));
                    InExpression inExpression = new InExpression(cmdbRelentityTableToCientityIdColumn, subSelect);

                    Join join = new Join().withLeft(left).withRightItem(cmdbRelentityTable).addOnExpression(new AndExpression(equalsTo, inExpression));
                    plainSelect.addJoins(join);
                    addJoinTable(cmdbRelentityTable);
                    addEqualColumn(cmdbRelentityTableFromCientityIdColumn, fromTableIdColumn);
                }

                Table attrCiTable = joinedTableMap.get("cientity_" + toCi);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + toCi).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable, "to_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbRelentityTableToCientityIdColumn);
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(equalsTo);
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, cmdbRelentityTableToCientityIdColumn);
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
            } else {
                //模块
//                <resource id="resource_ipobject_appmodule" ci="IPObject">
//                    <attr field="resource_id" attr="_id"/>
//                    <attr field="app_module_name" ci="APPComponent" attr="name"/>
//                    <attr field="app_module_abbr_name" ci="APPComponent" attr="abbrName"/>
//                    <join>
//                        <rel field="app_module_id" ci="APPComponent" direction="to"/>
//                    </join>
//                </resource>

//                LEFT JOIN cmdb_relentity cmdb_relentity_APPComponent ON cmdb_relentity_APPComponent.to_cientity_id = IPObject.id
//                LEFT JOIN cmdb_rel cmdb_rel_APPComponent ON cmdb_rel_APPComponent.id = cmdb_relentity_APPComponent.rel_id AND cmdb_rel_APPComponent.from_ci_id = 479610550624256
//                LEFT JOIN cmdb_cientity APPComponent ON APPComponent.id = cmdb_relentity_APPComponent.from_cientity_id

//                LEFT JOIN codedriver_develop_data.cmdb_441087512551424 cmdb_441087512551424_APPComponent ON cmdb_441087512551424_APPComponent.cientity_id = APPComponent.id
//                LEFT JOIN codedriver_develop_data.cmdb_479610550624256 cmdb_479610550624256_APPComponent ON cmdb_479610550624256_APPComponent.cientity_id = APPComponent.id
                Table cmdbRelentityTable = joinedTableMap.get("cmdb_relentity_" + fromCi);
                if (cmdbRelentityTable == null) {
                    cmdbRelentityTable = new Table("cmdb_relentity").withAlias(new Alias("cmdb_relentity_" + fromCi).withUseAs(false));
                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable, "to_cientity_id");
                    Column fromTableIdColumn = new Column(new Table("cientity_" + toCi), "id");
                    EqualsTo equalsTo = new EqualsTo(cmdbRelentityTableToCientityIdColumn, fromTableIdColumn);
                    Column cmdbRelentityTableFromCientityIdColumn = new Column(cmdbRelentityTable, "from_cientity_id");
                    Table cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(),"cmdb_" + fromCiId);
                    SubSelect subSelect = new SubSelect().withSelectBody(new PlainSelect().withFromItem(cmdbCiIdTable).addSelectItems(new SelectExpressionItem(new Column(cmdbCiIdTable, "cientity_id"))));
                    InExpression inExpression = new InExpression(cmdbRelentityTableFromCientityIdColumn, subSelect);

                    Join join = new Join().withLeft(left).withRightItem(cmdbRelentityTable).addOnExpression(new AndExpression(equalsTo, inExpression));
                    plainSelect.addJoins(join);
                    addJoinTable(cmdbRelentityTable);
                    addEqualColumn(cmdbRelentityTableToCientityIdColumn, fromTableIdColumn);
                }

                Table attrCiTable = joinedTableMap.get("cientity_" + fromCi);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + fromCi).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column cmdbRelentityTableFromCientityIdColumn = new Column(cmdbRelentityTable, "from_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbRelentityTableFromCientityIdColumn);
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(equalsTo);
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, cmdbRelentityTableFromCientityIdColumn);
                }
                if (fromAttrId == null) {
                    if (fromAttr.startsWith("_")) {
                        fromAttr = fromAttr.substring(1);
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
            }
        } else {
            //非下拉框属性
//            	<resource id="resource_ipobject" ci="IPObject">
//                    <attr field="id" attr="_id"/>
//                    <attr field="name" attr="name"/>
//                    <attr field="ip" attr="ip"/>
//                    <attr field="type_id" attr="_typeId"/>
//                    <attr field="type_name" attr="_typeName"/>
//                    <attr field="type_label" attr="_typeLabel"/>
//                    <attr field="fcu" attr="_fcu"/>
//                    <attr field="fcd" attr="_fcd"/>
//                    <attr field="lcu" attr="_lcu"/>
//                    <attr field="lcd" attr="_lcd"/>
//                    <attr field="maintenance_window" attr="maintenance_window"/>
//                    <attr field="description" attr="description"/>
//                    <attr field="network_area" attr="network_area"/>
//                    <attr field="inspect_status" attr="_inspectStatus"/>
//                    <attr field="inspect_time" attr="_inspectTime"/>
//                    <attr field="monitor_status" attr="_monitorStatus"/>
//                    <attr field="monitor_time" attr="_monitorTime"/>
//                </resource>
            //例如ip属性
//            LEFT JOIN codedriver_develop_data.cmdb_442011534499840 cmdb_442011534499840_IPObject ON cmdb_442011534499840_IPObject.cientity_id = IPObject.id
            if (fromAttrId == null) {
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
                } else {

                }
                Column column = new Column(new Table("cientity_" + fromCi), fromAttr);
                plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(field)));
                return column;
            } else {
                Table attrCiTable = joinedTableMap.get("cientity_" + fromCi);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias("cientity_" + fromCi).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column fromTableIdColumn = new Column(mainTable, "id");
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(new EqualsTo(attrCiTableIdColumn, fromTableIdColumn));
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, fromTableIdColumn);
                }

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
        }
    }

}
