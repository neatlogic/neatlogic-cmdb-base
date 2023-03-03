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
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SyncFieldVo {
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "说明", type = ApiParamType.STRING)
    private String desc;
    @EntityField(name = "数据类型", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "表达式列表", type = ApiParamType.JSONARRAY)
    private List<ValueTextVo> expressionList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ValueTextVo> getExpressionList() {
        if (CollectionUtils.isEmpty(expressionList) && StringUtils.isNotBlank(type)) {
            List<ExpressionType> tmpList = ExpressionType.getExpressionBySupportType(type);
            if (CollectionUtils.isNotEmpty(tmpList)) {
                expressionList = new ArrayList<>();
                for (ExpressionType type : tmpList) {
                    expressionList.add(new ValueTextVo(type.getValue(), type.getText()));
                }
            }
        }
        return expressionList;
    }

    public void setExpressionList(List<ValueTextVo> expressionList) {
        this.expressionList = expressionList;
    }
}
