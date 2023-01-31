/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.resourcecenter.JoinType;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Objects;

public class SceneEntityAttrVo {

    private String resource;
    private String field;
    private String direction;
    private JoinType joinType;

    private String fromCi;
    private String toCi;
    private String fromAttr;
    private String toAttr;

    private Long fromAttrId;
    private Long toAttrId;
    private Long toAttrCiId;
    private Long fromAttrCiId;
    private String toAttrCiName;
    private String fromAttrCiName;
    private Integer toCiIsVirtual;
    private Long fromCiId;
    private Long toCiId;

    @JSONField(serialize = false)
    private CiVo fromCiVo;
    @JSONField(serialize = false)
    private CiVo toCiVo;
    @JSONField(serialize = false)
    private AttrVo fromAttrVo;
    @JSONField(serialize = false)
    private AttrVo toAttrVo;

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
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

    public String getToCi() {
        if (toCi == null && toCiVo != null) {
            toCi = toCiVo.getName();
        }
        return toCi;
    }

    public void setToCi(String toCi) {
        this.toCi = toCi;
    }

    public String getFromAttr() {
        if (fromAttr == null && fromAttrVo != null) {
            fromAttr = fromAttrVo.getName();
        }
        return fromAttr;
    }

    public void setFromAttr(String fromAttr) {
        this.fromAttr = fromAttr;
    }

    public String getToAttr() {
        if (toAttr == null && toAttrVo != null) {
            toAttr = toAttrVo.getName();
        }
        return toAttr;
    }

    public void setToAttr(String toAttr) {
        this.toAttr = toAttr;
    }

    public Long getFromAttrId() {
        if (fromAttrId == null && fromAttrVo != null) {
            fromAttrId = fromAttrVo.getId();
        }
        return fromAttrId;
    }

    public void setFromAttrId(Long fromAttrId) {
        this.fromAttrId = fromAttrId;
    }

    public Long getToAttrId() {
        if (toAttrId == null && toAttrVo != null) {
            toAttrId = toAttrVo.getId();
        }
        return toAttrId;
    }

    public Long getToAttrCiId() {
        if (toAttrCiId == null && toAttrVo != null) {
            toAttrCiId = toAttrVo.getCiId();
        }
        return toAttrCiId;
    }

    public void setToAttrCiId(Long toAttrCiId) {
        this.toAttrCiId = toAttrCiId;
    }

    public Long getFromAttrCiId() {
        if (fromAttrCiId == null && fromAttrVo != null) {
            fromAttrCiId = fromAttrVo.getCiId();
        }
        return fromAttrCiId;
    }

    public String getToAttrCiName() {
        if (toAttrCiName == null && toAttrVo != null) {
            toAttrCiName = toAttrVo.getCiName();
        }
        return toAttrCiName;
    }

    public void setToAttrCiName(String toAttrCiName) {
        this.toAttrCiName = toAttrCiName;
    }

    public String getFromAttrCiName() {
        if (fromAttrCiName == null && fromAttrVo != null) {
            fromAttrCiName = fromAttrVo.getCiName();
        }
        return fromAttrCiName;
    }

    public Integer getToCiIsVirtual() {
        if (toCiIsVirtual == null && toCiVo != null) {
            toCiIsVirtual = toCiVo.getIsVirtual();
        }
        return toCiIsVirtual;
    }

    public Long getFromCiId() {
        if (fromCiId == null && fromCiVo != null) {
            fromCiId = fromCiVo.getId();
        }
        return fromCiId;
    }

    public Long getToCiId() {
        if (toCiId == null && toCiVo != null) {
            toCiId = toCiVo.getId();
        }
        return toCiId;
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

    public AttrVo getToAttrVo() {
        return toAttrVo;
    }

    public void setToAttrVo(AttrVo toAttrVo) {
        this.toAttrVo = toAttrVo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SceneEntityAttrVo that = (SceneEntityAttrVo) o;
        return Objects.equals(field, that.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }

}
