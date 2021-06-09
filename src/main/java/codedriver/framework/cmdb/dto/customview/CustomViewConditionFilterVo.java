/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class CustomViewConditionFilterVo {
    private String attrUuid;
    private String expression;// 用户sql查询的表达式
    private List<String> valueList;

    public String getAttrUuid() {
        return attrUuid;
    }

    public void setAttrUuid(String attrUuid) {
        this.attrUuid = attrUuid;
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public List<String> getValueList() {
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    /**
     * 数据库读取时通过这个属性取值，只对非引用性属性有效
     *
     * @return 值
     */
    public String getValue() {
        if (CollectionUtils.isNotEmpty(valueList)) {
            return valueList.get(0);
        }
        return null;
    }
}
