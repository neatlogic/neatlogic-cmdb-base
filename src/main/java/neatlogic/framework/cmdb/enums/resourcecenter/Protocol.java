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
