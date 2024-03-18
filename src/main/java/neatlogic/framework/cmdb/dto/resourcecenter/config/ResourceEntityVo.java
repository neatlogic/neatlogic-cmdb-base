/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.resourcecenter.Status;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class ResourceEntityVo {
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "common.cnname", type = ApiParamType.STRING)
    private String label;
    @EntityField(name = "term.cmdb.ciinfo", type = ApiParamType.JSONOBJECT)
    private CiVo ci;//对应的模型
    @EntityField(name = "common.attributelist", type = ApiParamType.JSONARRAY)
    private Set<ResourceEntityAttrVo> attrList;
    @EntityField(name = "term.cmdb.joinlist", type = ApiParamType.JSONARRAY)
    private Set<ResourceEntityJoinVo> joinList;
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

    public void addJoin(ResourceEntityJoinVo join) {
        if (joinList == null) {
            joinList = new HashSet<>();
        }
        joinList.add(join);
    }

    public void addAttr(ResourceEntityAttrVo attr) {
        if (attrList == null) {
            attrList = new HashSet<>();
        }
        attrList.add(attr);
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

    public Set<ResourceEntityAttrVo> getAttrList() {
        return attrList;
    }

    public void setAttrList(Set<ResourceEntityAttrVo> attrList) {
        this.attrList = attrList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Set<ResourceEntityJoinVo> getJoinList() {
        return joinList;
    }

    public void setJoinList(Set<ResourceEntityJoinVo> joinList) {
        this.joinList = joinList;
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
}
