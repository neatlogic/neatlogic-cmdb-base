package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceAccountAccessTestHostException extends ApiRuntimeException {
    private static final long serialVersionUID = -3725778275371529823L;

    public ResourceAccountAccessTestHostException(String host) {
        super("nfcer.resourceaccountaccesstesthostexception.resourceaccountaccesstesthostexception", host);
    }
}
