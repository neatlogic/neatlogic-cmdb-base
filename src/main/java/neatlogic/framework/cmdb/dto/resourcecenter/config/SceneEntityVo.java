/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.resourcecenter.Status;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Date;
import java.util.List;

public class SceneEntityVo {
    @EntityField(name = "对象唯一标识（视图名）", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "对象名称", type = ApiParamType.STRING)
    private String label;
    @JSONField(serialize = false)
    private CiVo ci;//对应的模型
    @EntityField(name = "属性列表", type = ApiParamType.JSONARRAY)
    private List<SceneEntityAttrVo> attrList;
    @EntityField(name = "连接列表", type = ApiParamType.JSONARRAY)
    private List<SceneEntityJoinVo> joinList;
    @EntityField(name = "状态", type = ApiParamType.ENUM, member = Status.class)
    private String status = "";
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusText;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "初始化时间", type = ApiParamType.LONG)
    private Date initTime;
    @EntityField(name = "关联模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;

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

    public CiVo getCi() {
        return ci;
    }

    public void setCi(CiVo ci) {
        this.ci = ci;
    }

    public List<SceneEntityAttrVo> getAttrList() {
        return attrList;
    }

    public void setAttrList (List<SceneEntityAttrVo> attrList) {
        this.attrList = attrList;
    }

    public List<SceneEntityJoinVo> getJoinList() {
        return joinList;
    }

    public void setJoinList(List<SceneEntityJoinVo> joinList) {
        this.joinList = joinList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
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

    public Date getInitTime() {
        return initTime;
    }

    public void setInitTime(Date initTime) {
        this.initTime = initTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
