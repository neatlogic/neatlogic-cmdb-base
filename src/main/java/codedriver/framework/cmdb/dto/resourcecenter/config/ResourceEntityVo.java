/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.enums.resourcecenter.Status;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ResourceEntityVo {
    @EntityField(name = "对象唯一标识（视图名）", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "对象名称", type = ApiParamType.STRING)
    private String label;
    @JSONField(serialize = false)
    private transient CiVo ci;//对应的模型
    @EntityField(name = "属性列表", type = ApiParamType.JSONARRAY)
    private Set<ResourceEntityAttrVo> attrList;
    @EntityField(name = "连接列表", type = ApiParamType.JSONARRAY)
    private Set<ResourceEntityJoinVo> joinList;
    @EntityField(name = "状态", type = ApiParamType.ENUM, member = Status.class)
    private String status = "";
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusText;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private String error;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceEntityVo that = (ResourceEntityVo) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void addJoin(ResourceEntityJoinVo join) {
        if (joinList == null) {
            joinList = new HashSet<>();
        }
        joinList.add(join);
    }

    public void addAttr(ResourceEntityAttrVo attr) {
        if (attrList == null) {
            attrList = new HashSet<>();
        }
        attrList.add(attr);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        if (StringUtils.isBlank(statusText) && StringUtils.isNotBlank(status)) {
            statusText = Status.getText(status);
        }
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public Set<ResourceEntityAttrVo> getAttrList() {
        return attrList;
    }

    public void setAttrList(Set<ResourceEntityAttrVo> attrList) {
        this.attrList = attrList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Set<ResourceEntityJoinVo> getJoinList() {
        return joinList;
    }

    public void setJoinList(Set<ResourceEntityJoinVo> joinList) {
        this.joinList = joinList;
    }


    public CiVo getCi() {
        return ci;
    }

    public void setCi(CiVo ci) {
        this.ci = ci;
    }
}
