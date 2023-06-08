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

package neatlogic.framework.cmdb.enums.sync;

import neatlogic.framework.util.$;

public enum SyncStatus {
    DOING("doing", "同步中"),
    DONE("done", "已完成");

    private final String status;
    private final String text;

    SyncStatus(String _status, String _text) {
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
        for (SyncStatus s : SyncStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getText();
            }
        }
        return "";
    }

}
