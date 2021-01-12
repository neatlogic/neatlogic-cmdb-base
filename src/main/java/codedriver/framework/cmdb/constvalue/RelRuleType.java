package codedriver.framework.cmdb.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum RelRuleType implements IEnum {
    ZO("0:1", "零或一个"), ZN("0:N", "零或多个"), ON("1:N", "一或多个"), OO("1:1", "必须一个");

    private String value;
    private String text;

    private RelRuleType(String _value, String _text) {
        this.value = _value;
        this.text = _text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public static String getValue(String _status) {
        for (RelRuleType s : RelRuleType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (RelRuleType s : RelRuleType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }


    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for(RelRuleType type : RelRuleType.values()){
            array.add(new JSONObject(){
                {
                    this.put("value",type.getValue());
                    this.put("text",type.getText());
                }
            });
        }
        return array;
    }
}
