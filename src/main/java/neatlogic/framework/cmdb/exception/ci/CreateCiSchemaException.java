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

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CreateCiSchemaException extends ApiRuntimeException {
    private static final long serialVersionUID = 1868035134643467683L;

    public CreateCiSchemaException(String ciName) {
        super("创建模型“{0}”数据表失败", ciName);
    }

    public CreateCiSchemaException(String ciName, boolean isView) {
        super("创建模型“{0}”数据视图失败", ciName);
    }
}
