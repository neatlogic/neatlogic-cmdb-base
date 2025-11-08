/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.dto.group;

import java.io.Serializable;
import java.util.Objects;

public class CiEntityGroupVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;

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
