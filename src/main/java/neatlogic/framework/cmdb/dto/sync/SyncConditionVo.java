/*
 * Copyright(c) 2023 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.sync;

import neatlogic.framework.cmdb.enums.sync.ExpressionType;
import neatlogic.framework.cmdb.enums.sync.FieldType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;

public class SyncConditionVo {
    @EntityField(name = "策略id", type = ApiParamType.LONG)
    private Long syncPolicyId;
    @EntityField(name = "字段", type = ApiParamType.STRING)
    private String field;
    @EntityField(name = "字段数据类型", type = ApiParamType.ENUM, member = FieldType.class)
    private String type;
    @EntityField(name = "expression", type = ApiParamType.ENUM, member = ExpressionType.class)
    private String expression;
    @EntityField(name = "值", type = ApiParamType.STRING)
    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 转换成mongodb需要的数据格式
     *
     * @return 数据
     */
    @JSONField(serialize = false)
    public Object getFormatValue() {
        if (StringUtils.isNotEmpty(value)) {
            if (this.getType().equalsIgnoreCase(FieldType.STRING.getValue())) {
                if (value.contains(",")) {
                    return value.split(",");
                } else {
                    return value;
                }
            } else if (this.getType().equalsIgnoreCase(FieldType.INTEGER.getValue()) || this.getType().equalsIgnoreCase(FieldType.INT.getValue())) {
                try {
                    return Integer.parseInt(value);
                } catch (Exception ignored) {

                }
            } else if (this.getType().equalsIgnoreCase(FieldType.FLOAT.getValue())) {
                try {
                    return Float.parseFloat(value);
                } catch (Exception ignored) {

                }
            } else if (this.getType().equalsIgnoreCase(FieldType.DATETIME.getValue())) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return formatter.parse(value);
                } catch (Exception ignored) {

                }
            }
        }
        return null;
    }


    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }
}
