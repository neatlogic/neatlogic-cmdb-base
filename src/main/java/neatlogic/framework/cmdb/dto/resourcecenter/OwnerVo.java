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
import neatlogic.framework.common.constvalue.GroupSearch;
import neatlogic.framework.restful.annotation.EntityField;

/**
 * @author linbq
 * @since 2021/5/27 14:07
 **/
public class OwnerVo {
    @EntityField(name = "用户uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "用户id", type = ApiParamType.LONG)
    private Long userId;
    @EntityField(name = "用户名", type = ApiParamType.STRING)
    private String userName;
    private String initType = GroupSearch.USER.getValue();
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getInitType() {
        return initType;
    }

    public void setInitType(String initType) {
        this.initType = initType;
    }
}
