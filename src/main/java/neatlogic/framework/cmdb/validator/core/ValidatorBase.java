/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.validator.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import neatlogic.framework.cmdb.dao.mapper.validator.ValidatorMapper;
import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.validator.ValidatorVo;
import neatlogic.framework.cmdb.exception.validator.AttrInValidatedException;
import neatlogic.framework.cmdb.exception.validator.ValidatorNotFoundException;
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
