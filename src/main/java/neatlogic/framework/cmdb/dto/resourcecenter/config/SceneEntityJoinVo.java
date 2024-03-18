/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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
import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.resourcecenter.JoinType;

import java.util.Objects;

public class SceneEntityJoinVo {
    private final JoinType joinType;
//    private String resource;
    private String field;
    private String direction;
    private String fromAttr;
    private String fromCi;
    private String toAttr;
    private String toCi;
    @JSONField(serialize = false)
    private CiVo fromCiVo;
    @JSONField(serialize = false)
    private CiVo toCiVo;
    @JSONField(serialize = false)
    private AttrVo fromAttrVo;

    public SceneEntityJoinVo(JoinType _joinType) {
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
        SceneEntityJoinVo that = (SceneEntityJoinVo) o;
        return Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getFromAttr() {
        return fromAttr;
    }

    public void setFromAttr(String fromAttr) {
        this.fromAttr = fromAttr;
    }

//    public String getResource() {
//        return resource;
//    }
//
//    public void setResource(String resource) {
//        this.resource = resource;
//    }

    public String getFromCi() {
        if (fromCi == null && fromCiVo != null) {
            fromCi = fromCiVo.getName();
        }
        return fromCi;
    }

    public void setFromCi(String fromCi) {
        this.fromCi = fromCi;
    }

    public String getToAttr() {
        return toAttr;
    }

    public void setToAttr(String toAttr) {
        this.toAttr = toAttr;
    }

    public String getToCi() {
        if (toCi == null && toCiVo != null) {
            toCi = toCiVo.getName();
        }
        return toCi;
    }

    public void setToCi(String toCi) {
        this.toCi = toCi;
    }

    public CiVo getFromCiVo() {
        return fromCiVo;
    }

    public void setFromCiVo(CiVo fromCiVo) {
        this.fromCiVo = fromCiVo;
    }

    public CiVo getToCiVo() {
        return toCiVo;
    }

    public void setToCiVo(CiVo toCiVo) {
        this.toCiVo = toCiVo;
    }


    public AttrVo getFromAttrVo() {
        return fromAttrVo;
    }

    public void setFromAttrVo(AttrVo fromAttrVo) {
        this.fromAttrVo = fromAttrVo;
    }
}
