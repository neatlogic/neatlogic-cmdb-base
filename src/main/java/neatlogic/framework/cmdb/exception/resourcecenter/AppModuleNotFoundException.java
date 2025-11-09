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

package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author linbq
 * @since 2021/6/17 10:34
 **/
public class AppModuleNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8738518138638398100L;

    public AppModuleNotFoundException(Long id) {
        super("应用模块：“{0}”不存在", id);
    }

    public AppModuleNotFoundException(String name) {
        super("应用模块：“{0}”不存在", name);
    }
}
