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

package neatlogic.framework.cmdb.exception.attr;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class AttrIsUsedInExpressionException extends ApiRuntimeException {
    public AttrIsUsedInExpressionException(AttrVo attrVo) {
        super("当前属性已被表达式属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")" + "”引用，请先删除。");
    }

    public AttrIsUsedInExpressionException(CiVo ciVo, AttrVo attrVo) {
        super("当前属性已被模型“" + ciVo.getLabel() + "(" + ciVo.getName() + ")" + "”的表达式属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")" + "”引用，请先删除。");
    }

    public AttrIsUsedInExpressionException(List<AttrVo> attrList) {
        super("表达式属性“" + attrList.stream().map(a -> a.getLabel() + "(" + a.getName() + ")").collect(Collectors.joining("”,“")) + "”引用了父模型属性，请先删除。");
    }

}
