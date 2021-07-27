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
import java.util.Optional;

public class SyncConfigVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "MongoDb集合名", type = ApiParamType.STRING)
    private String collectionName;
    @JSONField(serialize = false)
    private transient String conditionStr;
    @EntityField(name = "cron列表", type = ApiParamType.JSONARRAY)
    private JSONArray cronList;
    @JSONField(serialize = false)
    private transient String cronListStr;
    @EntityField(name = "字段映射配置", type = ApiParamType.JSONARRAY)
    private List<SyncMappingVo> mappingList;
    @JSONField(serialize = false)
    private transient String mappingStr;
    @EntityField(name = "筛选条件", type = ApiParamType.JSONARRAY)
    private List<SyncConditionVo> conditionList;
    @JSONField(serialize = false)
    private transient CiVo ciVo;


    @JSONField(serialize = false)
    public Query getQuery() {
        if (CollectionUtils.isNotEmpty(this.getConditionList())) {
            Query query = new Query();
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
            return query;
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
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

    public List<SyncMappingVo> getMappingList() {
        if (CollectionUtils.isEmpty(mappingList) && StringUtils.isNotBlank(mappingStr)) {
            try {
                JSONArray list = JSONArray.parseArray(mappingStr);
                if (CollectionUtils.isNotEmpty(list)) {
                    mappingList = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
                        mappingList.add(JSONObject.parseObject(list.getJSONObject(i).toJSONString(), SyncMappingVo.class));
                    }
                }
            } catch (Exception ignored) {

            }
        }
        return mappingList;
    }

    public void setMappingList(List<SyncMappingVo> mappingList) {
        this.mappingList = mappingList;
    }

    /**
     * 根据属性id找到映射配置
     *
     * @param attrId 属性id
     * @return 映射配置
     */
    public SyncMappingVo getMappingByAttrId(Long attrId) {
        if (CollectionUtils.isNotEmpty(this.getMappingList())) {
            Optional<SyncMappingVo> op = this.getMappingList().stream().filter(m -> m.getAttrId() != null && m.getAttrId().equals(attrId)).findFirst();
            if (op.isPresent()) {
                return op.get();
            }
        }
        return null;
    }

    public String getMappingStr() {
        if (StringUtils.isBlank(mappingStr) && CollectionUtils.isNotEmpty(mappingList)) {
            mappingStr = JSONObject.toJSONString(mappingList);
        }
        return mappingStr;
    }

    public void setMappingStr(String mappingStr) {
        this.mappingStr = mappingStr;
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
