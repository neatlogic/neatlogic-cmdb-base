/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.cmdb.enums.resourcecenter.JoinType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;

public class SceneEntityJoinVo {
    private final JoinType joinType;
    @EntityField(name = "字段所在视图名", type = ApiParamType.STRING)
    private String resource;
    private String field;
    private String ciName;
//    private String direction = RelDirectionType.FROM.getValue();
    private String direction;
    private String fromAttr;
    private String fromCi;
    private String toAttr;
    private String toCi;
    @JSONField(serialize = false)
    private CiVo fromCiVo;
    @JSONField(serialize = false)
    private CiVo toCiVo;
    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
    private Long fromAttrId;
//    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
//    private Long toAttrId;
//    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
//    private Long toAttrCiId;
    @EntityField(name = "模型属性id", type = ApiParamType.LONG)
    private Long fromAttrCiId;
//    @EntityField(name = "模型属性id", type = ApiParamType.STRING)
//    private String toAttrCiName;
    @EntityField(name = "模型属性id", type = ApiParamType.STRING)
    private String fromAttrCiName;
//    private Integer toCiIsVirtual;
    public SceneEntityJoinVo(JoinType _joinType) {
        joinType = _joinType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        SceneEntityJoinVo that = (SceneEntityJoinVo) o;
//        return joinType == that.joinType && Objects.equals(ciName, that.ciName) && direction.equals(that.direction);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(joinType, ciName, direction);
//    }

    public JoinType getJoinType() {
        return joinType;
    }


    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
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

//    public Long getToAttrId() {
//        return toAttrId;
//    }
//
//    public void setToAttrId(Long toAttrId) {
//        this.toAttrId = toAttrId;
//    }
//
//    public Long getToAttrCiId() {
//        return toAttrCiId;
//    }
//
//    public void setToAttrCiId(Long toAttrCiId) {
//        this.toAttrCiId = toAttrCiId;
//    }

    public Long getFromAttrCiId() {
        return fromAttrCiId;
    }

    public void setFromAttrCiId(Long fromAttrCiId) {
        this.fromAttrCiId = fromAttrCiId;
    }

//    public String getToAttrCiName() {
//        return toAttrCiName;
//    }
//
//    public void setToAttrCiName(String toAttrCiName) {
//        this.toAttrCiName = toAttrCiName;
//    }

    public String getFromAttrCiName() {
        return fromAttrCiName;
    }

    public void setFromAttrCiName(String fromAttrCiName) {
        this.fromAttrCiName = fromAttrCiName;
    }

//    public Integer getToCiIsVirtual() {
//        return toCiIsVirtual;
//    }
//
//    public void setToCiIsVirtual(Integer toCiIsVirtual) {
//        this.toCiIsVirtual = toCiIsVirtual;
//    }
}
