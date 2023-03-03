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

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;

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
    public void onInitialized(NeatLogicWebApplicationContext context) {
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
