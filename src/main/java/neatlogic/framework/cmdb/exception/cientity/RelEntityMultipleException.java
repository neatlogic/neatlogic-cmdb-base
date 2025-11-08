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

import neatlogic.framework.exception.core.ApiRuntimeException;

public class RelEntityMultipleException extends ApiRuntimeException {
    public RelEntityMultipleException(String label) {
        super("关系“{0}”不能存在多个", label);
    }

    public RelEntityMultipleException(String relName, String ciEntityName) {
        super("关系“{0}”的对端配置项“{1}”已经被引用", relName, ciEntityName);
    }

}
