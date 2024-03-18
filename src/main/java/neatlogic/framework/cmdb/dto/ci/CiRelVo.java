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

package neatlogic.framework.cmdb.dto.ci;

import neatlogic.framework.cmdb.enums.RelDirectionType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Objects;

/*
配置视图的关系路径数据，只会记录当前模型和关系的关键信息，由于只会沿着一个防线追溯，因此无需保存方向信息
 */
public class CiRelVo {
    private Long ciId;
    private String ciName;
    private String ciLabel;
    private Long relId;
    private String relName;
    private String relLabel;
    @EntityField(name = "关系方向", type = ApiParamType.ENUM, member = RelDirectionType.class)
    private String direction;

    public CiRelVo() {

    }


    public CiRelVo(Long _ciId) {
        ciId = _ciId;
    }

    public CiRelVo(Long _ciId, Long _relId) {
        ciId = _ciId;
        relId = _relId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiRelVo ciRelVo = (CiRelVo) o;
        return ciId.equals(ciRelVo.ciId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciId);
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public String getCiLabel() {
        return ciLabel;
    }

    public void setCiLabel(String ciLabel) {
        this.ciLabel = ciLabel;
    }

    public String getRelLabel() {
        return relLabel;
    }

    public void setRelLabel(String relLabel) {
        this.relLabel = relLabel;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
