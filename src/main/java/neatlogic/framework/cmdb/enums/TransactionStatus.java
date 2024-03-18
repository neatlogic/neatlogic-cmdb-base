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

import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.util.$;

import java.util.ArrayList;
import java.util.List;

public enum TransactionStatus implements IEnum<ValueTextVo> {
    COMMITED("commited", "已提交"),
    UNCOMMIT("uncommit", "未提交"),
    RECOVER("recover", "已恢复"),
    EXPIRED("expired", "已失效");

    private final String value;
    private final String text;

    TransactionStatus(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static String getValue(String _status) {
        for (TransactionStatus s : TransactionStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (TransactionStatus s : TransactionStatus.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    @Override
    public List<ValueTextVo> getValueTextList() {
        List<ValueTextVo> returnList = new ArrayList<>();
        for (TransactionStatus input : TransactionStatus.values()) {
            returnList.add(new ValueTextVo(input.getValue(), input.getText()));
        }
        return returnList;
    }
}
