/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class ResourceEntityFieldMappingVo implements Serializable {

    private String field;
    private String type;
    private String fromCi;
    private String fromCiAlias;
    private String fromAttr;
    private String toCi;
    private String toCiAlias;
    private String toAttr;
    private String direction;
    private String uuid;
    private String ciName;
    private String attr;
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

    public String getFromCiAlias() {
        return fromCiAlias;
    }

    public void setFromCiAlias(String fromCiAlias) {
        this.fromCiAlias = fromCiAlias;
    }

    public String getToCiAlias() {
        return toCiAlias;
    }

    public void setToCiAlias(String toCiAlias) {
        this.toCiAlias = toCiAlias;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }
}
