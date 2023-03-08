package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountNameIsNotNullException extends ApiRuntimeException {
    public ResourceCenterAccountNameIsNotNullException() {
        super("exception.cmdb.resourcecenteraccountnameisnotnullexception");
    }
}
