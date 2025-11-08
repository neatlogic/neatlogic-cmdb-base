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

package neatlogic.framework.cmdb.exception.globalattr;

import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class GlobalAttrItemIsNotExistsException extends ApiRuntimeException {
    public GlobalAttrItemIsNotExistsException(GlobalAttrVo attrVo, String value) {
        super("全局属性“{0}”不存在值“{1}”", attrVo.getLabel(), value);
    }
}
