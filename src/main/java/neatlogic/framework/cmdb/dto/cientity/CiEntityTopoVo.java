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

package neatlogic.framework.cmdb.dto.cientity;

import java.util.List;

public class CiEntityTopoVo {
    private Long id;
    private Long ciId;
    private String name;
    private String ciIcon;

    private Long ciType;
    private Long relId;
    private String direction;

    private List<CiEntityTopoVo> relCiEntityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelId() {
        return relId;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public Long getCiType() {
        return ciType;
    }

    public void setCiType(Long ciType) {
        this.ciType = ciType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiIcon() {
        return ciIcon;
    }

    public void setCiIcon(String ciIcon) {
        this.ciIcon = ciIcon;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<CiEntityTopoVo> getRelCiEntityList() {
        return relCiEntityList;
    }

    public void setRelCiEntityList(List<CiEntityTopoVo> relCiEntityList) {
        this.relCiEntityList = relCiEntityList;
    }
}
