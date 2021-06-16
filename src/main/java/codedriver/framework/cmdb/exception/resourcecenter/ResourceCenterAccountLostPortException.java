/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountLostPortException extends ApiRuntimeException {

    private static final long serialVersionUID = -2841975427941709945L;

    public ResourceCenterAccountLostPortException() {
        super("当连接协议为SSH时，必须指定端口");
    }
}
