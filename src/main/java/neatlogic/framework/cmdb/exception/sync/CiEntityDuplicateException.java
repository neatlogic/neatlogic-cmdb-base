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

package neatlogic.framework.cmdb.exception.sync;

import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONObject;

import java.util.stream.Collectors;

public class CiEntityDuplicateException extends ApiRuntimeException {
    private static final long serialVersionUID = -5366776714628472298L;

    public CiEntityDuplicateException() {
        super("exception.cmdb.cientityduplicateexception.1");
    }

    public CiEntityDuplicateException(CiEntityVo attrConditionVo, JSONObject dataObj) {
        super("exception.cmdb.cientityduplicateexception.2", attrConditionVo.getAttrFilterList().stream().map(d -> d.getLabel() + "(" + d.getName() + ") " + d.getExpressionName() + " " + String.join(",", d.getValueList()))
                .collect(Collectors.joining(" and ")), attrConditionVo.getCiLabel(), attrConditionVo.getCiName(), dataObj.toString());
    }

}
