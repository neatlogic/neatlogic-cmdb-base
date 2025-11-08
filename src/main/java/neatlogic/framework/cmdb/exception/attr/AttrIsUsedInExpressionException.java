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
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class AttrIsUsedInExpressionException extends ApiRuntimeException {
    public AttrIsUsedInExpressionException(AttrVo attrVo) {
        super("当前属性已被表达式属性“{0}({1}})”引用，请先删除。", attrVo.getLabel(), attrVo.getName());
    }

    public AttrIsUsedInExpressionException(CiVo ciVo, AttrVo attrVo) {
        super("当前属性已被模型“{0}({1})”的表达式属性“{2}({3})”引用，请先删除。", ciVo.getLabel(), ciVo.getName(), attrVo.getLabel(), attrVo.getName());
    }

    public AttrIsUsedInExpressionException(List<AttrVo> attrList) {
        super("表达式属性“{0}”引用了父模型属性，请先删除。" , attrList.stream().map(a -> a.getLabel() + "(" + a.getName() + ")").collect(Collectors.joining("”,“")) );
    }

}
