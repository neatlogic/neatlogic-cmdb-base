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

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.RelDirectionType;
import neatlogic.framework.cmdb.enums.resourcecenter.JoinType;

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
