/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.stream.Collectors;

public class AttrEntityDuplicateException extends ApiRuntimeException {
    private static final long serialVersionUID = 2014077344222321741L;

    public AttrEntityDuplicateException(CiVo ciVo, String label, JSONArray valueList) {
        super("模型“" + ciVo.getLabel() + "(" + ciVo.getName() + ")“属性“" + label + "”值等于“" + valueList.stream().map(Object::toString).collect(Collectors.joining("”,“")) + "”的配置项已存在");
    }

    public AttrEntityDuplicateException(CiVo ciVo, String label, List<String> valueList) {
        super("模型“" + ciVo.getLabel() + "(" + ciVo.getName() + ")“属性“" + label + "”值等于“" + String.join("”,“", valueList) + "”的配置项已存在");
    }

}
