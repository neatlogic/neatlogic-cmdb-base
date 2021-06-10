/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.cmdb.dto.ci.CiVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linbq
 * @since 2021/6/9 17:17
 **/
public class ResourceTypeVo {
    private Long ciId;
    private Long parentCiId;
    private String name;
    private String label;
    private String ciName;
//    @EntityField(name = "子模型列表", type = ApiParamType.JSONARRAY)
    private List<ResourceTypeVo> children;

    public ResourceTypeVo() {

    }

    public ResourceTypeVo(String name, String label, String ciName) {
        this.name = name;
        this.label = label;
        this.ciName = ciName;
    }

    public ResourceTypeVo(Long ciId, Long parentCiId, String name, String label, String ciName) {
        this.ciId = ciId;
        this.parentCiId = parentCiId;
        this.name = name;
        this.label = label;
        this.ciName = ciName;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getParentCiId() {
        return parentCiId;
    }

    public void setParentCiId(Long parentCiId) {
        this.parentCiId = parentCiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ResourceTypeVo> getChildren() {
        return children;
    }

    public void setChildren(List<ResourceTypeVo> children) {
        this.children = children;
    }

    public void addChild(ResourceTypeVo resourceTypeVo) {
        if (resourceTypeVo != null) {
            if (this.children == null) {
                this.children = new ArrayList<>();
            }
            this.children.add(resourceTypeVo);
        }
    }
}
