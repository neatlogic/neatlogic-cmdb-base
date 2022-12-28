/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.resourcecenter.condition;

import codedriver.framework.condition.core.IConditionHandler;
import codedriver.framework.dto.condition.ConditionVo;

import java.util.List;

public interface IResourcecenterCondition extends IConditionHandler {

    void getSqlConditionWhere(List<ConditionVo> conditionList, Integer index, StringBuilder sqlSb);
}
