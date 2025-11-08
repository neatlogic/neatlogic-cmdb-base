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
