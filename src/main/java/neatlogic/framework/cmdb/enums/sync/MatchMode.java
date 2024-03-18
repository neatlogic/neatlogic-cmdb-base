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

package neatlogic.framework.cmdb.enums.sync;

import neatlogic.framework.util.$;

public enum MatchMode {
    KEY("key", "节点名称"), LEVEL("level", "层次关系");
    private final String type;
    private final String text;

    MatchMode(String _type, String _text) {
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
        for (MatchMode s : MatchMode.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return null;
    }
}
