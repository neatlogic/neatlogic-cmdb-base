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
