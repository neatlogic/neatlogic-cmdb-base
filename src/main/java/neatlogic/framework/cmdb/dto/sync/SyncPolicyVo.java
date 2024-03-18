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

package neatlogic.framework.cmdb.dto.sync;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.sync.ExpressionType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SyncPolicyVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型集合id", type = ApiParamType.LONG)
    private Long ciCollectionId;
    @EntityField(name = "集合名称", type = ApiParamType.STRING)
    private String collectionName;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @JSONField(serialize = false)
    private String conditionStr;
    @EntityField(name = "筛选条件", type = ApiParamType.JSONARRAY)
    private List<SyncConditionVo> conditionList;
    @JSONField(serialize = false)
    private CiVo ciVo;
    @EntityField(name = "定时策略", type = ApiParamType.JSONARRAY)
    private List<SyncScheduleVo> cronList;


    @JSONField(serialize = false)
    public Criteria getCriteria() {
        Criteria finalCriteria = new Criteria();
        if (CollectionUtils.isNotEmpty(this.getConditionList())) {
            List<Criteria> criteriaList = new ArrayList<>();
            for (SyncConditionVo conditionVo : this.getConditionList()) {
                if (StringUtils.isNotBlank(conditionVo.getExpression()) && StringUtils.isNotBlank(conditionVo.getValue()) && StringUtils.isNotBlank(conditionVo.getField())) {

                    if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.IS.getValue())) {
                        if (!(conditionVo.getFormatValue() instanceof String[])) {
                            Criteria c = Criteria.where(conditionVo.getField());
                            c.is(conditionVo.getFormatValue());
                            criteriaList.add(c);
                        } else {
                            String[] values = (String[]) conditionVo.getFormatValue();
                            List<Criteria> orCriteriaList = new ArrayList<>();
                            for (String v : values) {
                                v = v.trim();
                                Criteria c = Criteria.where(conditionVo.getField());
                                c.is(v);
                                orCriteriaList.add(c);
                            }
                            if (CollectionUtils.isNotEmpty(orCriteriaList)) {
                                finalCriteria.orOperator(orCriteriaList);
                            }
                        }
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.NE.getValue())) {
                        if (!(conditionVo.getFormatValue() instanceof String[])) {
                            Criteria c = Criteria.where(conditionVo.getField());
                            c.ne(conditionVo.getFormatValue());
                            criteriaList.add(c);
                        } else {
                            String[] values = (String[]) conditionVo.getFormatValue();
                            for (String v : values) {
                                v = v.trim();
                                Criteria c = Criteria.where(conditionVo.getField());
                                c.ne(v);
                                criteriaList.add(c);
                            }
                        }
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.IN.getValue())) {
                        if (!(conditionVo.getFormatValue() instanceof String[])) {
                            Criteria c = Criteria.where(conditionVo.getField());
                            Pattern pattern = Pattern.compile("^.*" + conditionVo.getFormatValue() + ".*$", Pattern.CASE_INSENSITIVE);
                            c.regex(pattern);
                            criteriaList.add(c);
                        } else {
                            String[] values = (String[]) conditionVo.getFormatValue();
                            List<Criteria> orCriteriaList = new ArrayList<>();
                            for (String v : values) {
                                v = v.trim();
                                Criteria c = Criteria.where(conditionVo.getField());
                                Pattern pattern = Pattern.compile("^.*" + v + ".*$", Pattern.CASE_INSENSITIVE);
                                c.regex(pattern);
                                orCriteriaList.add(c);
                            }
                            if (CollectionUtils.isNotEmpty(orCriteriaList)) {
                                finalCriteria.orOperator(orCriteriaList);
                            }
                        }
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.NOTIN.getValue())) {
                        if (!(conditionVo.getFormatValue() instanceof String[])) {
                            Criteria c = Criteria.where(conditionVo.getField());
                            Pattern pattern = Pattern.compile("^((?!" + conditionVo.getFormatValue() + ").)*$", Pattern.CASE_INSENSITIVE);
                            c.regex(pattern);
                            criteriaList.add(c);
                        } else {
                            String[] values = (String[]) conditionVo.getFormatValue();
                            for (String v : values) {
                                v = v.trim();
                                Criteria c = Criteria.where(conditionVo.getField());
                                Pattern pattern = Pattern.compile("^((?!" + v + ").)*$", Pattern.CASE_INSENSITIVE);
                                c.regex(pattern);
                                criteriaList.add(c);
                            }
                        }
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.GT.getValue())) {
                        Criteria c = Criteria.where(conditionVo.getField());
                        c.gt(conditionVo.getFormatValue());
                        criteriaList.add(c);
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.LT.getValue())) {
                        Criteria c = Criteria.where(conditionVo.getField());
                        c.lt(conditionVo.getFormatValue());
                        criteriaList.add(c);
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.GTE.getValue())) {
                        Criteria c = Criteria.where(conditionVo.getField());
                        c.gte(conditionVo.getFormatValue());
                        criteriaList.add(c);
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.LTE.getValue())) {
                        Criteria c = Criteria.where(conditionVo.getField());
                        c.lte(conditionVo.getFormatValue());
                        criteriaList.add(c);
                    }

                }
            }
            if (CollectionUtils.isNotEmpty(criteriaList)) {
                finalCriteria.andOperator(criteriaList);
            }
        }
        return finalCriteria;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCiCollectionId() {
        return ciCollectionId;
    }

    public void setCiCollectionId(Long ciCollectionId) {
        this.ciCollectionId = ciCollectionId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }


    public String getConditionStr() {
        if (StringUtils.isBlank(conditionStr) && CollectionUtils.isNotEmpty(conditionList)) {
            conditionStr = JSONObject.toJSONString(conditionList);
        }
        return conditionStr;
    }

    public void setConditionStr(String conditionStr) {
        this.conditionStr = conditionStr;
    }

    public List<SyncScheduleVo> getCronList() {
        return cronList;
    }

    public void setCronList(List<SyncScheduleVo> cronList) {
        this.cronList = cronList;
    }

    public List<SyncConditionVo> getConditionList() {
        if (CollectionUtils.isEmpty(conditionList) && StringUtils.isNotBlank(conditionStr)) {
            try {
                JSONArray list = JSONArray.parseArray(conditionStr);
                if (CollectionUtils.isNotEmpty(list)) {
                    conditionList = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        conditionList.add(JSONObject.parseObject(list.getJSONObject(i).toJSONString(), SyncConditionVo.class));
                    }
                }
            } catch (Exception ignored) {

            }
        }
        return conditionList;
    }

    public void setConditionList(List<SyncConditionVo> conditionList) {
        this.conditionList = conditionList;
    }

    public CiVo getCiVo() {
        return ciVo;
    }

    public void setCiVo(CiVo ciVo) {
        this.ciVo = ciVo;
    }
}
