/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.cmdb.enums.resourcecenter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.util.$;

import java.util.List;
import java.util.Objects;

/**
 * 连接协议枚举类
 *
 * @author linbq
 * @since 2021/6/1 11:51
 **/
public enum Protocol implements IEnum {
    APPLICATION("application", "应用"),
    DATABASE("database", "数据库"),
    TAGENT("tagent", "代理"),
    SSH("ssh", "ssh");
    private final String value;
    private final String text;

    Protocol(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return $.t(text);
    }

    public static Protocol getProtocol(String value) {
        for (Protocol protocol : Protocol.values()) {
            if (Objects.equals(protocol.getValue(), value)) {
                return protocol;
            }
        }
        return null;
    }

    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (Protocol type : values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", type.getValue());
                    this.put("text", type.getValue());
                }
            });
        }
        return array;
    }
}
