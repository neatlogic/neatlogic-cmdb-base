/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

import codedriver.framework.cmdb.enums.resourcecenter.JoinType;

public class ResourceInfo {
    private final String resourceName;
    private final String columnName;
    private final boolean left;

    private String joinAttrName;
    private Long joinAttrId;

    private Long resourceCiId;
    private String resourceCiName;
//    private CiVo attrCiVo;
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

//    public CiVo getAttrCiVo() {
//        return attrCiVo;
//    }

//    public void setAttrCiVo(CiVo attrCiVo) {
//        this.attrCiVo = attrCiVo;
//    }

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
