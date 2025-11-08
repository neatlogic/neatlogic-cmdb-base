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

package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class CiEntityIsInUsedException extends ApiRuntimeException {
    private static final long serialVersionUID = 4514486027062482261L;

    public CiEntityIsInUsedException(List<AttrVo> attrList) {
        super("当前配置项已经被以下属性引用：{0}", attrList.stream().map(attr -> attr.getLabel() + "(" + attr.getCiLabel() + ")").collect(Collectors.joining(",")));
    }

    public CiEntityIsInUsedException(CiEntityVo ciEntityVo, List<AttrVo> attrList) {
        super("配置项“{0}”已被以下属性引用：{1}", ciEntityVo.getName(), attrList.stream().map(attr -> attr.getCiLabel() + "(" + attr.getCiName() + ")" + ":" + attr.getLabel() + "(" + attr.getName() + ")").collect(Collectors.joining(",")));
    }
}
