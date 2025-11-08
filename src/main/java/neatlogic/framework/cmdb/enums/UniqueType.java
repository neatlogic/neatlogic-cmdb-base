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
