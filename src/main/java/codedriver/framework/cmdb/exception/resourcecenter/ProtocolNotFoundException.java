/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ProtocolNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8738508038638398100L;

    public ProtocolNotFoundException(String protocol) {
        super("协议：'" + protocol + "'不存在");
    }
}
