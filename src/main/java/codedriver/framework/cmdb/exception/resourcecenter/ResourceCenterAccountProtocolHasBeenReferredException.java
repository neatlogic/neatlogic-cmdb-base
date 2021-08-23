package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountProtocolHasBeenReferredException extends ApiRuntimeException {
    public ResourceCenterAccountProtocolHasBeenReferredException(String protocol) {
        super("协议："+protocol+"已被引用");
    }
}
