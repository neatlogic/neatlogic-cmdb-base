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

package neatlogic.framework.cmdb.enums.resourcecenter;

import neatlogic.framework.util.$;

public enum Status {
    NO_CONFIGURE_VIEW_RULE("no_configure_view_rule", "未配置视图规则"),
    NO_CREATE_VIEW("no_create_view", "未创建视图"),
    CREATED_VIEW("created_view", "已创建视图"),
    ERROR("error", "异常"),
    PENDING("pending", "已就绪"),
    READY("ready", "可使用");

    private final String status;
    private final String text;

    Status(String _status, String _text) {
        this.status = _status;
        this.text = _text;
    }

    public String getValue() {
        return status;
    }

    public String getText() {
        return $.t(text);
    }


    public static String getText(String _status) {
        for (Status s : Status.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }


}
