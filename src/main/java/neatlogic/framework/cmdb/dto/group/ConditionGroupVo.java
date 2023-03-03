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

package neatlogic.framework.cmdb.dto.group;

import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.List;

public class ConditionGroupVo implements Serializable {
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
