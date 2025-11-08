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

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiUniqueRuleException extends ApiRuntimeException {
    public CiUniqueRuleException(CiVo ciVo) {
        super("模型“{0}({1})”存在拥有相同唯一规则属性的配置项", ciVo.getLabel(), ciVo.getName());
    }

    public CiUniqueRuleException(CiVo ciVo, String value) {
        super("模型“{0}({1})”存在拥有相同唯一规则属性的配置项“{2}”", ciVo.getLabel(), ciVo.getName(), value);
    }
}
