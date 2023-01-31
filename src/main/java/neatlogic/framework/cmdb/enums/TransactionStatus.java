/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.common.constvalue.IEnum;
import neatlogic.framework.common.dto.ValueTextVo;

import java.util.ArrayList;
import java.util.List;

public enum TransactionStatus implements IEnum<ValueTextVo> {
    COMMITED("commited", "已提交"), UNCOMMIT("uncommit", "未提交"), RECOVER("recover", "已恢复"),
    EXPIRED("expired", "已失效");

    private final String value;
    private final String text;

    TransactionStatus(String _value, String _text) {
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
        for (TransactionStatus s : TransactionStatus.values()) {
            if (s.getValue().equals(_status)) {
                return s.getValue();
            }
        }
        return null;
    }

    public static String getText(String name) {
        for (TransactionStatus s : TransactionStatus.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return "";
    }

    @Override
    public List<ValueTextVo> getValueTextList() {
        List<ValueTextVo> returnList = new ArrayList<>();
        for (TransactionStatus input : TransactionStatus.values()) {
            returnList.add(new ValueTextVo(input.getValue(), input.getText()));
        }
        return returnList;
    }
}
