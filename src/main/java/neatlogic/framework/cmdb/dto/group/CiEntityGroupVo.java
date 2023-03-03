/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
