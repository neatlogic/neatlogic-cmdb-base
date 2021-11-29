/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.cientity;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
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
