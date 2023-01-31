/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.customview;

import neatlogic.framework.cmdb.enums.customview.RelType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.Objects;

public class CustomViewLinkVo implements Serializable {
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "连接类型", type = ApiParamType.LONG)
    private String joinType;
    @EntityField(name = "来源uuid", type = ApiParamType.STRING)
    private String fromUuid;
    @EntityField(name = "目标uuid", type = ApiParamType.STRING)
    private String toUuid;
    @EntityField(name = "来源类型", type = ApiParamType.ENUM, member = RelType.class)
    private String fromType;
    @EntityField(name = "目标类型", type = ApiParamType.ENUM, member = RelType.class)
    private String toType;
    @EntityField(name = "来源模型uuid", type = ApiParamType.STRING)
    private String fromCustomViewCiUuid;
    @EntityField(name = "目标模型uuid", type = ApiParamType.STRING)
    private String toCustomViewCiUuid;

    public CustomViewLinkVo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomViewLinkVo that = (CustomViewLinkVo) o;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    public CustomViewLinkVo(JSONObject jsonObj) {
        this.fromUuid = jsonObj.getString("source");
        this.toUuid = jsonObj.getString("target");
        this.joinType = jsonObj.getString("type");
        this.uuid = jsonObj.getString("uuid");
        this.name = jsonObj.getString("name");
    }


    public Long getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(Long customViewId) {
        this.customViewId = customViewId;
    }


    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getFromUuid() {
        return fromUuid;
    }

    public void setFromUuid(String fromUuid) {
        this.fromUuid = fromUuid;
    }

    public String getToUuid() {
        return toUuid;
    }

    public void setToUuid(String toUuid) {
        this.toUuid = toUuid;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getToType() {
        return toType;
    }

    public void setToType(String toType) {
        this.toType = toType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFromCustomViewCiUuid() {
        return fromCustomViewCiUuid;
    }

    public void setFromCustomViewCiUuid(String fromCustomViewCiUuid) {
        this.fromCustomViewCiUuid = fromCustomViewCiUuid;
    }

    public String getToCustomViewCiUuid() {
        return toCustomViewCiUuid;
    }

    public void setToCustomViewCiUuid(String toCustomViewCiUuid) {
        this.toCustomViewCiUuid = toCustomViewCiUuid;
    }

}
