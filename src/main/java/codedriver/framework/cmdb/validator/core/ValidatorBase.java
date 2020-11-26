package codedriver.framework.cmdb.validator.core;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.naming.utils.CollectionUtils;

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

    @Override
    public final boolean valid(String attrLabel, List<String> attrValueList, Long validatorId) {
        if (CollectionUtils.isEmpty(attrValueList)) {
            return true;
        }
        if (validatorId != null) {
            ValidatorVo validatorVo = validatorMapper.getValidatorById(validatorId);
            boolean isValid = myValid(attrValueList, validatorVo.getConfig());
            if (!isValid) {
                String errorMsg = "";
                if (StringUtils.isNotBlank(validatorVo.getErrorTemplate())) {
                    errorMsg = validatorVo.getErrorTemplate();
                    errorMsg = errorMsg.replace("{label}", attrLabel);
                    errorMsg = errorMsg.replace("{value}", attrValueList.stream().collect(Collectors.joining(",")));
                }
                throw new AttrInValidatedException(errorMsg);
            } else {
                return true;
            }
        } else {
            throw new ValidatorNotFoundException(validatorId);
        }
    }

    protected abstract boolean myValid(List<String> value, JSONObject config);
}
