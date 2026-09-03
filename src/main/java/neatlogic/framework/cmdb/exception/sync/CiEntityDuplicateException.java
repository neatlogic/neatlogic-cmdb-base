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

package neatlogic.framework.cmdb.exception.sync;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.stream.Collectors;

public class CiEntityDuplicateException extends ApiRuntimeException {
    private static final long serialVersionUID = -5366776714628472298L;

    public CiEntityDuplicateException() {
        super("找到多个配置项，无法更新或添加");
    }

    public CiEntityDuplicateException(CiEntityVo attrConditionVo, JSONObject dataObj) {
        super("唯一规则：{0} 在模型{1}({2})中找到多个配置项，无法更新或添加，原始数据：{3}",
                // 唯一规则只处理普通属性，使用DTO提供的字符串视图拼接提示信息。
                attrConditionVo.getAttrFilterList().stream().map(d -> d.getLabel() + "(" + d.getName() + ") " + d.getExpressionName() + " " + String.join(",", d.getValueList().stream().map(Object::toString).toList()))
                .collect(Collectors.joining(" and ")), attrConditionVo.getCiLabel(), attrConditionVo.getCiName(), dataObj.toString());
    }

}
