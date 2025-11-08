/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
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
