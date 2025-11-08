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

package neatlogic.framework.cmdb.enums.sync;

import neatlogic.framework.cmdb.enums.BatchImportStatus;
import neatlogic.framework.util.$;

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
        return $.t(text);
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
