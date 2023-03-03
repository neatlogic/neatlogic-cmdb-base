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
