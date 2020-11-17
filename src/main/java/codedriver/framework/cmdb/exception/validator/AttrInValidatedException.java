package codedriver.framework.cmdb.exception.validator;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class AttrInValidatedException extends ApiRuntimeException {

    public AttrInValidatedException(String msg) {
        super(msg);
    }

}
