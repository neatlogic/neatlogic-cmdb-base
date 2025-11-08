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

package neatlogic.framework.cmdb.diagram.source;

import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class DiagramSourceFactory {
    private static final Map<String, IDiagramSourceHandler> handlerMap = new HashMap<>();
    private static final List<IDiagramSourceHandler> handlerList = new ArrayList<>();
    private static final List<IDiagramSourceEnum> enumList = new ArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(DiagramSourceFactory.class);

    static {
        Reflections reflections = new Reflections("neatlogic");
        Set<Class<? extends IDiagramSourceHandler>> modules = reflections.getSubTypesOf(IDiagramSourceHandler.class);
        for (Class<? extends IDiagramSourceHandler> c : modules) {
            IDiagramSourceHandler handler;
            try {
                handler = c.newInstance();
                if (StringUtils.isNotBlank(handler.getType())) {
                    handlerMap.put(handler.getType(), handler);
                    handlerList.add(handler);
                }
            } catch (Exception ignored) {
            }
        }

        Reflections enumReflections = new Reflections("neatlogic");
        Set<Class<? extends IDiagramSourceEnum>> enums = enumReflections.getSubTypesOf(IDiagramSourceEnum.class);
        for (Class<? extends IDiagramSourceEnum> c : enums) {
            if (!c.isInterface()) {
                //处理具名枚举
                try {
                    Object instance;
                    Object[] objects = c.getEnumConstants();
                    if (objects != null && objects.length > 0) {
                        instance = objects[0];
                    } else {
                        instance = c.newInstance();
                    }
                    if (instance != null) {
                        enumList.add((IDiagramSourceEnum) instance);
                    }
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                }
            } else {
                for (Class<?> cls : reflections.getSubTypesOf(c)) {
                    if (!cls.isInterface()) {
                        Object instance = null;
                        Object[] objects = cls.getEnumConstants();
                        if (objects != null && objects.length > 0) {
                            instance = objects[0];
                        } else {
                            try {
                                instance = cls.newInstance();
                            } catch (Exception ignored) {

                            }
                        }
                        if (instance != null) {
                            enumList.add((IDiagramSourceEnum) instance);
                        }
                    }
                }
            }
        }
    }

    public static IDiagramSourceHandler getHandler(String type) {
        return handlerMap.get(type);
    }

    public static List<IDiagramSourceHandler> getHandlerList() {
        return handlerList;
    }

    public static IDiagramSourceEnum getEnum(String value) {
        Optional<IDiagramSourceEnum> op = enumList.stream().filter(d -> d.getValue().equals(value)).findAny();
        return op.orElse(null);
    }
}
