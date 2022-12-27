/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.resourcecenter.condition;

import codedriver.framework.cmdb.enums.resourcecenter.condition.ConditionConfigType;
import com.alibaba.fastjson.JSONObject;

public abstract class ResourcecenterConditionBase implements IResourcecenterCondition{

    @Override
    public JSONObject getConfig(Enum<?> type) {
        if (type instanceof ConditionConfigType) {
            ConditionConfigType configType = (ConditionConfigType) type;
            return getConfig(configType);
        } else {
            return getConfig(ConditionConfigType.DEFAULT);
        }
    }

    @Override
    public JSONObject getConfig() {
        return getConfig(ConditionConfigType.DEFAULT);
    }

    public abstract JSONObject getConfig(ConditionConfigType type);
}
