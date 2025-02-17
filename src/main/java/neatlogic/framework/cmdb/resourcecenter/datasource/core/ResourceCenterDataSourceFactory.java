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

package neatlogic.framework.cmdb.resourcecenter.datasource.core;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;

import java.util.Map;

@RootComponent
public class ResourceCenterDataSourceFactory extends ModuleInitializedListenerBase {

    private static IResourceCenterDataSource resourceCenterDataSource = null;

    public static IResourceCenterDataSource getResourceCenterDataSource() {
        return resourceCenterDataSource;
    }

    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IResourceCenterDataSource> myMap = context.getBeansOfType(IResourceCenterDataSource.class);
        for (Map.Entry<String, IResourceCenterDataSource> entry : myMap.entrySet()) {
            IResourceCenterDataSource value = entry.getValue();
            IResourceCenterDataSource other = resourceCenterDataSource;
            if (other != null) {
                if (other.getOrdered().getValue() < value.getOrdered().getValue()) {
                    resourceCenterDataSource = value;
                }
            } else {
                resourceCenterDataSource = value;
            }
        }
    }

    @Override
    protected void myInit() {

    }
}
