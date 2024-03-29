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
import neatlogic.framework.cmdb.enums.resourcecenter.JoinType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Objects;

public class ResourceEntityAttrVo {
    @EntityField(name = "资源实体名称", type = ApiParamType.STRING)
    private String entity;
    @EntityField(name = "视图字段名", type = ApiParamType.STRING)
    private String field;
    @EntityField(name = "模型属性名", type = ApiParamType.STRING)
    private String attr;
    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "模型名称", type = ApiParamType.STRING)
    private String ciName;
    @JSONField(serialize = false)
    private String tableAlias;//表别名
    @EntityField(name = "关联类型，attr或rel，不同类型join的表不一样", type = ApiParamType.ENUM, member = JoinType.class)
    private JoinType joinType;
    private CiVo ci;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceEntityAttrVo that = (ResourceEntityAttrVo) o;
        return Objects.equals(field, that.field) && Objects.equals(ciId, that.ciId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, ciId);
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
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

    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public CiVo getCi() {
        return ci;
    }

    public void setCi(CiVo ci) {
        this.ci = ci;
    }
}
