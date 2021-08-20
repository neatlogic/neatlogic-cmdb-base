/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.sync;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.enums.sync.ExpressionType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

public class SyncPolicyVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型集合id", type = ApiParamType.LONG)
    private Long ciCollectionId;
    @EntityField(name = "集合名称", type = ApiParamType.STRING)
    private String collectionName;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @JSONField(serialize = false)
    private transient String conditionStr;
    @EntityField(name = "cron列表", type = ApiParamType.JSONARRAY)
    private JSONArray cronList;
    @JSONField(serialize = false)
    private transient String cronListStr;
    @EntityField(name = "筛选条件", type = ApiParamType.JSONARRAY)
    private List<SyncConditionVo> conditionList;
    @JSONField(serialize = false)
    private transient CiVo ciVo;


    @JSONField(serialize = false)
    public Query getQuery() {
        Query query = new Query();
        if (CollectionUtils.isNotEmpty(this.getConditionList())) {
            for (SyncConditionVo conditionVo : this.getConditionList()) {
                Criteria c = Criteria.where(conditionVo.getField());
                if (conditionVo.getExpression().equals(ExpressionType.IS.getValue())) {
                    c.all(conditionVo.getFormatValueList());
                } else if (conditionVo.getExpression().equals(ExpressionType.IN.getValue())) {
                    c.in(conditionVo.getFormatValueList());
                } else if (conditionVo.getExpression().equals(ExpressionType.GT.getValue())) {
                    c.gt(conditionVo.getFormatValue());
                } else if (conditionVo.getExpression().equals(ExpressionType.LT.getValue())) {
                    c.lt(conditionVo.getFormatValue());
                } else if (conditionVo.getExpression().equals(ExpressionType.GTE.getValue())) {
                    c.gte(conditionVo.getFormatValue());
                } else if (conditionVo.getExpression().equals(ExpressionType.LTE.getValue())) {
                    c.lte(conditionVo.getFormatValue());
                }
                query.addCriteria(c);
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

    public Long getId() {
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

    public JSONArray getCronList() {
        if (cronList == null && StringUtils.isNotBlank(cronListStr)) {
            try {
                cronList = JSONArray.parseArray(cronListStr);
            } catch (Exception ignored) {

            }
        }
        return cronList;
    }

    public void setCronList(JSONArray cronList) {
        this.cronList = cronList;
    }

    public String getCronListStr() {
        if (StringUtils.isBlank(cronListStr) && cronList != null) {
            cronListStr = cronList.toJSONString();
        }
        return cronListStr;
    }

    public void setCronListStr(String cronListStr) {
        this.cronListStr = cronListStr;
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
