package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountProtocolRepeatException extends ApiRuntimeException {
    public ResourceCenterAccountProtocolRepeatException(String protocol) {
        super("协议："+protocol+"已存在");
    }
}
