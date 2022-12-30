/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.resourcecenter.condition;

import codedriver.framework.dto.condition.ConditionVo;
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
    void getSqlConditionWhere(List<ConditionVo> conditionList, Integer index, StringBuilder sqlSb);
}
