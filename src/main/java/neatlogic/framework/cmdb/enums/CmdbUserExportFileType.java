/*
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.userexportfile.core.IUserExportFileType;
import neatlogic.framework.util.$;

public enum CmdbUserExportFileType implements IUserExportFileType {
    CUSTOMVIEW_DATA("customViewData", "nfce.cmdbuserexportfiletype.customviewdata")
    ;

    private final String value;
    private final String text;

    CmdbUserExportFileType(String value, String text) {
        this.value = value;
        this.text = text;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getText() {
        return $.t(this.text);
    }
}
