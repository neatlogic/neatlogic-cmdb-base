/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.sync;

import codedriver.framework.cmdb.enums.sync.ExpressionType;
import codedriver.framework.cmdb.enums.sync.FieldType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SyncConditionVo {
    @EntityField(name = "策略id", type = ApiParamType.LONG)
    private Long syncPolicyId;
    @EntityField(name = "字段", type = ApiParamType.STRING)
    private String field;
    @EntityField(name = "字段数据类型", type = ApiParamType.ENUM, member = FieldType.class)
    private String type;
    @EntityField(name = "expression", type = ApiParamType.ENUM, member = ExpressionType.class)
    private String expression;
    @EntityField(name = "值", type = ApiParamType.JSONARRAY)
    private List<String> valueList;

    public Long getSyncPolicyId() {
        return syncPolicyId;
    }

    public void setSyncPolicyId(Long syncPolicyId) {
        this.syncPolicyId = syncPolicyId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getValueList() {
        return valueList;
    }

    /**
     * 转换成mongodb需要的数据格式
     *
     * @return 数据
     */
    @JSONField(serialize = false)
    public List<Object> getFormatValueList() {
        if (CollectionUtils.isNotEmpty(valueList)) {
            if (this.getType().equals(FieldType.STRING.getValue())) {
                return new ArrayList<>(valueList);
            } else if (this.getType().equals(FieldType.INTEGER.getValue())) {
                List<Object> newValueList = new ArrayList<>();
                for (String v : valueList) {
                    try {
                        newValueList.add(Integer.parseInt(v));
                    } catch (Exception ignored) {

                    }
                }
                return newValueList;
            } else if (this.getType().equals(FieldType.DATETIME.getValue())) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                List<Object> newValueList = new ArrayList<>();
                for (String v : valueList) {
                    try {
                        newValueList.add(formatter.parse(v));
                    } catch (Exception ignored) {

                    }
                }
                return newValueList;
            }
        }
        return null;
    }

    @JSONField(serialize = false)
    public Object getFormatValue() {
        List<Object> vList = this.getFormatValueList();
        if (CollectionUtils.isNotEmpty(vList)) {
            return valueList.get(0);
        }
        return null;
    }

    public void setValueList(List<String> valueList) {
        this.valueList = valueList;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
