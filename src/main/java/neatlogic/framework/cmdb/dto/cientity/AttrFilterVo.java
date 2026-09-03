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

package neatlogic.framework.cmdb.dto.cientity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.cmdb.attrvaluehandler.core.AttrValueHandlerFactory;
import neatlogic.framework.cmdb.attrvaluehandler.core.IAttrValueHandler;
import neatlogic.framework.cmdb.enums.SearchExpression;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AttrFilterVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;

    private Long attrId;
    private Long ciId;
    private String name;
    private String label;
    private String type;
    private String expressionName; // 表达式名称
    private String expression;// 用户sql查询的表达式
    // 使用JSONArray同时承载普通属性标量值和引用属性结构化值。
    private JSONArray valueList;
    private List<String> valueHashList;
    @JSONField(serialize = false)
    private Boolean needTargetCi;
    // 标识属性值是否保存于cmdb_attr_invoke表，仅供后端组装查询SQL使用。
    @JSONField(serialize = false, deserialize = false)
    private Boolean isInvokeAttr;

    @Override
    public String toString() {
        return "AttrFilterVo{" +
                "attrId=" + attrId +
                ", ciId=" + ciId +
                ", name='" + name + '\'' +
                ", label='" + label + '\'' +
                ", type='" + type + '\'' +
                ", expression='" + expression + '\'' +
                ", valueList=" + valueList +
                '}';
    }

    public List<String> getValueHashList() {
        List<String> stringValueList = getStringValueList();
        if (CollectionUtils.isNotEmpty(stringValueList)) {
            return stringValueList.stream().map(d -> DigestUtils.md5DigestAsHex(d.toLowerCase().getBytes()))
                    .collect(Collectors.toList());
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getCiId() {
        return ciId;
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

    public Boolean isNeedTargetCi() {
        return needTargetCi;
    }

    public void setNeedTargetCi(Boolean needTargetCi) {
        this.needTargetCi = needTargetCi;
    }

    /**
     * 根据属性处理器判断过滤条件是否需要查询cmdb_attr_invoke表。
     *
     * @return true表示属性值保存于cmdb_attr_invoke表
     */
    public Boolean getIsInvokeAttr() {
        if (isInvokeAttr == null) {
            isInvokeAttr = false;
            if (StringUtils.isNotBlank(type)) {
                IAttrValueHandler handler = AttrValueHandlerFactory.getHandler(type);
                isInvokeAttr = handler != null && handler.isInvokeAttr();
            }
        }
        return isInvokeAttr;
    }

    public void setIsInvokeAttr(Boolean isInvokeAttr) {
        this.isInvokeAttr = isInvokeAttr;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    /**
     * 获取表名
     *
     * @return 表名
     */
    @JSONField(serialize = false)
    public String getCiTableName() {
        return TenantContext.get().getDataDbName() + ".`cmdb_" + this.getCiId() + "`";
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public JSONArray getValueList() {
        if (CollectionUtils.isNotEmpty(valueList)) {
            // 普通字符串条件继续过滤空值，JSONObject等结构化引用值原样保留。
            JSONArray validValueList = new JSONArray();
            for (Object value : valueList) {
                if (value != null && (!(value instanceof String) || StringUtils.isNotBlank((String) value))) {
                    validValueList.add(value);
                }
            }
            return validValueList;
        }
        return valueList;
    }

    public void setValueList(JSONArray valueList) {
        this.valueList = valueList;
    }

    /**
     * 兼容现有Java调用方以List设置普通属性过滤值，统一转换为JSONArray保存。
     *
     * @param valueList 普通属性过滤值
     */
    @JSONField(serialize = false, deserialize = false)
    public void setValueList(List<?> valueList) {// 新增
        if (valueList == null) {
            this.valueList = null;
            return;
        }
        this.valueList = new JSONArray();
        this.valueList.addAll(valueList);
    }

    /**
     * 获取普通属性逻辑需要的字符串值，避免结构化存储改变原有Java调用方式。
     *
     * @return 字符串过滤值列表
     */
    @JSONField(serialize = false)
    public List<String> getStringValueList() {// 新增
        List<String> stringValueList = new ArrayList<>();
        JSONArray currentValueList = getValueList();
        if (CollectionUtils.isNotEmpty(currentValueList)) {
            for (Object value : currentValueList) {
                if (value != null) {
                    stringValueList.add(value.toString());
                }
            }
        }
        return stringValueList;
    }

    public String getExpressionName() {
        if (StringUtils.isNotBlank(expression) && StringUtils.isBlank(expressionName)) {
            expressionName = SearchExpression.getText(expression);
        }
        return expressionName;
    }

    public void setExpressionName(String expressionName) {
        this.expressionName = expressionName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        // 属性类型改变后清除缓存，确保查询方式始终以最新处理器定义为准。
        this.isInvokeAttr = null;
    }
}
