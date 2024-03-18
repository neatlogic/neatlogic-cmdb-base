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
