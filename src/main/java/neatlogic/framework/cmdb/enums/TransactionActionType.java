/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public enum TransactionActionType implements IEnum<JSONObject> {
    INSERT("insert", "新增"), UPDATE("update", "修改"), DELETE("delete", "删除"), RECOVER("recover", "恢复");

    private final String value;
    private final String text;

    private TransactionActionType(String _value, String _text) {
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
        for (TransactionActionType s : TransactionActionType.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (TransactionActionType s : TransactionActionType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    @Override
    public List<JSONObject> getValueTextList() {
        List<JSONObject> returnList = new ArrayList<>();
        for (TransactionActionType input : TransactionActionType.values()) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("value", input.getValue());
            jsonObj.put("text", input.getText());
            returnList.add(jsonObj);
        }
        return returnList;
    }
}
