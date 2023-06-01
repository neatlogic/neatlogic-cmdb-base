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

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.util.I18nUtils;

public enum SearchExpression {
    EQ("eq", "equal", "等于"),
    //LT("lt", "less-than", "小于"),
    //GT("gt", "greater-than", "大于"),
    BT("bt", "between", "在此区间"),
    NE("ne", "notequal", "不等于"),
    NL("nl", "notlike", "不包含"),
    LI("li", "like", "包含"),
    NULL("null", "is-null", "为空"),
    NOTNULL("notnull", "is-not-null", "不为空");

    private final String value;
    private final String text;
    private final String expression;

    SearchExpression(String _value, String _expression, String _text) {
        this.value = _value;
        this.text = _text;
        this.expression = _expression;
    }

    public static SearchExpression get(String value) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getValue().equals(value)) {
                return s;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }

    public String getExpression() {
        return expression;
    }

    public static String getValue(String value) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getValue().equals(value)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getExpression(String value) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getValue().equals(value)) {
                return s.getExpression();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    public static boolean checkExpressionIsExists(String expression) {
        for (SearchExpression s : SearchExpression.values()) {
            if (s.getExpression().equals(expression)) {
                return true;
            }
        }
        return false;
    }
}
