/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.enums.resourcecenter.JoinType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;

public class SceneEntityAttrVo {

    @EntityField(name = "视图字段名", type = ApiParamType.STRING)
    private String field;
    @EntityField(name = "模型属性名", type = ApiParamType.STRING)
    private String attr;
    @EntityField(name = "模型属性名", type = ApiParamType.STRING)
    private String fromAttr;
    @EntityField(name = "模型属性名", type = ApiParamType.STRING)
    private String toAttr;
    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
    private Long fromAttrId;
    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
    private Long toAttrId;
    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
    private Long toAttrCiId;
    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
    private Long fromAttrCiId;
    @EntityField(name = "模型属性id", type = ApiParamType.STRING)
    private String toAttrCiName;
    @EntityField(name = "模型属性id", type = ApiParamType.STRING)
    private String fromAttrCiName;
    private Integer toCiIsVirtual;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "模型名称", type = ApiParamType.STRING)
    private String ciName;
    @EntityField(name = "模型名称", type = ApiParamType.STRING)
    private String fromCi;
    @EntityField(name = "模型名称", type = ApiParamType.STRING)
    private String toCi;
    @EntityField(name = "模型名称", type = ApiParamType.LONG)
    private Long fromCiId;
    @EntityField(name = "模型名称", type = ApiParamType.LONG)
    private Long toCiId;
    @EntityField(name = "关联类型，attr或rel，不同类型join的表不一样", type = ApiParamType.ENUM, member = JoinType.class)
    private JoinType joinType;
    @JSONField(serialize = false)
    private CiVo ci;
    @JSONField(serialize = false)
    private CiVo fromCiVo;
    @JSONField(serialize = false)
    private CiVo toCiVo;
    @EntityField(name = "字段所在视图名", type = ApiParamType.STRING)
    private String resource;
//    private String direction = RelDirectionType.FROM.getValue();
    private String direction;
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SceneEntityAttrVo that = (SceneEntityAttrVo) o;
//        return Objects.equals(field, that.field) && Objects.equals(ciId, that.ciId);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(field, ciId);
//    }

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

    public String getFromAttr() {
        return fromAttr;
    }

    public void setFromAttr(String fromAttr) {
        this.fromAttr = fromAttr;
    }

    public String getToAttr() {
        return toAttr;
    }

    public void setToAttr(String toAttr) {
        this.toAttr = toAttr;
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

    public CiVo getCi() {
        return ci;
    }

    public void setCi(CiVo ci) {
        this.ci = ci;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getFromCi() {
        return fromCi;
    }

    public void setFromCi(String fromCi) {
        this.fromCi = fromCi;
    }

    public String getToCi() {
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

    public Long getFromAttrId() {
        return fromAttrId;
    }

    public void setFromAttrId(Long fromAttrId) {
        this.fromAttrId = fromAttrId;
    }

    public Long getToAttrId() {
        return toAttrId;
    }

    public void setToAttrId(Long toAttrId) {
        this.toAttrId = toAttrId;
    }

    public Long getToAttrCiId() {
        return toAttrCiId;
    }

    public void setToAttrCiId(Long toAttrCiId) {
        this.toAttrCiId = toAttrCiId;
    }

    public Integer getToCiIsVirtual() {
        return toCiIsVirtual;
    }

    public void setToCiIsVirtual(Integer toCiIsVirtual) {
        this.toCiIsVirtual = toCiIsVirtual;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getFromAttrCiId() {
        return fromAttrCiId;
    }

    public void setFromAttrCiId(Long fromAttrCiId) {
        this.fromAttrCiId = fromAttrCiId;
    }

    public String getToAttrCiName() {
        return toAttrCiName;
    }

    public void setToAttrCiName(String toAttrCiName) {
        this.toAttrCiName = toAttrCiName;
    }

    public String getFromAttrCiName() {
        return fromAttrCiName;
    }

    public void setFromAttrCiName(String fromAttrCiName) {
        this.fromAttrCiName = fromAttrCiName;
    }

    public Long getFromCiId() {
        return fromCiId;
    }

    public void setFromCiId(Long fromCiId) {
        this.fromCiId = fromCiId;
    }

    public Long getToCiId() {
        return toCiId;
    }

    public void setToCiId(Long toCiId) {
        this.toCiId = toCiId;
    }
}
