package codedriver.framework.cmdb.validator.core;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;

import codedriver.framework.cmdb.dao.mapper.validator.ValidatorMapper;
import codedriver.framework.cmdb.dto.validator.ValidatorVo;
import codedriver.framework.cmdb.exception.validator.AttrInValidatedException;
import codedriver.framework.cmdb.exception.validator.ValidatorNotFoundException;

public abstract class ValidatorBase implements IValidator {
    protected static ValidatorMapper validatorMapper;

    @Autowired
    public void setValidatorMapper(ValidatorMapper avalidatorMapper) {
        validatorMapper = avalidatorMapper;
    }

    public final boolean valid(String attrLabel, String attrValue, Long validatorId) {
        if (StringUtils.isBlank(attrValue)) {
            return true;
        }
        if (validatorId != null) {
            ValidatorVo validatorVo = validatorMapper.getValidatorById(validatorId);
            boolean isValid = myValid(attrValue, validatorVo.getConfig());
            if (!isValid) {
                String errorMsg = "";
                if (StringUtils.isNotBlank(validatorVo.getErrorTemplate())) {
                    errorMsg = validatorVo.getErrorTemplate();
                    errorMsg = errorMsg.replace("{label}", attrLabel);
                    errorMsg = errorMsg.replace("{value}", attrValue);
                }
                throw new AttrInValidatedException(errorMsg);
            } else {
                return true;
            }
        } else {
            throw new ValidatorNotFoundException(validatorId);
        }
    }

    protected abstract boolean myValid(String value, JSONObject config);
}
