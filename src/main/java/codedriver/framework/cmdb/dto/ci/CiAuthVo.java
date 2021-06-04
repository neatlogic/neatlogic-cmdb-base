/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.ci;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.io.Serializable;

public class CiAuthVo implements Serializable {
    private static final long serialVersionUID = -3120412333445538L;
    @EntityField(name = "ciId", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "authType", type = ApiParamType.STRING)
    private String authType;
    @EntityField(name = "action", type = ApiParamType.STRING)
    private String action;
    @EntityField(name = "authUuid", type = ApiParamType.STRING)
    private String authUuid;

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAuthUuid() {
        return authUuid;
    }

    public void setAuthUuid(String authUuid) {
        this.authUuid = authUuid;
    }

}
