/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.legalvalid;

import codedriver.framework.common.constvalue.IEnum;
import codedriver.framework.common.dto.ValueTextVo;

import java.util.ArrayList;
import java.util.List;

public enum LegalValidType implements IEnum<ValueTextVo> {
    CI("ci", "模型规则"), CUSTOM("custom", "自定义规则");
    private final String type;
    private final String text;

    LegalValidType(String _type, String _text) {
        this.type = _type;
        this.text = _text;
    }

    public String getValue() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static String getText(String name) {
        for (LegalValidType s : LegalValidType.values()) {
            if (s.getValue().equals(name)) {
                return s.getText();
            }
        }
        return null;
    }


    @Override
    public List<ValueTextVo> getValueTextList() {
        List<ValueTextVo> returnList = new ArrayList<>();
        for (LegalValidType s : LegalValidType.values()) {
            returnList.add(new ValueTextVo(s.getValue(), s.getText()));
        }
        return returnList;
    }
}
