/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
