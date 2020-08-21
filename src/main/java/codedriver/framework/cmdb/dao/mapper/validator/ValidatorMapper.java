package codedriver.framework.cmdb.dao.mapper.validator;

import java.util.List;

import codedriver.framework.cmdb.dto.validator.ValidatorVo;

public interface ValidatorMapper {
    public List<ValidatorVo> searchValidator(ValidatorVo validatorVo);

    public int searchValidatorCount(ValidatorVo validatorVo);

    public ValidatorVo getValidatorById(Long validatorId);
}
