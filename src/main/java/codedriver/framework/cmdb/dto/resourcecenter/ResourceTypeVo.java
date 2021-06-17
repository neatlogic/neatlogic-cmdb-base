/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linbq
 * @since 2021/6/9 17:17
 **/
public class ResourceTypeVo {
    private Long id;
    private Long parentId;
    private String label;
    private String name;
//    @EntityField(name = "子模型列表", type = ApiParamType.JSONARRAY)
    private List<ResourceTypeVo> children;

    public ResourceTypeVo() {

    }

    public ResourceTypeVo(String label, String name) {
        this.label = label;
        this.name = name;
    }

    public ResourceTypeVo(Long id, Long parentId, String label, String name) {
        this.id = id;
        this.parentId = parentId;
        this.label = label;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentCiId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
