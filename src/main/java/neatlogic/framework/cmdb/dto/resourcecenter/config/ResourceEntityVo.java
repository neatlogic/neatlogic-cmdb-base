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

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.resourcecenter.Status;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class ResourceEntityVo implements Serializable {
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "common.cnname", type = ApiParamType.STRING)
    private String label;
    @EntityField(name = "term.cmdb.ciinfo", type = ApiParamType.JSONOBJECT)
    private CiVo ci;//对应的模型
    @EntityField(name = "common.status", type = ApiParamType.ENUM, member = Status.class)
    private String status = "";
    @EntityField(name = "common.statusname", type = ApiParamType.STRING)
    private String statusText;
    @EntityField(name = "common.errorinfo", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "common.inittime", type = ApiParamType.LONG)
    private Date initTime;
    @EntityField(name = "term.cmdb.ciid", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "common.description", type = ApiParamType.STRING)
    private String description;

    @EntityField(name = "nfdd.datasourcevo.entityfield.name.fieldlist", type = ApiParamType.JSONARRAY)
    private List<ValueTextVo> fieldList;
    @EntityField(name = "common.config", type = ApiParamType.JSONOBJECT)
    private ResourceEntityConfigVo config;
    @EntityField(name = "是否支持创建多张视图", type = ApiParamType.BOOLEAN)
    private Boolean isMultiple;
    @EntityField(name = "所属模块ID", type = ApiParamType.STRING)
    private String moduleId;
    @EntityField(name = "所属模块名", type = ApiParamType.STRING)
    private String moduleName;
    @JSONField(serialize = false)
    private String configStr;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceEntityVo that = (ResourceEntityVo) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        if (StringUtils.isBlank(statusText) && StringUtils.isNotBlank(status)) {
            statusText = Status.getText(status);
        }
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public CiVo getCi() {
        return ci;
    }

    public void setCi(CiVo ci) {
        this.ci = ci;
    }

    public Long getCiId() {
        if (ciId == null && ci != null) {
            ciId = ci.getId();
        }
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ValueTextVo> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<ValueTextVo> fieldList) {
        this.fieldList = fieldList;
    }

    public ResourceEntityConfigVo getConfig() {
        if (config == null && StringUtils.isNotBlank(configStr)) {
            try {
                config = JSONObject.parseObject(configStr, ResourceEntityConfigVo.class);
            } catch (Exception ignored) {

            }
        }
        if (config == null) {
            return new ResourceEntityConfigVo();
        }
        return config;
    }

    public void setConfig(ResourceEntityConfigVo config) {
        this.config = config;
    }

    public String getConfigStr() {
        if (StringUtils.isBlank(configStr) && config != null) {
            configStr = JSONObject.toJSONString(config);
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public Boolean getIsMultiple() {
        return isMultiple;
    }

    public void setIsMultiple(Boolean isMultiple) {
        this.isMultiple = isMultiple;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
