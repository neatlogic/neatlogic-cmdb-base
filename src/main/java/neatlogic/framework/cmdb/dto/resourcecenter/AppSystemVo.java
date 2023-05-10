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

package neatlogic.framework.cmdb.dto.resourcecenter;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;

public class AppSystemVo implements Serializable {
    private static final long serialVersionUID = 3794860793337591801L;

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "简称", type = ApiParamType.STRING)
    private String abbrName;
    @EntityField(name = "应用模块列表", type = ApiParamType.JSONARRAY)
    private List<AppModuleVo> appModuleList;
    @EntityField(name = "是否包含模块", type = ApiParamType.INTEGER)
    private Integer isHasModule = 0;

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

    public List<AppModuleVo> getAppModuleList() {
        return appModuleList;
    }

    public void setAppModuleList(List<AppModuleVo> appModuleList) {
        this.appModuleList = appModuleList;
    }

    public Integer getIsHasModule() {
        return isHasModule;
    }

    public void setIsHasModule(Integer isHasModule) {
        this.isHasModule = isHasModule;
    }
}
