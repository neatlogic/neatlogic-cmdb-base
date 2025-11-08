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
