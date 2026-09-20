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

/** 属性唯一性校验失败时，按当前请求语言返回冲突模型、属性及取值。 */
public class AttrEntityDuplicateException extends ApiRuntimeException {
    private static final long serialVersionUID = 2014077344222321741L;

    /** 接收普通属性的 JSON 值列表，保留原始业务取值。 */
    public AttrEntityDuplicateException(CiVo ciVo, String label, JSONArray valueList) {
        super("nfcec.attrentityduplicateexception.attrentityduplicateexception", ciVo.getLabel(), ciVo.getName(), label, valueList.stream().map(Object::toString).collect(Collectors.joining("”,“")));
    }

    /** 接收引用配置项的名称列表，保留原始业务名称。 */
    public AttrEntityDuplicateException(CiVo ciVo, String label, List<String> valueList) {
        super("nfcec.attrentityduplicateexception.attrentityduplicateexception", ciVo.getLabel(), ciVo.getName(), label, String.join("”,“", valueList));
    }

}
