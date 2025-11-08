/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.dao.mapper.validator;

import neatlogic.framework.cmdb.dto.validator.ValidatorVo;

import java.util.List;

public interface ValidatorMapper {
    List<ValidatorVo> searchValidator(ValidatorVo validatorVo);

    int searchValidatorCount(ValidatorVo validatorVo);

    ValidatorVo getValidatorById(Long validatorId);

    ValidatorVo getValidatorByName(String name);

    void insertValidator(ValidatorVo validatorVo);

    void updateValidator(ValidatorVo validatorVo);

    void deleteValidatorById(Long id);
}
