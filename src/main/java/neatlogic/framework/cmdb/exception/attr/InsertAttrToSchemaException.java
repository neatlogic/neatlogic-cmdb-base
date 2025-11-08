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

public class InsertAttrToSchemaException extends ApiRuntimeException {
    public InsertAttrToSchemaException(String attrName) {
        super("无法将属性“{0}”添加到数据表，具体错误请查看系统日志", attrName);
    }

    public InsertAttrToSchemaException(String attrName, int limit) {
        super("无法将属性“{0}”添加到数据表，索引数量已经超过上限{1}", attrName, limit);
    }
}
