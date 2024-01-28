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

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiUniqueRuleAttrTypeIrregularException extends ApiRuntimeException {
    public CiUniqueRuleAttrTypeIrregularException(CiVo ciVo, AttrVo attrVo) {
        super("nfcec.ciuniqueruleattrtypeirregularexception.ciuniqueruleattrtypeirregularexception_a", ciVo.getLabel(), ciVo.getName(), attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueRuleAttrTypeIrregularException(AttrVo attrVo) {
        super("nfcec.ciuniqueruleattrtypeirregularexception.ciuniqueruleattrtypeirregularexception_b", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueRuleAttrTypeIrregularException(AttrVo attrVo, String configurationPath, String actualPath) {
        super("模型“{0}({1})”的唯一规则属性“{2}({3})”不能是一个表达式属性，配置路径：{4}，实际路径：{5}", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName(), configurationPath, actualPath);
    }
}
