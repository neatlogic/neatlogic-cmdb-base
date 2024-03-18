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

import neatlogic.framework.util.$;

public enum UniqueType {
    TYPE("type", "同类唯一"), GLOBAL("global", "全局唯一");

    private String value;
    private String text;

    private UniqueType(String _value, String _text) {
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
		for (UniqueType s : UniqueType.values()) {
			if (s.getValue().equals(_status)) {
				return s.getValue();
			}
		}
		return null;
	}

	public static String getText(String name) {
		for (UniqueType s : UniqueType.values()) {
			if (s.getValue().equals(name)) {
				return s.getText();
			}
		}
		return "";
	}
}
