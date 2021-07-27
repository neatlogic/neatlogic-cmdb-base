/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.sync;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

public class SyncConfigVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "MongoDb集合名", type = ApiParamType.STRING)
    private String collectionName;
    @EntityField(name = "条件配置", type = ApiParamType.JSONOBJECT)
    private JSONObject condition;
    @JSONField(serialize = false)
    private transient String conditionStr;
    @EntityField(name = "cron列表", type = ApiParamType.JSONARRAY)
    private JSONArray cronList;
    @JSONField(serialize = false)
    private transient String cronListStr;
    @EntityField(name = "字段映射配置", type = ApiParamType.JSONOBJECT)
    private JSONObject mapping;
    @JSONField(serialize = false)
    private transient String mappingStr;

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

    public JSONObject getCondition() {
        if (condition == null && StringUtils.isNotBlank(conditionStr)) {
            try {
                condition = JSONObject.parseObject(conditionStr);
            } catch (Exception ignored) {

            }
        }
        return condition;
    }

    public void setCondition(JSONObject condition) {
        this.condition = condition;
    }

    public String getConditionStr() {
        if (StringUtils.isBlank(conditionStr) && condition != null) {
            conditionStr = condition.toJSONString();
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

    public JSONObject getMapping() {
        if (mapping == null && StringUtils.isNotBlank(mappingStr)) {
            try {
                mapping = JSONObject.parseObject(mappingStr);
            } catch (Exception ignored) {
            }
        }
        return mapping;
    }

    public void setMapping(JSONObject mapping) {
        this.mapping = mapping;
    }

    public String getMappingStr() {
        if (StringUtils.isBlank(mappingStr) && mapping != null) {
            mappingStr = mapping.toJSONString();
        }
        return mappingStr;
    }

    public void setMappingStr(String mappingStr) {
        this.mappingStr = mappingStr;
    }
}
