package codedriver.framework.cmdb.exception.validator;

import org.apache.commons.lang3.StringUtils;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class AttrInValidatedException extends ApiRuntimeException {

    public AttrInValidatedException(String msg) {
        super(msg);
    }

}
