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

package neatlogic.framework.cmdb.exception.validator;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;

public class ValidatorIsInUsedException extends ApiRuntimeException {
    public ValidatorIsInUsedException(List<AttrVo> attrList) {
        super("当前校验规则已被{0}个属性使用，请先删除",attrList.size());
    }
}
