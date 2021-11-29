/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.validator.core;

import codedriver.framework.cmdb.dao.mapper.validator.ValidatorMapper;
import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.cmdb.dto.validator.ValidatorVo;
import codedriver.framework.cmdb.exception.validator.AttrInValidatedException;
import codedriver.framework.cmdb.exception.validator.ValidatorNotFoundException;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

public abstract class ValidatorBase implements IValidator {
    protected static ValidatorMapper validatorMapper;

    @Autowired
    public void setValidatorMapper(ValidatorMapper _validatorMapper) {
        validatorMapper = _validatorMapper;
    }

    @Override
    public final boolean valid(AttrVo attrVo, JSONArray attrValueList) throws AttrInValidatedException, ValidatorNotFoundException {
        Long validatorId = attrVo.getValidatorId();
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
                    errorMsg = errorMsg.replace("{label}", attrVo.getLabel());
                    errorMsg = errorMsg.replace("{value}", attrValueList.stream().map(Object::toString).collect(Collectors.joining(",")));
                }
                throw new AttrInValidatedException(errorMsg);
            } else {
                return true;
            }
        } else {
            throw new ValidatorNotFoundException(validatorId);
        }
    }

    protected abstract boolean myValid(JSONArray valueList, JSONObject config);
}
