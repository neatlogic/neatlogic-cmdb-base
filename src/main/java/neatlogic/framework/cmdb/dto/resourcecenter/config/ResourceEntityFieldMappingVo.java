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

public class ResourceEntityFieldMappingVo {

    private String field;
    private String type;
    private String fromCi;
    private String fromAttr;
    private String toCi;
    private String toAttr;
    private String direction;
    @JSONField(serialize = false)
    private Long fromCiId;
    @JSONField(serialize = false)
    private Long fromAttrId;
    @JSONField(serialize = false)
    private Long fromAttrCiId;
    @JSONField(serialize = false)
    private Long toCiId;
    @JSONField(serialize = false)
    private Integer toCiIsVirtual;
    @JSONField(serialize = false)
    private Long toAttrId;
    @JSONField(serialize = false)
    private Long toAttrCiId;
    @JSONField(serialize = false)
    private String toAttrCiName;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromCi() {
        return fromCi;
    }

    public void setFromCi(String fromCi) {
        this.fromCi = fromCi;
    }

    public String getFromAttr() {
        return fromAttr;
    }

    public void setFromAttr(String fromAttr) {
        this.fromAttr = fromAttr;
    }

    public String getToCi() {
        return toCi;
    }

    public void setToCi(String toCi) {
        this.toCi = toCi;
    }

    public String getToAttr() {
        return toAttr;
    }

    public void setToAttr(String toAttr) {
        this.toAttr = toAttr;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getFromCiId() {
        return fromCiId;
    }

    public void setFromCiId(Long fromCiId) {
        this.fromCiId = fromCiId;
    }

    public Long getFromAttrId() {
        return fromAttrId;
    }

    public void setFromAttrId(Long fromAttrId) {
        this.fromAttrId = fromAttrId;
    }

    public Long getFromAttrCiId() {
        return fromAttrCiId;
    }

    public void setFromAttrCiId(Long fromAttrCiId) {
        this.fromAttrCiId = fromAttrCiId;
    }

    public Long getToCiId() {
        return toCiId;
    }

    public void setToCiId(Long toCiId) {
        this.toCiId = toCiId;
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

    public String getToAttrCiName() {
        return toAttrCiName;
    }

    public void setToAttrCiName(String toAttrCiName) {
        this.toAttrCiName = toAttrCiName;
    }

    public Integer getToCiIsVirtual() {
        return toCiIsVirtual;
    }

    public void setToCiIsVirtual(Integer toCiIsVirtual) {
        this.toCiIsVirtual = toCiIsVirtual;
    }
}
