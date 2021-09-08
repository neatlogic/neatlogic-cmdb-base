/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.group;

import java.util.Objects;

public class CiEntityGroupVo {
    private Long groupId;
    private Long ciEntityId;
    private Long ciGroupId;

    public CiEntityGroupVo() {
    }


    public CiEntityGroupVo(Long ciEntityId, Long groupId, Long ciGroupId) {
        this.ciEntityId = ciEntityId;
        this.groupId = groupId;
        this.ciGroupId = ciGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiEntityGroupVo that = (CiEntityGroupVo) o;
        return groupId.equals(that.groupId) && ciEntityId.equals(that.ciEntityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, ciEntityId);
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public Long getCiGroupId() {
        return ciGroupId;
    }

    public void setCiGroupId(Long ciGroupId) {
        this.ciGroupId = ciGroupId;
    }
}
