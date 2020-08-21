package codedriver.framework.cmdb.exception.validator;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class ValidatorNotFoundException extends ApiRuntimeException {
    public ValidatorNotFoundException(Long validatorId) {
        super("验证处理器：" + validatorId + " 不存在");
    }
}
