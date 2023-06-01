package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountProtocolHasBeenReferredException extends ApiRuntimeException {
    public ResourceCenterAccountProtocolHasBeenReferredException(String protocol) {
        super("协议：{0}已被引用", protocol);
    }
}
