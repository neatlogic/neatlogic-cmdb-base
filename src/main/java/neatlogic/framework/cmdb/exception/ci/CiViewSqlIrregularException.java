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

public class CiViewSqlIrregularException extends ApiRuntimeException {
    private static final long serialVersionUID = -7400715176683665370L;

    public CiViewSqlIrregularException(Exception msg) {
        super("虚拟模型SQL语句不是合法的SELECT语句：{0}", msg.getMessage());
    }

    public CiViewSqlIrregularException() {
        super("配置文件不是合法的XML文件");
    }
}
