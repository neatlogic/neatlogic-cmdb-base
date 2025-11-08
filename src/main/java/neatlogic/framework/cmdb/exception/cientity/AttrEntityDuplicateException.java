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

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class AttrEntityDuplicateException extends ApiRuntimeException {
    private static final long serialVersionUID = 2014077344222321741L;

    public AttrEntityDuplicateException(CiVo ciVo, String label, JSONArray valueList) {
        super("模型“{0}({1})“属性“{2}”值等于“{3}”的配置项已存在", ciVo.getLabel(), ciVo.getName(), label, valueList.stream().map(Object::toString).collect(Collectors.joining("”,“")));
    }

    public AttrEntityDuplicateException(CiVo ciVo, String label, List<String> valueList) {
        super("模型“{0}({1})“属性“{2}”值等于“{3}”的配置项已存在", ciVo.getLabel(), ciVo.getName(), label, String.join("”,“", valueList));
    }

}
