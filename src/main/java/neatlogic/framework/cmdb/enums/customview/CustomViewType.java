/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.enums.customview;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public enum CustomViewType implements IEnum<JSONObject> {
    PRIVATE("private", "个人视图"),
    PUBLIC("public", "公共视图"),
    SCENE("scene", "场景视图");

    private final String value;
    private final String text;

    CustomViewType(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    @Override
    public List<JSONObject> getValueTextList() {
        List<JSONObject> array = new ArrayList<>();
        for (CustomViewType status : CustomViewType.values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", status.getValue());
                    this.put("text", status.getText());
                }
            });
        }
        return array;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getText(String name) {
        for (CustomViewType s : CustomViewType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }
}
