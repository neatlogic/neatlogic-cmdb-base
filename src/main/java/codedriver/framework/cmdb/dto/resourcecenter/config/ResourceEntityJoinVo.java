/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.enums.resourcecenter.JoinType;

import java.util.Objects;

public class ResourceEntityJoinVo {
    private JoinType joinType;
    private String ciName;
    private transient CiVo ci;

    public ResourceEntityJoinVo(JoinType _joinType) {
        joinType = _joinType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceEntityJoinVo that = (ResourceEntityJoinVo) o;
        return joinType == that.joinType && ciName.equals(that.ciName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinType, ciName);
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
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
}
