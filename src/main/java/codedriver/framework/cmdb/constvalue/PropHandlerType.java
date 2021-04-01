package codedriver.framework.cmdb.constvalue;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public enum PropHandlerType implements IEnum {
    TEXT("text", "文本框", "ts-code"), MTEXT("mtext", "多文本框", "ts-bars"), DATE("date", "日期", "ts-calendar"),
    TEXTAREA("textarea", "文本域", "ts-textmodule"), SELECT("select", "下拉框", "ts-list"),
    CHECKBOX("checkbox", "复选框", "ts-check-square-o"), RADIO("radio", "单选框", "ts-round-s"),
    FILE("file", "附件", "ts-file"), URL("url", "链接", "ts-link"), PASSWORD("password", "密码", "ts-eye-close"),
    /*USER("user", "用户", "ts-user"), TEAM("team", "组织", "ts-team"),*/ TABLE("table", "表格", "ts-tablechart");

    private String type;
    private String text;
    private String icon;

    private PropHandlerType(String _type, String _text, String _icon) {
        this.type = _type;
        this.text = _text;
        this.icon = _icon;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return text;
    }

    public String getIcon() {
        return icon;
    }

    public static String getValue(String name) {
        for (PropHandlerType s : PropHandlerType.values()) {
            if (s.getValue().equals(name)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (PropHandlerType s : PropHandlerType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    public static String getIcon(String name) {
        for (PropHandlerType s : PropHandlerType.values()) {
            if (s.getValue().equals(name)) {
                return s.getIcon();
            }
        }
        return "";
    }


    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for(PropHandlerType type : PropHandlerType.values()){
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
