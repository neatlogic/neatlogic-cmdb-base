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
 * @author lvzk
 * @since 2021/7/27 10:34
 **/
public class ResourceCenterResourceHasRepeatAccountException extends ApiRuntimeException {

    private static final long serialVersionUID = 6934793951984585148L;

    public ResourceCenterResourceHasRepeatAccountException(String resourceId, String account, String protocol) {
        super("资源“{0}”存在多个 协议为“{2}”用户名为“{1}”的账号,请联系管理员", resourceId, protocol, account);
    }
}
