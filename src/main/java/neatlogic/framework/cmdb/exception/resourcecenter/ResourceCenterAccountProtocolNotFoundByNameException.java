package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountProtocolNotFoundByNameException extends ApiRuntimeException {
    private static final long serialVersionUID = -5055024535730898188L;

    public ResourceCenterAccountProtocolNotFoundByNameException(String protocolName) {
        super("协议：" + protocolName + "不存在");
    }
}
