/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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

    @JSONField(serialize = false)
    private Integer isKeywordMatch;
    @JSONField(serialize = false)
    private ResourceTypeVo parent;

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

    public void removeChild(ResourceTypeVo resourceTypeVo) {
        if (resourceTypeVo != null && CollectionUtils.isNotEmpty(children)) {
            Iterator<ResourceTypeVo> iterator = children.iterator();
            while (iterator.hasNext()) {
                ResourceTypeVo child = iterator.next();
                if (Objects.equals(resourceTypeVo.getId(), child.getId())) {
                    iterator.remove();
                    break;
                }
            }
        }
    }

    public Integer getIsKeywordMatch() {
        return isKeywordMatch;
    }

    public void setIsKeywordMatch(Integer isKeywordMatch) {
        this.isKeywordMatch = isKeywordMatch;
        if (Objects.equals(isKeywordMatch, 1)) {


        }
    }

    public ResourceTypeVo getParent() {
        return parent;
    }

    public void setParent(ResourceTypeVo parent) {
        this.parent = parent;
    }

    public void setUpwardIsKeywordMatch(Integer isKeywordMatch) {
        if (parent != null) {
            if (!Objects.equals(parent.getIsKeywordMatch(), isKeywordMatch)) {
                parent.setIsKeywordMatch(isKeywordMatch);
                parent.setUpwardIsKeywordMatch(isKeywordMatch);
            }
        }
    }
    public void setDownwardIsKeywordMatch(Integer isKeywordMatch) {
        if (CollectionUtils.isNotEmpty(children)) {
            for (ResourceTypeVo child : children) {
                if (!Objects.equals(child.getIsKeywordMatch(), isKeywordMatch)) {
                    child.setIsKeywordMatch(isKeywordMatch);
                    child.setDownwardIsKeywordMatch(isKeywordMatch);
                }
            }
        }
    }
}
