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
import neatlogic.framework.cmdb.crossover.ICiCrossoverMapper;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.condition.dto.ConditionBaseVo;
import neatlogic.framework.condition.dto.ConditionConfigBaseVo;
import neatlogic.framework.condition.dto.ConditionGroupBaseVo;
import neatlogic.framework.condition.dto.RelVo;
import neatlogic.framework.crossover.CrossoverServiceFactory;
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
                        if (Objects.equals(name, "typeIdList")) {
                            filterItemFieldNameSet.add("type_id");
                        } else if (Objects.equals(name, "appSystemIdList")) {
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
        } else if (CollectionUtils.isNotEmpty(conditionGroupList)) {
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
            } else if (CollectionUtils.isNotEmpty(conditionList)) {
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
            if (Objects.equals(name, "typeIdList")) {
                columnName = fieldName2ColumnMap.get("type_id").toString();
                List<Long> typeIdList = convertLongList(valueList);
                ICiCrossoverMapper ciCrossoverMapper = CrossoverServiceFactory.getApi(ICiCrossoverMapper.class);
                Set<Long> ciIdSet = new HashSet<>();
                for (Long ciId : typeIdList) {
                    CiVo ciVo = ciCrossoverMapper.getCiById(ciId);
                    if (ciVo != null) {
                        List<CiVo> ciList = ciCrossoverMapper.getDownwardCiListByLR(ciVo.getLft(), ciVo.getRht());
                        List<Long> ciIdList = ciList.stream().map(CiVo::getId).toList();
                        ciIdSet.addAll(ciIdList);
                    }
                }
                valueVo = $sql.value(new ArrayList<>(ciIdSet));
            } else if (Objects.equals(name, "appSystemIdList")) {
                columnName = fieldName2ColumnMap.get("app_system_id").toString();
                valueVo = $sql.value(convertLongList(valueList));
            } else if (Objects.equals(name, "appModuleIdList")) {
                columnName = fieldName2ColumnMap.get("app_module_id").toString();
                valueVo = $sql.value(convertLongList(valueList));
            } else if (Objects.equals(name, "envIdList")) {
                columnName = fieldName2ColumnMap.get("env_id").toString();
                valueVo = $sql.value(convertLongList(valueList));
            } else if (Objects.equals(name, "inspectStatusList")) {
                columnName = fieldName2ColumnMap.get("inspect_status").toString();
                valueVo = $sql.value(convertStringList(valueList));
            } else if (Objects.equals(name, "ip")) {
                columnName = fieldName2ColumnMap.get("ip").toString();
                if (valueList instanceof JSONArray valueArray) {
                    if (CollectionUtils.isNotEmpty(valueArray)) {
                        valueVo = $sql.value(valueArray.getString(0));
                    }
                } else if (valueList != null) {
                    valueVo = $sql.value(valueList.toString());
                }
            } else if (Objects.equals(name, "name")) {
                columnName = fieldName2ColumnMap.get("name").toString();
                if (valueList instanceof JSONArray valueArray) {
                    if (CollectionUtils.isNotEmpty(valueArray)) {
                        valueVo = $sql.value(valueArray.getString(0));
                    }
                } else if (valueList != null) {
                    valueVo = $sql.value(valueList.toString());
                }
            } else if (Objects.equals(name, "vendorIdList")) {
                columnName = fieldName2ColumnMap.get("vendor_id").toString();
                valueVo = $sql.value(convertLongList(valueList));
            } else if (Objects.equals(name, "tagIdList")) {
                sqlVo.withAddJoin($sql.join("left join", "cmdb_resourcecenter_resource_tag", "d").withOn($sql.exp("d.resource_id", "=", fieldName2ColumnMap.get("id").toString())));
                columnName = "d.tag_id";
                valueVo = $sql.value(convertLongList(valueList));
            } else if (Objects.equals(name, "protocolIdList")) {
                sqlVo.withAddJoin($sql.join("left join", "cmdb_resourcecenter_resource_account", "b").withOn($sql.exp("b.resource_id", "=", fieldName2ColumnMap.get("id").toString())));
                sqlVo.withAddJoin($sql.join("left join", "cmdb_resourcecenter_account", "c").withOn($sql.exp("c.id", "=", "b.account_id")));
                columnName = "c.protocol_id";
                valueVo = $sql.value(convertLongList(valueList));
            } else if (Objects.equals(name, "stateIdList")) {
                columnName = fieldName2ColumnMap.get("state_id").toString();
                valueVo = $sql.value(convertLongList(valueList));
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
                } else if (Objects.equals(expression, "like")) {
                    String str = null;
                    if (valueVo != null) {
                        str = valueVo.getStrValue();
                    }
                    if (StringUtils.isNotBlank(str)) {
                        str = "'" + str + "%'";
                    }
                    return $sql.exp(columnName, "like", str);
                } else if (Objects.equals(expression, "notlike")) {
                    String str = null;
                    if (valueVo != null) {
                        str = valueVo.getStrValue();
                    }
                    if (StringUtils.isNotBlank(str)) {
                        str = "'" + str + "%'";
                    }
                    return $sql.exp(columnName, "not like", str);
                }
            }
            return null;
        }

        private List<Long> convertLongList(Object valueList) {
            List<Long> list = new ArrayList<>();
            if (valueList instanceof JSONArray valueArray) {
                for (int i = 0; i < valueArray.size(); i++) {
                    Long id = valueArray.getLong(i);
                    if (id != null) {
                        list.add(id);
                    }
                }
            }
            return list;
        }

        private List<String> convertStringList(Object valueList) {
            List<String> list = new ArrayList<>();
            if (valueList instanceof JSONArray valueArray) {
                for (int i = 0; i < valueArray.size(); i++) {
                    String id = valueArray.getString(i);
                    if (id != null) {
                        list.add(id);
                    }
                }
            }
            return list;
        }
    }
}
