/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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
