/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

public class CustomViewAttrVo {
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "视图模型uuid", type = ApiParamType.STRING)
    private String customViewCiUuid;
    @EntityField(name = "属性id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "别名", type = ApiParamType.STRING)
    private String alias;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort = 0;
    @EntityField(name = "条件", type = ApiParamType.JSONOBJECT)
    private JSONObject condition;
    @JSONField(serialize = false)
    private transient String conditionStr;
    @EntityField(name = "是否隐藏", type = ApiParamType.INTEGER)
    private Integer isHidden = 0;
    @JSONField(serialize = false)
    private transient AttrVo attrVo;

    public CustomViewAttrVo() {

    }

    public CustomViewAttrVo(JSONObject jsonObj) {
        this.uuid = jsonObj.getString("uuid");
        JSONObject conf = jsonObj.getJSONObject("config");
        if (MapUtils.isNotEmpty(conf)) {
            this.attrId = conf.getLong("attrId");
            this.alias = conf.getString("alias");
            this.isHidden = conf.getIntValue("isHidden");
        }
    }


    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public AttrVo getAttrVo() {
        return attrVo;
    }

    public void setAttrVo(AttrVo attrVo) {
        this.attrVo = attrVo;
    }

    public Long getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(Long customViewId) {
        this.customViewId = customViewId;
    }

    public String getCustomViewCiUuid() {
        return customViewCiUuid;
    }

    public void setCustomViewCiUuid(String customViewCiUuid) {
        this.customViewCiUuid = customViewCiUuid;
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
        if (condition != null && StringUtils.isBlank(conditionStr)) {
            conditionStr = condition.toJSONString();
        }
        return conditionStr;
    }

    public void setConditionStr(String conditionStr) {
        this.conditionStr = conditionStr;
    }

    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }
}
