/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.dto.group;

import java.io.Serializable;
import java.util.Objects;

public class CiEntityGroupVo implements Serializable {
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
