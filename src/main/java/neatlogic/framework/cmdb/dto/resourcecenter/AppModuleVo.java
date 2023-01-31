/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.resourcecenter;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

public class AppModuleVo implements Serializable {
    private static final long serialVersionUID = 3794860793337591802L;

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "简称", type = ApiParamType.STRING)
    private String abbrName;
    @EntityField(name = "应用id", type = ApiParamType.LONG)
    private Long appSystemId;

    @EntityField(name = "模型列表", type = ApiParamType.JSONARRAY)
    private List<CiVo> ciList;

    public Long getId() {
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

    public String getAbbrName() {
        return abbrName;
    }

    public void setAbbrName(String abbrName) {
        this.abbrName = abbrName;
    }

    public Long getAppSystemId() {
        return appSystemId;
    }

    public void setAppSystemId(Long appSystemId) {
        this.appSystemId = appSystemId;
    }

    public List<CiVo> getCiList() {
        return ciList;
    }

    public void setCiList(List<CiVo> ciList) {
        this.ciList = ciList;
    }
}
