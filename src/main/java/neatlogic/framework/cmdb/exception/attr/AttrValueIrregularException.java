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

package neatlogic.framework.cmdb.exception.attr;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AttrValueIrregularException extends ApiRuntimeException {

    public AttrValueIrregularException(AttrVo attrVo, String value) {
        super("nfcea.attrvalueirregularexception.attrvalueirregularexception_a", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName(), value, attrVo.getTypeText());
    }

    public AttrValueIrregularException(AttrVo attrVo, IllegalArgumentException error) {
        super("模型“{0}({1})”属性“{2}({3})”的值格式异常：{4}", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName(), error.getMessage());
    }

}
