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
