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
