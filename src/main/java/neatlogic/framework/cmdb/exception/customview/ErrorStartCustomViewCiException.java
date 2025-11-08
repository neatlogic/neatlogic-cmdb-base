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

package neatlogic.framework.cmdb.exception.customview;

import neatlogic.framework.cmdb.dto.customview.CustomViewCiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class ErrorStartCustomViewCiException extends ApiRuntimeException {
    public ErrorStartCustomViewCiException(CustomViewCiVo ci) {
        super("“{0}”是起始模型，不能存在连入关系", ci.getAlias());
    }
}
