/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

import codedriver.framework.cmdb.enums.resourcecenter.JoinType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Objects;

public class ResourceEntityAttrVo {
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
    private transient String tableAlias;//表别名
    //@EntityField(name = "连接查询时左边字段在视图中的字段名", type = ApiParamType.STRING)
    //private String fromField;
    //@EntityField(name = "连接查询时左边模型名", type = ApiParamType.STRING)
    // private String fromCiName;
    //@EntityField(name = "连接查询时左边id", type = ApiParamType.LONG)
    //private Long fromCiId;
    //@EntityField(name = "连接查询时右边字段在视图中的字段名", type = ApiParamType.STRING)
    //private String toField;
    //@EntityField(name = "连接查询时右边模型名", type = ApiParamType.STRING)
    //private String toCiName;
    //@EntityField(name = "连接查询时右边模型id", type = ApiParamType.LONG)
    //private Long toCiId;
    @EntityField(name = "关联类型，attr或rel，不同类型join的表不一样", type = ApiParamType.ENUM, member = JoinType.class)
    private JoinType joinType;

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
/*
    public String getFromField() {
        return fromField;
    }

    public void setFromField(String fromField) {
        this.fromField = fromField;
    }

    public String getFromCiName() {
        return fromCiName;
    }

    public void setFromCiName(String fromCiName) {
        this.fromCiName = fromCiName;
    }

    public Long getFromCiId() {
        return fromCiId;
    }

    public void setFromCiId(Long fromCiId) {
        this.fromCiId = fromCiId;
    }

    public String getToField() {
        return toField;
    }

    public void setToField(String toField) {
        this.toField = toField;
    }

    public String getToCiName() {
        return toCiName;
    }

    public void setToCiName(String toCiName) {
        this.toCiName = toCiName;
    }

    public Long getToCiId() {
        return toCiId;
    }

    public void setToCiId(Long toCiId) {
        this.toCiId = toCiId;
    }*/

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
}
