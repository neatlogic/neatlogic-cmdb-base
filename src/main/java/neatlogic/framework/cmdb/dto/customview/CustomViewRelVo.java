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

package neatlogic.framework.cmdb.dto.customview;

import neatlogic.framework.cmdb.dto.ci.RelVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class CustomViewRelVo implements Serializable {
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "视图模型uuid", type = ApiParamType.STRING)
    private String customViewCiUuid;
    @EntityField(name = "属性id", type = ApiParamType.LONG)
    private Long relId;
    @JSONField(serialize = false)
    private RelVo relVo;

    public CustomViewRelVo() {

    }

    public CustomViewRelVo(JSONObject jsonObj) {
        this.uuid = jsonObj.getString("uuid");
        this.relId = jsonObj.getJSONObject("config").getLong("relId");
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(Long customViewId) {
        this.customViewId = customViewId;
    }

    public String getCustomViewCiUuid() {
        return customViewCiUuid;
    }

    public void setCustomViewCiUuid(String customViewCiUuid) {
        this.customViewCiUuid = customViewCiUuid;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public RelVo getRelVo() {
        return relVo;
    }

    public void setRelVo(RelVo relVo) {
        this.relVo = relVo;
    }
}
