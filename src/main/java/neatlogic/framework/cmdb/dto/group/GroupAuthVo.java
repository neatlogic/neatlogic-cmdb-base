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

package neatlogic.framework.cmdb.dto.group;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.constvalue.AuthType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;

public class GroupAuthVo implements Serializable {
    @EntityField(name = "团体id", type = ApiParamType.LONG)
    private Long groupId;
    @EntityField(name = "授权类型", type = ApiParamType.ENUM, member = AuthType.class)
    private String authType;
    @EntityField(name = "授权目标uuid", type = ApiParamType.ENUM, member = AuthType.class)
    private String authUuid;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAuthUuid() {
        return authUuid;
    }

    public void setAuthUuid(String authUuid) {
        this.authUuid = authUuid;
    }
}
