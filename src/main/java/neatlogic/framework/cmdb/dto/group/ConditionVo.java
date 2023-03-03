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

package neatlogic.framework.cmdb.dto.group;

import com.alibaba.fastjson.JSONArray;

import java.io.Serializable;

public class ConditionVo implements Serializable {
    private enum Expression {
        EQUAL("equal", " %s == %s "),
        NOTEQUAL("notequal", " not %s contains %s "),
        NOTLIKE("notlike", " %s = %s "),
        LIKE("like", " not %s = %s "),
        ISNULL("is-null", " %s contains any ( %s ) "),
        ISNOTNULL("is-not-null", " not %s contains any ( %s ) ");
        private final String name;
        private final String expression;

        public String getName() {
            return name;
        }

        public String getExpression() {
            return expression;
        }

        Expression(String _name, String _expression) {
            this.name = _name;
            this.expression = _expression;
        }


    }

    private String uuid;
    private String id;
    private String type;
    private String expression;
    private JSONArray valueList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public JSONArray getValueList() {
        return valueList;
    }

    public void setValueList(JSONArray valueList) {
        this.valueList = valueList;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String buildScript() {
        return "calculate('" + expression + "', data['" + this.getId() + "'], condition['" + this.getUuid() + "'], define['" + this.getId() + "'])";
    }


}
