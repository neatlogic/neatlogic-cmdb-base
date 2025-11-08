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

package neatlogic.framework.cmdb.dto.group;

import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.List;

public class ConditionGroupVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
    private List<ConditionVo> conditionList;
    private List<String> conditionRelList;

    public List<ConditionVo> getConditionList() {
        return conditionList;
    }

    public List<String> getConditionRelList() {
        return conditionRelList;
    }

    public void setConditionRelList(List<String> conditionRelList) {
        this.conditionRelList = conditionRelList;
    }

    public void setConditionList(List<ConditionVo> conditionList) {
        this.conditionList = conditionList;
    }

    public String buildScript() {
        StringBuilder script = new StringBuilder();
        if (CollectionUtils.isNotEmpty(conditionList)) {
            for (int i = 0; i < conditionList.size(); i++) {
                if (i > 0 && CollectionUtils.isNotEmpty(conditionRelList)) {
                    if (conditionRelList.size() >= i) {
                        String joinType = conditionRelList.get(i - 1);
                        script.append(joinType.equals("and") ? " && " : " || ");
                    } else {
                        //数据异常跳出
                        break;
                    }
                }
                ConditionVo conditionVo = conditionList.get(i);
                script.append("(").append(conditionVo.buildScript()).append(")");
            }
        }
        return script.toString();
    }
}
