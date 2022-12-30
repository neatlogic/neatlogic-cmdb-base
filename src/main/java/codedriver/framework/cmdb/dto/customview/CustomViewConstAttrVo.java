/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;

import java.io.Serializable;

public class CustomViewConstAttrVo implements Serializable {
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "视图模型uuid", type = ApiParamType.STRING)
    private String customViewCiUuid;
    @EntityField(name = "属性名称", type = ApiParamType.STRING)
    private String constName;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "别名", type = ApiParamType.STRING)
    private String alias;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort = 0;
    @EntityField(name = "是否隐藏", type = ApiParamType.INTEGER)
    private Integer isHidden = 0;
    @EntityField(name = "是否主键", type = ApiParamType.INTEGER)
    private Integer isPrimary = 0;

    public CustomViewConstAttrVo() {

    }

    public CustomViewConstAttrVo(Long _customViewId) {
        this.customViewId = _customViewId;
    }

    public CustomViewConstAttrVo(JSONObject jsonObj) {
        this.uuid = jsonObj.getString("uuid");
        JSONObject conf = jsonObj.getJSONObject("config");
        if (MapUtils.isNotEmpty(conf)) {
            this.constName = conf.getString("constName");
            this.alias = conf.getString("alias");
            this.name = conf.getString("name");
            this.isHidden = conf.getIntValue("isHidden");
            this.sort = conf.getIntValue("sort");
            this.isPrimary = conf.getIntValue("isPrimary");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName = constName;
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


    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Integer isPrimary) {
        this.isPrimary = isPrimary;
    }
}
