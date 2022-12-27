/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.resourcecenter.condition;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RootComponent
public class ResourcecenterConditionFactory extends ModuleInitializedListenerBase {

    private static final Map<String, IResourcecenterCondition> conditionComponentMap = new HashMap<>();

    private static final List<IResourcecenterCondition> conditionHandlerList = new ArrayList<>();

    public static IResourcecenterCondition getHandler(String name) {
        return conditionComponentMap.get(name);
    }

    public static List<IResourcecenterCondition> getConditionHandlerList() {
        return conditionHandlerList;
    }

    @Override
    public void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IResourcecenterCondition> myMap = context.getBeansOfType(IResourcecenterCondition.class);
        for (Map.Entry<String, IResourcecenterCondition> entry : myMap.entrySet()) {
            IResourcecenterCondition condition = entry.getValue();
            conditionComponentMap.put(condition.getName(), condition);
            conditionHandlerList.add(condition);
        }
    }

    public static Map<String, IResourcecenterCondition> getConditionComponentMap() {
        return conditionComponentMap;
    }

    @Override
    protected void myInit() {
        // TODO Auto-generated method stub

    }

}
