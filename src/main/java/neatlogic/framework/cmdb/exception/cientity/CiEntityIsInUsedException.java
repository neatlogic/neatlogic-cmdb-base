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
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class CiEntityIsInUsedException extends ApiRuntimeException {
    private static final long serialVersionUID = 4514486027062482261L;

    public CiEntityIsInUsedException(List<AttrVo> attrList) {
        super("exception.cmdb.cientityisinusedexception.1", attrList.stream().map(attr -> attr.getLabel() + "(" + attr.getCiLabel() + ")").collect(Collectors.joining(",")));
    }

    public CiEntityIsInUsedException(CiEntityVo ciEntityVo, List<AttrVo> attrList) {
        super("exception.cmdb.cientityisinusedexception.2", ciEntityVo.getName(), attrList.stream().map(attr -> attr.getCiLabel() + "(" + attr.getCiName() + ")" + ":" + attr.getLabel() + "(" + attr.getName() + ")").collect(Collectors.joining(",")));
    }
}