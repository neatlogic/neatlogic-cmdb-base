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

package neatlogic.framework.cmdb.exception.attr;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AttrNotFoundException extends ApiRuntimeException {

    public AttrNotFoundException(Long attrId) {
        super("配置项模型属性“{0}”不存在", attrId);
    }

    public AttrNotFoundException(String ciName, String attrName) {
        super("配置项模型“{0}”不存在属性“{1}”", ciName, attrName);
    }

    public AttrNotFoundException(String attrName) {
        super("配置项模型属性“{0}”不存在", attrName);
    }
}
