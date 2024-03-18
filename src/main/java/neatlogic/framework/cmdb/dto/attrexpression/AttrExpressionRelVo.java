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

package neatlogic.framework.cmdb.dto.attrexpression;

public class AttrExpressionRelVo {
    private Long expressionCiId;
    private Long expressionAttrId;
    private Long valueCiId;
    private Long valueAttrId;

    public Long getExpressionCiId() {
        return expressionCiId;
    }

    public void setExpressionCiId(Long expressionCiId) {
        this.expressionCiId = expressionCiId;
    }

    public Long getExpressionAttrId() {
        return expressionAttrId;
    }

    public void setExpressionAttrId(Long expressionAttrId) {
        this.expressionAttrId = expressionAttrId;
    }

    public Long getValueCiId() {
        return valueCiId;
    }

    public void setValueCiId(Long valueCiId) {
        this.valueCiId = valueCiId;
    }

    public Long getValueAttrId() {
        return valueAttrId;
    }

    public void setValueAttrId(Long valueAttrId) {
        this.valueAttrId = valueAttrId;
    }
}
