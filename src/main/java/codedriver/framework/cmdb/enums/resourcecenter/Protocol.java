/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.resourcecenter;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

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
    DATABASE("sqlfile", "数据库"),
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
        return text;
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
