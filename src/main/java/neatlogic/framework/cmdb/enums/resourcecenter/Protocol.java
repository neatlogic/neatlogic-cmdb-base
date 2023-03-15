/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.cmdb.enums.resourcecenter;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.util.I18nUtils;

import java.util.List;
import java.util.Objects;

/**
 * 连接协议枚举类
 *
 * @author linbq
 * @since 2021/6/1 11:51
 **/
public enum Protocol implements IEnum {
    APPLICATION("application", "enum.cmdb.protocol.application"),
    DATABASE("database", "enum.cmdb.protocol.database"),
    TAGENT("tagent", "enum.cmdb.protocol.tagent"),
    SSH("ssh", "enum.cmdb.protocol.ssh");
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
        return I18nUtils.getMessage(text);
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
