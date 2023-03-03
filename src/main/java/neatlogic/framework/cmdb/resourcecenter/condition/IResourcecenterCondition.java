/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package neatlogic.framework.cmdb.resourcecenter.condition;

import neatlogic.framework.dto.condition.ConditionVo;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface IResourcecenterCondition {
    /**
     * 条件英文名
     * @return 条件英文名
     */
    String getName();

    /**
     * 条件显示名
     * @return 条件显示名
     */
    String getDisplayName();

    /**
     * 根据值获取值的text
     * @param value 值
     * @param config 配置
     * @return text
     */
    Object valueConversionText(Object value, JSONObject config);

    /**
     * 获取动态where sql
     * @param conditionList 条件
     * @param index 当前条件下标
     * @param sqlSb 动态where sql
     */
    void getSqlConditionWhere(List<ConditionVo> conditionList, Integer index, StringBuilder sqlSb, String searchMode);
    
}
