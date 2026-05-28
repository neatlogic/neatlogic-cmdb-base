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

package neatlogic.framework.cmdb.cientityevent;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;

import java.util.*;

@RootComponent
public class CiEntityEventFactory extends ModuleInitializedListenerBase {

    private static final List<ICiEntityEventHandler> handlerList = new ArrayList<>();

    /**
     * 获取按排序值排列后的配置项事件处理器列表。
     */
    public static List<ICiEntityEventHandler> getHandlerList() {
        return Collections.unmodifiableList(handlerList);
    }

    /**
     * 初始化时扫描所有模块提供的配置项事件处理器。
     */
    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, ICiEntityEventHandler> map = context.getBeansOfType(ICiEntityEventHandler.class);
        handlerList.addAll(map.values());
        handlerList.sort(Comparator.comparingInt(ICiEntityEventHandler::getSort));
    }

    @Override
    protected void myInit() {

    }
}
