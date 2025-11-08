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

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.form.constvalue.IFormHandler;
import neatlogic.framework.util.$;

public enum FormHandler implements IFormHandler {
    FORMCIENTITYMODIFY("formcientitymodify", "配置项修改组件"),
    FORMCIENTITYSELECTOR("formcientityselector", "配置项选择组件"),
    FORMACCOUNTS("formaccounts", "账号组件"),
    FORMPROTOCOL("formprotocol", "连接协议"),
    FORMRESOURECES("formresoureces", "执行目标"),
    ;

    private final String handler;
    private final String handlerName;

    FormHandler(String handler, String handlerName) {
        this.handler = handler;
        this.handlerName = handlerName;
    }

    @Override
    public String getHandler() {
        return handler;
    }

    @Override
    public String getHandlerName() {
        return $.t(handlerName);
    }
}
