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

package neatlogic.framework.cmdb.enums.legalvalid;

import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.util.$;

import java.util.ArrayList;
import java.util.List;

public enum LegalValidType implements IEnum<ValueTextVo> {
    CI("ci", "模型规则"), CUSTOM("custom", "自定义规则");
    private final String type;
    private final String text;

    LegalValidType(String _type, String _text) {
        this.type = _type;
        this.text = _text;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getText(String name) {
        for (LegalValidType s : LegalValidType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return null;
    }


    @Override
    public List<ValueTextVo> getValueTextList() {
        List<ValueTextVo> returnList = new ArrayList<>();
        for (LegalValidType s : LegalValidType.values()) {
            returnList.add(new ValueTextVo(s.getValue(), s.getText()));
        }
        return returnList;
    }
}
