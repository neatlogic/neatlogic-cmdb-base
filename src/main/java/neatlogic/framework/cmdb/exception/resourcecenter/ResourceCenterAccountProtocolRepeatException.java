package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountProtocolRepeatException extends ApiRuntimeException {
    private static final long serialVersionUID = -6105727584092064358L;

    public ResourceCenterAccountProtocolRepeatException(String protocol) {
        super("exception.cmdb.resourcecenteraccountprotocolrepeatexception", protocol);
    }
}
