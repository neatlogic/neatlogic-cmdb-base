/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.sync;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.enums.sync.ExpressionType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
    private transient String conditionStr;
    @EntityField(name = "筛选条件", type = ApiParamType.JSONARRAY)
    private List<SyncConditionVo> conditionList;
    @JSONField(serialize = false)
    private transient CiVo ciVo;
    @EntityField(name = "定时策略", type = ApiParamType.JSONARRAY)
    private List<SyncScheduleVo> cronList;


    @JSONField(serialize = false)
    public Query getQuery() {
        Query query = new Query();
        if (CollectionUtils.isNotEmpty(this.getConditionList())) {
            for (SyncConditionVo conditionVo : this.getConditionList()) {
                if (StringUtils.isNotBlank(conditionVo.getExpression()) && StringUtils.isNotBlank(conditionVo.getValue()) && StringUtils.isNotBlank(conditionVo.getField())) {
                    Criteria c = Criteria.where(conditionVo.getField());
                    if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.IS.getValue())) {
                        c.is(conditionVo.getFormatValue());
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.IN.getValue())) {
                        Pattern pattern = Pattern.compile("^.*" + conditionVo.getFormatValue() + ".*$", Pattern.CASE_INSENSITIVE);
                        c.regex(pattern);
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.GT.getValue())) {
                        c.gt(conditionVo.getFormatValue());
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.LT.getValue())) {
                        c.lt(conditionVo.getFormatValue());
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.GTE.getValue())) {
                        c.gte(conditionVo.getFormatValue());
                    } else if (conditionVo.getExpression().equalsIgnoreCase(ExpressionType.LTE.getValue())) {
                        c.lte(conditionVo.getFormatValue());
                    }
                    query.addCriteria(c);
                }
            }
        }
        return query;
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
