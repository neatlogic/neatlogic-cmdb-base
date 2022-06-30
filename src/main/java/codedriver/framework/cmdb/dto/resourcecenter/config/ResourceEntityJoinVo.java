/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.cmdb.enums.resourcecenter.JoinType;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Objects;

public class ResourceEntityJoinVo {
    private final JoinType joinType;
    private String field;
    private String ciName;
    private String direction = RelDirectionType.FROM.getValue();
    @JSONField(serialize = false)
    private CiVo ci;
    private String joinAttrName;
    public ResourceEntityJoinVo(JoinType _joinType) {
        joinType = _joinType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceEntityJoinVo that = (ResourceEntityJoinVo) o;
        return joinType == that.joinType && Objects.equals(ciName, that.ciName) && direction.equals(that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinType, ciName, direction);
    }

    public JoinType getJoinType() {
        return joinType;
    }


    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public CiVo getCi() {
        return ci;
    }

    public void setCi(CiVo ci) {
        this.ci = ci;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getJoinAttrName() {
        return joinAttrName;
    }

    public void setJoinAttrName(String joinAttrName) {
        this.joinAttrName = joinAttrName;
    }
}
