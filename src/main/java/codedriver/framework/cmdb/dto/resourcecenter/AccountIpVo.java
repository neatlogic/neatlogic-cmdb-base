/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

/**
 * @author lvzk
 * @since 2021/11/8 12:15
 **/
public class AccountIpVo {
    @EntityField(name = "账号id", type = ApiParamType.LONG)
    private Long accountId;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    private String ip;

    public AccountIpVo(Long accountId, String ip) {
        this.accountId = accountId;
        this.ip = ip;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
