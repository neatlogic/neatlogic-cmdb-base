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

package neatlogic.framework.cmdb.dto.customview;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomViewConditionFilterVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
    @EntityField(name = "属性唯一标识", type = ApiParamType.STRING)
    private String attrName;
    @EntityField(name = "属性uuid", type = ApiParamType.STRING)
    private String attrUuid;
    @EntityField(name = "表达式", type = ApiParamType.STRING)
    private String expression;// 用户sql查询的表达式
    private JSONArray valueList;
    private JSONArray actualValueList;
    private List<String> valueStringList;
    private List<String> actualValueStringList;
    private String type;//类型，attr或constattr或globalattr
    private String attrType;//属性的类型

    public CustomViewConditionFilterVo() {

    }

    public CustomViewConditionFilterVo(String _attrUuid, String _type, String _attrType, String _expression, JSONArray _valueList) {
        this.attrUuid = _attrUuid;
        this.attrType = _attrType;
        this.type = _type;
        this.expression = _expression;
        this.valueList = _valueList;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    public JSONArray getValueList() {
        return valueList;
    }


    public void setValueList(JSONArray valueList) {
        this.valueList = valueList;
    }

    public List<String> getValueStringList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < this.valueList.size(); i++) {
            list.add(this.valueList.getString(i));
        }
        return list;
    }

    public List<String> getActualValueStringList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < this.actualValueList.size(); i++) {
            list.add(this.actualValueList.getString(i));
        }
        return list;
    }

    public JSONArray getActualValueList() {
        return actualValueList;
    }

    public void setActualValueList(JSONArray actualValueList) {
        this.actualValueList = actualValueList;
    }

    /**
     * 数据库读取时通过这个属性取值，只对非引用性属性有效
     *
     * @return 值
     */
    public String getValue() {
        if (CollectionUtils.isNotEmpty(valueList)) {
            return valueList.getString(0);
        }
        return null;
    }
}
