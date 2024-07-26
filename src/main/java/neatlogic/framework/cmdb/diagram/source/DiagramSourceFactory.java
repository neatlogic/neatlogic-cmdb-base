/*
 * Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.
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
