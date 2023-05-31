package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountProtocolNotFoundException extends ApiRuntimeException {
    private static final long serialVersionUID = -5055024535330898128L;

    public ResourceCenterAccountProtocolNotFoundException(Long id) {
        super("common.pro", id);
    }

    public ResourceCenterAccountProtocolNotFoundException(String name) {
        super("common.pro", name);
    }
}
