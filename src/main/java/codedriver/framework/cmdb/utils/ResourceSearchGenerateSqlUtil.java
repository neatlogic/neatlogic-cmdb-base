/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.utils;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.dto.resourcecenter.config.ResourceEntityAttrVo;
import codedriver.framework.cmdb.dto.resourcecenter.config.ResourceEntityJoinVo;
import codedriver.framework.cmdb.dto.resourcecenter.config.ResourceEntityVo;
import codedriver.framework.cmdb.dto.resourcecenter.config.ResourceInfo;
import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.cmdb.enums.resourcecenter.JoinType;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.GreaterThanEquals;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.MinorThanEquals;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.select.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class ResourceSearchGenerateSqlUtil {

    //保存资源中心数据初始化信息
    private final List<ResourceEntityVo> resourceEntityList;
    //sql语句中已经存在的表
    private Map<String, Table> joinedTableMap;
    //sql语句关联表中相等的列
    private Map<String, Column> equalColumnMap;

    public ResourceSearchGenerateSqlUtil(List<ResourceEntityVo> resourceEntityList) {
        this.resourceEntityList = resourceEntityList;
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
     * @param mainResourceId
     * @return
     */
    public PlainSelect initPlainSelectByMainResourceId(String mainResourceId) {
        CiVo mainCiVo = getCiByResourceId(mainResourceId);
        if (mainCiVo == null) {
            return null;
        }
        joinedTableMap = new HashMap<>();
        equalColumnMap = new HashMap<>();
        String mainTableAlias = mainCiVo.getName();
        Table mainTable = new Table("cmdb_cientity").withAlias(new Alias(mainTableAlias).withUseAs(false));
        PlainSelect plainSelect = new PlainSelect()
                .withFromItem(mainTable);
        addJoinTable(mainTable);
        Table cmdbCi = new Table("cmdb_ci").withAlias(new Alias("ci_" + mainTableAlias).withUseAs(false));
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
     * 根据资源id，从数据初始化配置信息中找到对应的模型
     * @param resourceId
     * @return
     */
    public CiVo getCiByResourceId(String resourceId) {
        for (ResourceEntityVo resourceEntityVo : resourceEntityList) {
            if (Objects.equals(resourceEntityVo.getName(), resourceId)) {
                return resourceEntityVo.getCi();
            }
        }
        return null;
    }

    /**
     * 从数据初始化信息中ResourceInfo补充信息
     * @param resourceInfo
     */
    public boolean additionalInformation(ResourceInfo resourceInfo) {
        for (ResourceEntityVo resourceEntityVo : resourceEntityList) {
            if (Objects.equals(resourceEntityVo.getName(), resourceInfo.getResourceName())) {
                if (StringUtils.isNotBlank(resourceEntityVo.getError())) {
                    return false;
                }
                CiVo ciVo = resourceEntityVo.getCi();
                if (ciVo == null) {
                   return false;
                }
                resourceInfo.setResourceCiName(ciVo.getName());
                resourceInfo.setResourceCiId(ciVo.getId());
                Set<ResourceEntityAttrVo> attrList = resourceEntityVo.getAttrList();
                for (ResourceEntityAttrVo resourceEntityAttrVo : attrList) {
                    if (Objects.equals(resourceEntityAttrVo.getField(), resourceInfo.getColumnName())) {
                        CiVo attrCiVo = resourceEntityAttrVo.getCi();
                        if (attrCiVo == null) {
                            attrCiVo = ciVo;
                        }
                        resourceInfo.setAttrCiVo(attrCiVo);
                        resourceInfo.setAttrCiName(attrCiVo.getName());
                        resourceInfo.setAttrCiId(attrCiVo.getId());
                        resourceInfo.setAttrCiIsVirtual(attrCiVo.getIsVirtual());
                        String attr = resourceEntityAttrVo.getAttr();
                        if ("_id".equals(attr)) {
                            resourceInfo.setAttrName("id");
                        } else if ("_uuid".equals(attr)) {
                            resourceInfo.setAttrName("uuid");
                        } else if ("_name".equals(attr)) {
                            resourceInfo.setAttrName("name");
                        } else if ("_fcu".equals(attr)) {
                            resourceInfo.setAttrName("fcu");
                        } else if ("_fcd".equals(attr)) {
                            resourceInfo.setAttrName("fcd");
                        } else if ("_lcu".equals(attr)) {
                            resourceInfo.setAttrName("lcu");
                        } else if ("_lcd".equals(attr)) {
                            resourceInfo.setAttrName("lcd");
                        } else if ("_inspectStatus".equals(attr)) {
                            resourceInfo.setAttrName("inspect_status");
                        } else if ("_inspectTime".equals(attr)) {
                            resourceInfo.setAttrName("inspect_time");
                        } else if ("_monitorStatus".equals(attr)) {
                            resourceInfo.setAttrName("monitor_status");
                        } else if ("_monitorTime".equals(attr)) {
                            resourceInfo.setAttrName("monitor_time");
                        } else if ("_typeId".equals(attr)) {
                            resourceInfo.setResourceCiName("ci_" + resourceEntityAttrVo.getCiName());
                            resourceInfo.setAttrName("id");
                        } else if ("_typeName".equals(attr)) {
                            resourceInfo.setResourceCiName("ci_" + resourceEntityAttrVo.getCiName());
                            resourceInfo.setAttrName("name");
                        } else if ("_typeLabel".equals(attr)) {
                            resourceInfo.setResourceCiName("ci_" + resourceEntityAttrVo.getCiName());
                            resourceInfo.setAttrName("label");
                        } else {
                            resourceInfo.setAttrName(attr);
                            if (resourceEntityAttrVo.getAttrId() != null) {
                                resourceInfo.setAttrId(resourceEntityAttrVo.getAttrId());
                                List<AttrVo> attrVoList = attrCiVo.getAttrList();
                                for (AttrVo attrVo : attrVoList) {
                                    if (Objects.equals(attrVo.getId(), resourceEntityAttrVo.getAttrId())) {
                                        resourceInfo.setAttrFromCiId(attrVo.getCiId());
                                    }
                                }
                            }
                        }
                        Set<ResourceEntityJoinVo> joinList = resourceEntityVo.getJoinList();
                        if (CollectionUtils.isNotEmpty(joinList)) {
                            for (ResourceEntityJoinVo joinVo : joinList) {
                                if (Objects.equals(joinVo.getCiName(), attrCiVo.getName())) {
                                    resourceInfo.setJoinType(joinVo.getJoinType());
                                    CiVo joinCiVo = joinVo.getCi();
                                    String joinAttrName = joinVo.getJoinAttrName();
                                    resourceInfo.setJoinAttrName(joinAttrName);
                                    if (joinVo.getJoinType() == JoinType.ATTR) {
                                        List<AttrVo> attrVoList = ciVo.getAttrList();
                                        for (AttrVo attrVo : attrVoList) {
                                            if (Objects.equals(attrVo.getName(), joinAttrName) && Objects.equals(attrVo.getTargetCiId(), joinCiVo.getId())) {
                                                resourceInfo.setJoinAttrName(joinAttrName);
                                                resourceInfo.setJoinAttrId(attrVo.getId());
                                            }
                                        }
                                    } else{
                                        resourceInfo.setDirection(joinVo.getDirection());
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 根据需要查询或过滤的列信息join表
     * @param resourceInfo
     * @param plainSelect
     * @return
     */
    public Column addJoinTableByResourceInfo(ResourceInfo resourceInfo, PlainSelect plainSelect) {
        Table mainTable = (Table) plainSelect.getFromItem();
        String attrCiName = resourceInfo.getAttrCiName();
        CiVo attrCiVo = resourceInfo.getAttrCiVo();
        String columnName = resourceInfo.getColumnName();
        Long attrId = resourceInfo.getAttrId();
        boolean left = resourceInfo.getLeft();
        if (resourceInfo.getJoinType() == JoinType.ATTR) {
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
            String resourceCiName = resourceInfo.getResourceCiName();
            Table resourceCiTable = getTableByAlias(resourceCiName);
            if (resourceCiTable == null) {
                resourceCiTable = new Table("cmdb_cientity").withAlias(new Alias(resourceCiName).withUseAs(false));
                Column resourceCiTableIdColumn = new Column(resourceCiTable, "id");
                Column mainTableIdColumn = new Column(mainTable, "id");
                EqualsTo equalsTo = new EqualsTo(resourceCiTableIdColumn, mainTableIdColumn);
                Join join = new Join().withLeft(left).withRightItem(resourceCiTable).addOnExpression(equalsTo);
                plainSelect.addJoins(join);
                addJoinTable(resourceCiTable);
                addEqualColumn(resourceCiTableIdColumn, mainTableIdColumn);
            }
            String joinAttrName = resourceInfo.getJoinAttrName();
            Table cmdbAttrentityTable = joinedTableMap.get("cmdb_attrentity_" + joinAttrName);
            if (cmdbAttrentityTable == null) {
                cmdbAttrentityTable = new Table("cmdb_attrentity").withAlias(new Alias("cmdb_attrentity_" + joinAttrName).withUseAs(false));
                Column cmdbAttrentityTableFromCientityIdColumn = new Column(cmdbAttrentityTable, "from_cientity_id");
                Column resourceCiTableIdColumn = new Column(resourceCiTable, "id");
                EqualsTo equalsTo1 = new EqualsTo(cmdbAttrentityTableFromCientityIdColumn, resourceCiTableIdColumn);
                EqualsTo equalsTo2 = new EqualsTo(new Column(cmdbAttrentityTable, "attr_id"), new LongValue(resourceInfo.getJoinAttrId()));
                Expression onExpression = new AndExpression(equalsTo1, equalsTo2);
                Join join = new Join().withLeft(left).withRightItem(cmdbAttrentityTable).addOnExpression(onExpression);
                plainSelect.addJoins(join);
                addJoinTable(cmdbAttrentityTable);
                addEqualColumn(cmdbAttrentityTableFromCientityIdColumn, resourceCiTableIdColumn);
            }

            if (Objects.equals(resourceInfo.getAttrCiIsVirtual(), 1)) {
                //属性模型是虚拟模型时
                Long attrCiId = resourceInfo.getAttrCiId();
                Table cmdbCiIdTable = joinedTableMap.get("cmdb_" + attrCiId + "_" + attrCiName);
                if (cmdbCiIdTable == null) {
                    cmdbCiIdTable = new Table(TenantContext.get().getDataDbName(), "cmdb_" + attrCiId)
                            .withAlias(new Alias("cmdb_" + attrCiId + "_" + attrCiName).withUseAs(false));
                    addJoinTable(cmdbCiIdTable);
                    Column cmdbCiIdTableIdColumn = new Column(cmdbCiIdTable, "id");
                    Column cmdbAttrentityTableToCientityIdColumn = new Column(cmdbAttrentityTable, "to_cientity_id");
                    Join join = new Join().withLeft(left).withRightItem(cmdbCiIdTable).addOnExpression(new EqualsTo(cmdbCiIdTableIdColumn, cmdbAttrentityTableToCientityIdColumn));
                    plainSelect.addJoins(join);
                    addEqualColumn(cmdbCiIdTableIdColumn, cmdbAttrentityTableToCientityIdColumn);
                }
                if (attrId == null) {
                    Column column = new Column(cmdbCiIdTable, resourceInfo.getAttrName());
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
                    return column;
                } else {
                    Column column = new Column(cmdbCiIdTable, "`" + attrId + "`");
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
                    return column;
                }
            } else {
                //属性模型是非虚拟模型时
                Table attrCiTable = joinedTableMap.get(attrCiName);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias(attrCiName).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column cmdbAttrentityTableToCientityIdColumn = new Column(cmdbAttrentityTable, "to_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbAttrentityTableToCientityIdColumn);
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(equalsTo);
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, cmdbAttrentityTableToCientityIdColumn);
                }
                if (attrId == null) {
                    Column column = new Column(attrCiTable, resourceInfo.getAttrName());
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
                    return column;
                } else {
                    String tableName = "cmdb_" + resourceInfo.getAttrFromCiId();
                    String tableAlias = tableName + "_" + attrCiName;
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
                    Column column = new Column(cmdbCiIdTable, "`" + attrId + "`");
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
                    return column;
                }
            }
        } else if (resourceInfo.getJoinType() == JoinType.REL) {
            //关系
            if (Objects.equals(resourceInfo.getDirection(), RelDirectionType.FROM.getValue())) {
                Table cmdbRelentityTable = joinedTableMap.get("cmdb_relentity_" + attrCiName);
                if (cmdbRelentityTable == null) {
                    cmdbRelentityTable = new Table("cmdb_relentity").withAlias(new Alias("cmdb_relentity_" + attrCiName).withUseAs(false));
                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable, "from_cientity_id");
                    Column fromTableIdColumn = new Column(new Table(resourceInfo.getResourceCiName()), "id");
                    Join join = new Join().withLeft(left).withRightItem(cmdbRelentityTable).addOnExpression(new EqualsTo(cmdbRelentityTableToCientityIdColumn, fromTableIdColumn));
                    plainSelect.addJoins(join);
                    addJoinTable(cmdbRelentityTable);
                    addEqualColumn(cmdbRelentityTableToCientityIdColumn, fromTableIdColumn);
                }

                Table attrCiTable = joinedTableMap.get(attrCiName);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias(attrCiName).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column cmdbRelentityTableFromCientityIdColumn = new Column(cmdbRelentityTable, "to_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbRelentityTableFromCientityIdColumn);

                    Column attrCiTableCiIdColumn = new Column(attrCiTable, "ci_id");
                    Table cmdbCi = new Table("cmdb_ci").withAlias(new Alias("ci_" + attrCiName).withUseAs(false));
                    Column cmdbCiLftColumn = new Column(cmdbCi, "lft");
                    Column cmdbCiRhtColumn = new Column(cmdbCi, "rht");
                    GreaterThanEquals greaterThanEquals = new GreaterThanEquals(">=").withLeftExpression(cmdbCiLftColumn).withRightExpression(new LongValue(attrCiVo.getLft()));
                    MinorThanEquals minorThanEquals = new MinorThanEquals("<=").withLeftExpression(cmdbCiRhtColumn).withRightExpression(new LongValue(attrCiVo.getRht()));
                    SubSelect subSelect = new SubSelect().withSelectBody(new PlainSelect().withFromItem(cmdbCi).addSelectItems(new SelectExpressionItem(new Column(cmdbCi, "id"))).withWhere(new AndExpression(greaterThanEquals, minorThanEquals)));
                    InExpression inExpression = new InExpression(attrCiTableCiIdColumn, subSelect);
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(new AndExpression(equalsTo, inExpression));
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, cmdbRelentityTableFromCientityIdColumn);
                }
                if (attrId == null) {
                    Column column = new Column(attrCiTable, resourceInfo.getAttrName());
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
                    return column;
                } else {
                    String tableName = "cmdb_" + resourceInfo.getAttrFromCiId();
                    String tableAlias = tableName + "_" + attrCiName;
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
                    Column column = new Column(cmdbCiIdTable, "`" + attrId + "`");
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
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
                Table cmdbRelentityTable = joinedTableMap.get("cmdb_relentity_" + attrCiName);
                if (cmdbRelentityTable == null) {
                    cmdbRelentityTable = new Table("cmdb_relentity").withAlias(new Alias("cmdb_relentity_" + attrCiName).withUseAs(false));
                    Column cmdbRelentityTableToCientityIdColumn = new Column(cmdbRelentityTable, "to_cientity_id");
                    Column fromTableIdColumn = new Column(new Table(resourceInfo.getResourceCiName()), "id");
                    Join join = new Join().withLeft(left).withRightItem(cmdbRelentityTable).addOnExpression(new EqualsTo(cmdbRelentityTableToCientityIdColumn, fromTableIdColumn));
                    plainSelect.addJoins(join);
                    addJoinTable(cmdbRelentityTable);
                    addEqualColumn(cmdbRelentityTableToCientityIdColumn, fromTableIdColumn);
                }

                Table attrCiTable = joinedTableMap.get(attrCiName);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias(attrCiName).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column cmdbRelentityTableFromCientityIdColumn = new Column(cmdbRelentityTable, "from_cientity_id");
                    EqualsTo equalsTo = new EqualsTo(attrCiTableIdColumn, cmdbRelentityTableFromCientityIdColumn);

                    Column attrCiTableCiIdColumn = new Column(attrCiTable, "ci_id");
                    Table cmdbCi = new Table("cmdb_ci").withAlias(new Alias("ci_" + attrCiName).withUseAs(false));
                    Column cmdbCiLftColumn = new Column(cmdbCi, "lft");
                    Column cmdbCiRhtColumn = new Column(cmdbCi, "rht");
                    GreaterThanEquals greaterThanEquals = new GreaterThanEquals(">=").withLeftExpression(cmdbCiLftColumn).withRightExpression(new LongValue(attrCiVo.getLft()));
                    MinorThanEquals minorThanEquals = new MinorThanEquals("<=").withLeftExpression(cmdbCiRhtColumn).withRightExpression(new LongValue(attrCiVo.getRht()));
                    SubSelect subSelect = new SubSelect().withSelectBody(new PlainSelect().withFromItem(cmdbCi).addSelectItems(new SelectExpressionItem(new Column(cmdbCi, "id"))).withWhere(new AndExpression(greaterThanEquals, minorThanEquals)));
                    InExpression inExpression = new InExpression(attrCiTableCiIdColumn, subSelect);
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(new AndExpression(equalsTo, inExpression));
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, cmdbRelentityTableFromCientityIdColumn);
                }
                if (attrId == null) {
                    Column column = new Column(attrCiTable, resourceInfo.getAttrName());
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
                    return column;
                } else {
                    String tableName = "cmdb_" + resourceInfo.getAttrFromCiId();
                    String tableAlias = tableName + "_" + attrCiName;
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
                    Column column = new Column(cmdbCiIdTable, "`" + attrId + "`");
                    plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
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
            if (attrId == null) {
                Column column = new Column(new Table(resourceInfo.getResourceCiName()), resourceInfo.getAttrName());
                plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
                return column;
            } else {
                Table attrCiTable = joinedTableMap.get(attrCiName);
                if (attrCiTable == null) {
                    attrCiTable = new Table("cmdb_cientity").withAlias(new Alias(attrCiName).withUseAs(false));
                    Column attrCiTableIdColumn = new Column(attrCiTable, "id");
                    Column fromTableIdColumn = new Column(mainTable, "id");
                    Join join = new Join().withLeft(left).withRightItem(attrCiTable).addOnExpression(new EqualsTo(attrCiTableIdColumn, fromTableIdColumn));
                    plainSelect.addJoins(join);
                    addJoinTable(attrCiTable);
                    addEqualColumn(attrCiTableIdColumn, fromTableIdColumn);
                }

                String tableName = "cmdb_" + resourceInfo.getAttrFromCiId();
                String tableAlias = tableName + "_" + resourceInfo.getAttrCiName();
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
                Column column = new Column(cmdbCiIdTable, "`" + attrId + "`");
                plainSelect.addSelectItems(new SelectExpressionItem(column).withAlias(new Alias(columnName)));
                return column;
            }
        }
    }
}
