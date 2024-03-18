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
