package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceAccountAccessTestException extends ApiRuntimeException {

    private static final long serialVersionUID = 3429631542042868737L;

    public ResourceAccountAccessTestException(String msg) {
        super(msg);
    }
}
