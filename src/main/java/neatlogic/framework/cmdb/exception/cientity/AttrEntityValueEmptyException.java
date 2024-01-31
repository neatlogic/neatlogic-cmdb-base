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

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AttrEntityValueEmptyException extends ApiRuntimeException {
    public AttrEntityValueEmptyException(String msg) {
        super("nfcec.attrentityvalueemptyexception.attrentityvalueemptyexception_a", msg);
    }

    public AttrEntityValueEmptyException(CiVo ciVo, AttrVo attrVo) {
        super("nfcec.attrentityvalueemptyexception.attrentityvalueemptyexception_b", ciVo.getLabel(), ciVo.getName(), attrVo.getLabel(), attrVo.getName());
    }
}
