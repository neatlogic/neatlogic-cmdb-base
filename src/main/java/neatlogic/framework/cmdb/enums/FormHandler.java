/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
