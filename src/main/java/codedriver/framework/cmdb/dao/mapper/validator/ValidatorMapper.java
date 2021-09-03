/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dao.mapper.validator;

import codedriver.framework.cmdb.dto.validator.ValidatorVo;

import java.util.List;

public interface ValidatorMapper {
    List<ValidatorVo> searchValidator(ValidatorVo validatorVo);

    int searchValidatorCount(ValidatorVo validatorVo);

    ValidatorVo getValidatorById(Long validatorId);

    void insertValidator(ValidatorVo validatorVo);

    void updateValidator(ValidatorVo validatorVo);

    void deleteValidatorById(Long id);
}
