/*
 * Copyright(c) 2024 NeatLogic Co., Ltd. All Rights Reserved.
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
