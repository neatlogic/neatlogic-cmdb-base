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

package neatlogic.framework.cmdb.resourcecenter.condition;

import neatlogic.framework.common.constvalue.Expression;
import neatlogic.framework.dto.condition.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class ResourcecenterConditionUtil {

    public static String getBuildNaturalLanguageExpressions(ConditionConfigVo conditionConfigVo) {
        List<ConditionGroupVo> conditionGroupList = conditionConfigVo.getConditionGroupList();
        Map<String, ConditionGroupVo> conditionGroupMap = conditionConfigVo.getConditionGroupMap();
        List<ConditionGroupRelVo> conditionGroupRelList = conditionConfigVo.getConditionGroupRelList();
        if (CollectionUtils.isNotEmpty(conditionGroupRelList)) {
            StringBuilder script = new StringBuilder();
            script.append("(");
            String toUuid = null;
            for (ConditionGroupRelVo conditionGroupRelVo : conditionGroupRelList) {
                script.append(getBuildNaturalLanguageExpressions(conditionGroupMap.get(conditionGroupRelVo.getFrom())));
                script.append("and".equals(conditionGroupRelVo.getJoinType()) ? "并且" : " 或者 ");
                toUuid = conditionGroupRelVo.getTo();
            }
            script.append(getBuildNaturalLanguageExpressions(conditionGroupMap.get(toUuid)));
            script.append(")");
            return script.toString();
        } else if (CollectionUtils.isNotEmpty(conditionGroupList)) {
            ConditionGroupVo conditionGroupVo = conditionGroupList.get(0);
            return conditionGroupVo.buildScript();
        }
        return StringUtils.EMPTY;
    }

    private static String getBuildNaturalLanguageExpressions(ConditionGroupVo conditionGroupVo) {
        List<ConditionVo> conditionList = conditionGroupVo.getConditionList();
        Map<String, ConditionVo> conditionMap = conditionGroupVo.getConditionMap();
        List<ConditionRelVo> conditionRelList = conditionGroupVo.getConditionRelList();
        if (CollectionUtils.isNotEmpty(conditionRelList)) {
            StringBuilder script = new StringBuilder();
            script.append("(");
            String toUuid = null;
            for (ConditionRelVo conditionRelVo : conditionRelList) {
                script.append(getBuildNaturalLanguageExpressions(conditionMap.get(conditionRelVo.getFrom())));
                script.append("and".equals(conditionRelVo.getJoinType()) ? " 并且 " : " 或者 ");
                toUuid = conditionRelVo.getTo();
            }
            script.append(getBuildNaturalLanguageExpressions(conditionMap.get(toUuid)));
            script.append(")");
            return script.toString();
        } else if (CollectionUtils.isNotEmpty(conditionList)) {
            ConditionVo conditionVo = conditionList.get(0);
            return getBuildNaturalLanguageExpressions(conditionVo);
        }
        return StringUtils.EMPTY;
    }

    private static String getBuildNaturalLanguageExpressions(ConditionVo conditionVo) {
        IResourcecenterCondition conditionHandler = ResourcecenterConditionFactory.getHandler(conditionVo.getName());
        if (conditionHandler == null) {
            return StringUtils.EMPTY;
        }
        String textStr = StringUtils.EMPTY;
        Object textObj = conditionHandler.valueConversionText(conditionVo.getValueList(), null);
        if (textObj != null) {
            if (textObj instanceof List) {
                List<String> textList = (List<String>) textObj;
                textStr = String.join("|", textList);
            } else {
                textStr = textObj.toString();
            }
        }
        String label = conditionHandler.getDisplayName();
        String expressionName = Expression.getExpressionName(conditionVo.getExpression());
        return label + " " + expressionName + " " + textStr;
    }

}
