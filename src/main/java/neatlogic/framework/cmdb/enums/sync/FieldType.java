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

import neatlogic.framework.cmdb.enums.BatchImportStatus;
import neatlogic.framework.util.I18nUtils;

public enum FieldType {
    STRING("string", "字符串"),
    DATETIME("datetime", "日期"),
    DOCUMENT("document", "文档"),
    INTEGER("integer", "整型"),
    INT("int", "整型"),
    FLOAT("float", "单精度");
    private final String type;
    private final String text;

    FieldType(String _type, String _text) {
        this.type = _type;
        this.text = _text;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public static String getValue(String name) {
        for (BatchImportStatus s : BatchImportStatus.values()) {
            if (s.getValue().equals(name)) {
                return s.getValue();
            }
        }
        return null;
    }

}
