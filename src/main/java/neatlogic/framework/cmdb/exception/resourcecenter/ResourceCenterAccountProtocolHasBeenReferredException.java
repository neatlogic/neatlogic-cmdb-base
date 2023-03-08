package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountProtocolHasBeenReferredException extends ApiRuntimeException {
    public ResourceCenterAccountProtocolHasBeenReferredException(String protocol) {
        super("exception.cmdb.resourcecenteraccountprotocolhasbeenreferredexception", protocol);
    }
}
