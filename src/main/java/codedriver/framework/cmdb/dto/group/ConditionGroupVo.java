/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.group;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class ConditionGroupVo {
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
