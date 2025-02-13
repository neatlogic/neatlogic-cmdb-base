/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.cmdb.resourcecenter.appmoduleresource.core;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RootComponent
public class AppModuleResourceFactory extends ModuleInitializedListenerBase {

    private static final Map<String, IAppModuleResource> componentMap = new HashMap<>();

    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IAppModuleResource> myMap = context.getBeansOfType(IAppModuleResource.class);
        for (Map.Entry<String, IAppModuleResource> entry : myMap.entrySet()) {
            IAppModuleResource appModuleResource = entry.getValue();
            IAppModuleResource other = componentMap.get(appModuleResource.getName());
            if (other != null) {
                if (other.getOrdered().getValue() < appModuleResource.getOrdered().getValue()) {
                    componentMap.remove(other.getName());
                    componentMap.put(appModuleResource.getName(), appModuleResource);
                }
            } else {
                componentMap.put(appModuleResource.getName(), appModuleResource);
            }
        }
    }

    public static IAppModuleResource getHandler(String key) {
        IAppModuleResource appModuleResource = componentMap.get(key);
        if (appModuleResource != null && appModuleResource.isEnable()) {
            return appModuleResource;
        }
        return null;
    }
    public static List<String> getNameList() {
        List<String> nameList = new ArrayList<>();
        for (Map.Entry<String, IAppModuleResource> entry : componentMap.entrySet()) {
            IAppModuleResource appModuleResource = entry.getValue();
            if (appModuleResource.isEnable()) {
                nameList.add(appModuleResource.getName());
            }
        }
        return nameList;
    }

    @Override
    protected void myInit() {

    }
}
