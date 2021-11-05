package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountProtocolRepeatException extends ApiRuntimeException {
    public ResourceCenterAccountProtocolRepeatException(String protocol, Integer port) {
        super(String.format("协议：%s(%d)已存在", protocol, port));
    }
}
