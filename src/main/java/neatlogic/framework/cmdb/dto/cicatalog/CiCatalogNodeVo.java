package neatlogic.framework.cmdb.dto.cicatalog;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CiCatalogNodeVo extends CiCatalogVo {

    private static final long serialVersionUID = 9045187703084309760L;

    public static final String CATALOG = "catalog";
    public static final String CI = "ci";

    @EntityField(name = "common.children", type = ApiParamType.JSONARRAY)
    private List<CiCatalogNodeVo> children;

    @EntityField(name = "common.childrencount", type = ApiParamType.INTEGER)
    private Integer childrenCount;

    @EntityField(name = "common.type", type = ApiParamType.STRING)
    private String type;

    @JSONField(serialize=false)
    private CiCatalogNodeVo parent;

    public List<CiCatalogNodeVo> getChildren() {
        if (children == null && Objects.equals(type, CiCatalogNodeVo.CATALOG)) {
            children = new ArrayList<>();
        }
        return children;
    }

    public void setChildren(List<CiCatalogNodeVo> children) {
        this.children = children;
    }

    public Integer getChildrenCount() {
        if (childrenCount == null) {
            childrenCount = CollectionUtils.size(children);
        }
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CiCatalogNodeVo getParent() {
        return parent;
    }

    public void setParent(CiCatalogNodeVo parent) {
        this.parent = parent;
    }

    public boolean addChild(CiCatalogNodeVo child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if(children.contains(child)) {
            return false;
        }
        return children.add(child);
    }

    public boolean removeChild(CiCatalogNodeVo child) {
        if (CollectionUtils.isEmpty(children)) {
            return false;
        }
        return children.remove(child);
    }
}
