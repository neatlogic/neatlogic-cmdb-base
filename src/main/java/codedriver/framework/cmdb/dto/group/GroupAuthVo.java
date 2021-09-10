/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.group;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.constvalue.AuthType;
import codedriver.framework.restful.annotation.EntityField;

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
