/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.dto.cientity;

import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.cmdb.enums.SearchExpression;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class AttrFilterVo implements Serializable {
    private Long attrId;
    private Long ciId;
    private String name;
    private String label;
    private String type;
    private String expressionName; // 表达式名称
    private String expression;// 用户sql查询的表达式
    private List<String> valueList;
    private List<String> valueHashList;
    @JSONField(serialize = false)
    private Boolean needTargetCi;

    public List<String> getValueHashList() {
        if (CollectionUtils.isNotEmpty(getValueList())) {
            return getValueList().stream().map(d -> DigestUtils.md5DigestAsHex(d.toLowerCase().getBytes()))
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
            return valueList.get(0);
        }
        return null;
    }

    public Boolean isNeedTargetCi() {
        return needTargetCi;
    }

    public void setNeedTargetCi(Boolean needTargetCi) {
        this.needTargetCi = needTargetCi;
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

    public List<String> getValueList() {
        if (CollectionUtils.isNotEmpty(valueList)) {
            return valueList.stream().filter(StringUtils::isNotBlank).collect(Collectors.toList());
        }
        return valueList;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
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
    }
}
