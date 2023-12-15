package neatlogic.framework.cmdb.dto.cicatalog;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

import java.io.Serializable;

public class CiCatalogVo implements Serializable {

    private static final long serialVersionUID = 9045187703084309759L;

    public static final Long ROOT_PARENTID = -1L;
    public static final Long ROOT_ID = 0L;
    public static final String ROOT_NAME = "所有";
    @EntityField(name = "common.id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "common.parentid", type = ApiParamType.LONG)
    private Long parentId;
    @EntityField(name = "common.lft", type = ApiParamType.INTEGER)
    private Integer lft;
    @EntityField(name = "common.rht", type = ApiParamType.INTEGER)
    private Integer rht;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getLft() {
        return lft;
    }

    public void setLft(Integer lft) {
        this.lft = lft;
    }

    public Integer getRht() {
        return rht;
    }

    public void setRht(Integer rht) {
        this.rht = rht;
    }
}
