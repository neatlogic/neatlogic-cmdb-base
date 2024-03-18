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
