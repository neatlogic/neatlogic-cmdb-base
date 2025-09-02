/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.cmdb.dto.resourcecenter;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.condition.dto.ConditionBaseVo;
import neatlogic.framework.condition.dto.ConditionConfigBaseVo;
import neatlogic.framework.condition.dto.ConditionGroupBaseVo;
import neatlogic.framework.condition.dto.RelVo;
import neatlogic.framework.sqlgenerator.$sql;
import neatlogic.framework.sqlgenerator.ExpressionVo;
import neatlogic.framework.sqlgenerator.SqlVo;
import neatlogic.framework.sqlgenerator.ValueVo;
import net.sf.jsqlparser.schema.Column;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class ResourceConditionConfigVo extends ConditionConfigBaseVo<ResourceConditionConfigVo.ConditionGroupVo<ResourceConditionConfigVo.ConditionVo>> {

    public List<String> getFilterItemFieldNameList() {
        Set<String> filterItemFieldNameSet = new HashSet<>();
        if (CollectionUtils.isNotEmpty(this.conditionGroupList)) {
            for (ConditionGroupVo<ConditionVo> conditionGroup : this.conditionGroupList) {
                if (CollectionUtils.isNotEmpty(conditionGroup.getConditionList())) {
                    for (ConditionVo condition : conditionGroup.getConditionList()) {
                        String name = condition.getName();
                        if (Objects.equals(name, "appSystemIdList")) {
                            filterItemFieldNameSet.add("app_system_id");
                            filterItemFieldNameSet.add("app_module_id");
                        } else if (Objects.equals(name, "appModuleIdList")) {
                            filterItemFieldNameSet.add("app_module_id");
                        } else if (Objects.equals(name, "envIdList")) {
                            filterItemFieldNameSet.add("env_id");
                        } else if (Objects.equals(name, "inspectStatusList")) {
                            filterItemFieldNameSet.add("inspect_status");
                        } else if (Objects.equals(name, "ip")) {
                            filterItemFieldNameSet.add("ip");
                        } else if (Objects.equals(name, "name")) {
                            filterItemFieldNameSet.add("name");
                        } else if (Objects.equals(name, "vendorIdList")) {
                            filterItemFieldNameSet.add("vendor_id");
                        } else if (Objects.equals(name, "tagIdList")) {
                            // ignore
                        } else if (Objects.equals(name, "protocolIdList")) {
                            // ignore
                        } else if (Objects.equals(name, "stateIdList")) {
                            filterItemFieldNameSet.add("state_id");
                        }
                    }
                }
            }
        }
        return new ArrayList<>(filterItemFieldNameSet);
    }

    public SqlVo buildConditionSqlVo(Map<String, Column> fieldName2ColumnMap) {
        SqlVo sqlVo = new SqlVo();
        buildConditionSqlVo(sqlVo, fieldName2ColumnMap);
        return sqlVo;
    }

    public void buildConditionSqlVo(SqlVo sqlVo, Map<String, Column> fieldName2ColumnMap) {
        ExpressionVo leftExpressionVo = null;
        if (CollectionUtils.isNotEmpty(this.conditionGroupRelList)) {
            boolean flag = false;
            for (RelVo conditionGroupRelVo : this.conditionGroupRelList) {
                if (leftExpressionVo == null) {
                    ConditionGroupVo<ConditionVo> conditionGroupVo = getConditionGroupByUuid(conditionGroupRelVo.getFrom());
                    if (conditionGroupVo != null) {
                        leftExpressionVo = conditionGroupVo.buildExpression(sqlVo, fieldName2ColumnMap);
                    }
                }
                ConditionGroupVo<ConditionVo> conditionGroupVo = getConditionGroupByUuid(conditionGroupRelVo.getTo());
                if (conditionGroupVo != null) {
                    ExpressionVo rightExpressionVo = conditionGroupVo.buildExpression(sqlVo, fieldName2ColumnMap);
                    if (rightExpressionVo != null) {
                        leftExpressionVo = $sql.exp(leftExpressionVo, conditionGroupRelVo.getJoinType(), rightExpressionVo);
                        flag = true;
                    }
                }
            }
            if (flag) {
                leftExpressionVo = $sql.exp("(", leftExpressionVo, ")");
            }
        } else {
            ConditionGroupVo<ConditionVo> conditionGroupVo = conditionGroupList.get(0);
            if (conditionGroupVo != null) {
                leftExpressionVo = conditionGroupVo.buildExpression(sqlVo, fieldName2ColumnMap);
            }
        }
        if (leftExpressionVo != null) {
            sqlVo.withAddWhereExpression(leftExpressionVo);
        }
    }

    public static class ConditionGroupVo<T extends ConditionBaseVo> extends ConditionGroupBaseVo<ConditionVo> {
        public ExpressionVo buildExpression(SqlVo sqlVo, Map<String, Column> fieldName2ColumnMap) {
            ExpressionVo leftExpressionVo = null;
            if (CollectionUtils.isNotEmpty(conditionRelList)) {
                boolean flag = false;
                for (RelVo conditionRelVo : conditionRelList) {
                    if (leftExpressionVo == null) {
                        ConditionVo conditionVo = getConditionByUuid(conditionRelVo.getFrom());
                        if (conditionVo != null) {
                            leftExpressionVo = conditionVo.buildExpression(sqlVo, fieldName2ColumnMap);
                        }
                    }
                    ConditionVo conditionVo = getConditionByUuid(conditionRelVo.getTo());
                    if (conditionVo != null) {
                        ExpressionVo rightExpressionVo = conditionVo.buildExpression(sqlVo, fieldName2ColumnMap);
                        if (rightExpressionVo != null) {
                            leftExpressionVo = $sql.exp(leftExpressionVo, conditionRelVo.getJoinType(), rightExpressionVo);
                            flag = true;
                        }
                    }
                }
                if (flag) {
                    leftExpressionVo = $sql.exp("(", leftExpressionVo, ")");
                }
            } else {
                ConditionVo conditionVo = conditionList.get(0);
                if (conditionVo != null) {
                    leftExpressionVo = conditionVo.buildExpression(sqlVo, fieldName2ColumnMap);
                }
            }
            return leftExpressionVo;
        }
    }

    public static class ConditionVo extends ConditionBaseVo {
        public ExpressionVo buildExpression(SqlVo sqlVo, Map<String, Column> fieldName2ColumnMap) {
            String columnName = null;
            ValueVo valueVo = null;
            if (Objects.equals(name, "appSystemIdList")) {
                columnName = fieldName2ColumnMap.get("app_system_id").toString();
                List<Long> appSystemIdList = new ArrayList<>();
                if (valueList instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) valueList;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Long id = jsonArray.getLong(i);
                        if (id != null) {
                            appSystemIdList.add(id);
                        }
                    }
                }
                valueVo = $sql.value(appSystemIdList);
            } else if (Objects.equals(name, "appModuleIdList")) {
                columnName = fieldName2ColumnMap.get("app_module_id").toString();
                List<Long> appModuleIdList = new ArrayList<>();
                if (valueList instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) valueList;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Long id = jsonArray.getLong(i);
                        if (id != null) {
                            appModuleIdList.add(id);
                        }
                    }
                }
                valueVo = $sql.value(appModuleIdList);
            } else if (Objects.equals(name, "envIdList")) {
                columnName = fieldName2ColumnMap.get("env_id").toString();
                List<Long> envIdList = new ArrayList<>();
                if (valueList instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) valueList;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Long id = jsonArray.getLong(i);
                        if (id != null) {
                            envIdList.add(id);
                        }
                    }
                }
                valueVo = $sql.value(envIdList);
            } else if (Objects.equals(name, "inspectStatusList")) {
                columnName = fieldName2ColumnMap.get("inspect_status").toString();
                List<String> inspectStatusList = new ArrayList<>();
                if (valueList instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) valueList;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        String inspectStatus = jsonArray.getString(i);
                        if (inspectStatus != null) {
                            inspectStatusList.add(inspectStatus);
                        }
                    }
                }
                valueVo = $sql.value(inspectStatusList);
            } else if (Objects.equals(name, "ip")) {
                columnName = fieldName2ColumnMap.get("ip").toString();
                valueVo = $sql.value(valueList.toString());
            } else if (Objects.equals(name, "name")) {
                columnName = fieldName2ColumnMap.get("name").toString();
                valueVo = $sql.value(valueList.toString());
            } else if (Objects.equals(name, "vendorIdList")) {
                columnName = fieldName2ColumnMap.get("vendor_id").toString();
                List<Long> vendorIdList = new ArrayList<>();
                if (valueList instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) valueList;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Long id = jsonArray.getLong(i);
                        if (id != null) {
                            vendorIdList.add(id);
                        }
                    }
                }
                valueVo = $sql.value(vendorIdList);
            } else if (Objects.equals(name, "tagIdList")) {
                sqlVo.withAddJoin($sql.join("left join", "cmdb_resourcecenter_resource_tag", "d").withOn($sql.exp("d.resource_id", "=", fieldName2ColumnMap.get("id").toString())));
                columnName = "d.tag_id";
                List<Long> tagIdList = new ArrayList<>();
                if (valueList instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) valueList;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Long id = jsonArray.getLong(i);
                        if (id != null) {
                            tagIdList.add(id);
                        }
                    }
                }
                valueVo = $sql.value(tagIdList);
            } else if (Objects.equals(name, "protocolIdList")) {
                sqlVo.withAddJoin($sql.join("left join", "cmdb_resourcecenter_resource_account", "b").withOn($sql.exp("b.resource_id", "=", fieldName2ColumnMap.get("id").toString())));
                sqlVo.withAddJoin($sql.join("left join", "cmdb_resourcecenter_account", "c").withOn($sql.exp("c.id", "=", "b.account_id")));
                columnName = "c.protocol_id";
                List<Long> protocolIdList = new ArrayList<>();
                if (valueList instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) valueList;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Long id = jsonArray.getLong(i);
                        if (id != null) {
                            protocolIdList.add(id);
                        }
                    }
                }
                valueVo = $sql.value(protocolIdList);
            } else if (Objects.equals(name, "stateIdList")) {
                columnName = fieldName2ColumnMap.get("state_id").toString();
                List<Long> stateIdList = new ArrayList<>();
                if (valueList instanceof JSONArray) {
                    JSONArray jsonArray = (JSONArray) valueList;
                    for (int i = 0; i < jsonArray.size(); i++) {
                        Long id = jsonArray.getLong(i);
                        if (id != null) {
                            stateIdList.add(id);
                        }
                    }
                }
                valueVo = $sql.value(stateIdList);
            }
            if (StringUtils.isNotBlank(columnName)) {
                if (Objects.equals(expression, "include")) {
                    return $sql.exp(columnName, "in", valueVo);
                } else if (Objects.equals(expression, "exclude")) {
                    return $sql.exp(columnName, "not in", valueVo);
                } else if (Objects.equals(expression, "equal")) {
                    return $sql.exp(columnName, "=", valueVo);
                } else if (Objects.equals(expression, "unequal")) {
                    return $sql.exp(columnName, "!=", valueVo);
                } else if (Objects.equals(expression, "is-null")) {
                    return $sql.exp(columnName, "is null");
                } else if (Objects.equals(expression, "is-not-null")) {
                    return $sql.exp(columnName, "is not null");
                }
            }
            return null;
        }
    }
}
