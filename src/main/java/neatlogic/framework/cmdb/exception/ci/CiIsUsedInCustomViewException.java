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
import neatlogic.framework.cmdb.dto.customview.CustomViewVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class CiIsUsedInCustomViewException extends ApiRuntimeException {
    public CiIsUsedInCustomViewException(CiVo ciVo, List<CustomViewVo> viewList) {
        super("模型“{0}({1})”已被自定义视图“{2}”引用，请先删除", ciVo.getLabel(), ciVo.getName(), viewList.stream().map(CustomViewVo::getName).collect(Collectors.joining("”,“")));
    }
}
