/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.resourcecenter.JoinType;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Objects;

public class SceneEntityJoinVo {
    private final JoinType joinType;
    private String resource;
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

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
