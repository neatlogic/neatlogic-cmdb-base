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
