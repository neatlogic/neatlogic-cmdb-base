/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.dto.sync;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.enums.sync.ExpressionType;
import neatlogic.framework.cmdb.enums.sync.FieldType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class SyncConditionVo implements Serializable {
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
