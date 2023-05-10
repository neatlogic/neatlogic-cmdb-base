/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

import neatlogic.framework.cmdb.enums.resourcecenter.JoinType;

public class ResourceInfo {
    private final String resourceName;
    private final String columnName;
    private final boolean left;

    private String joinAttrName;
    private Long joinAttrId;

    private Long resourceCiId;
    private String resourceCiName;
    private String attrCiName;
    private Long attrCiId;
    private Integer attrCiIsVirtual;

    private Long attrId;
    private String attrName;
    private Long attrFromCiId;

    private JoinType joinType;
    private String direction;


    public ResourceInfo(String resourceName, String columnName) {
        this.resourceName = resourceName;
        this.columnName = columnName;
        this.left = true;
    }
    public ResourceInfo(String resourceName, String columnName, boolean left) {
        this.resourceName = resourceName;
        this.columnName = columnName;
        this.left = left;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getColumnName() {
        return columnName;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrCiName() {
        return attrCiName;
    }

    public void setAttrCiName(String attrCiName) {
        this.attrCiName = attrCiName;
    }

    public Long getAttrCiId() {
        return attrCiId;
    }

    public void setAttrCiId(Long attrCiId) {
        this.attrCiId = attrCiId;
    }

    public JoinType getJoinType() {
        return joinType;
    }

    public void setJoinType(JoinType joinType) {
        this.joinType = joinType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getResourceCiId() {
        return resourceCiId;
    }

    public void setResourceCiId(Long resourceCiId) {
        this.resourceCiId = resourceCiId;
    }

    public String getResourceCiName() {
        return resourceCiName;
    }

    public void setResourceCiName(String fromTableAlias) {
        this.resourceCiName = fromTableAlias;
    }


    public Long getAttrFromCiId() {
        return attrFromCiId;
    }

    public void setAttrFromCiId(Long attrfromCiId) {
        this.attrFromCiId = attrfromCiId;
    }

    public Integer getAttrCiIsVirtual() {
        return attrCiIsVirtual;
    }

    public void setAttrCiIsVirtual(Integer attrCiIsVirtual) {
        this.attrCiIsVirtual = attrCiIsVirtual;
    }

    public boolean getLeft() {
        return left;
    }

    public String getJoinAttrName() {
        return joinAttrName;
    }

    public void setJoinAttrName(String joinAttrName) {
        this.joinAttrName = joinAttrName;
    }

    public Long getJoinAttrId() {
        return joinAttrId;
    }

    public void setJoinAttrId(Long joinAttrId) {
        this.joinAttrId = joinAttrId;
    }
}
