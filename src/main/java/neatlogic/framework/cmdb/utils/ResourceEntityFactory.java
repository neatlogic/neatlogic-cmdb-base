/*
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package neatlogic.framework.cmdb.utils;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.cmdb.annotation.ResourceTypes;
import neatlogic.framework.cmdb.dto.resourcecenter.config.SceneEntityVo;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

/**
 * @author linbq
 * @since 2022/2/9 14:17
 **/
public class ResourceEntityFactory {
    private static Logger logger = LoggerFactory.getLogger(ResourceEntityFactory.class);
    /**
     * 视图名称与字段列表映射关系
     */
    private static Map<String, List<JSONObject>> fieldMap = new HashMap<>();
    /**
     * 视图信息列表
     */
    private static List<SceneEntityVo> sceneEntityList = new ArrayList<>();
    /**
     * 视图名称列表
     */
    private static List<String> viewNameList = new ArrayList<>();

    static {
        Reflections ref = new Reflections("neatlogic");
        Set<Class<?>> classList = ref.getTypesAnnotatedWith(ResourceType.class, true);
        for (Class<?> c : classList) {
            SceneEntityVo sceneEntityVo = null;
            Annotation[] classAnnotations = c.getDeclaredAnnotations();
            for (Annotation annotation : classAnnotations) {
                if (annotation instanceof ResourceType) {
                    ResourceType rt = (ResourceType) annotation;
                    if (viewNameList.contains(rt.name())) {
                        logger.error("view '" + rt.name() + "' repeats the declaration");
                        System.exit(1);
                    }
                    viewNameList.add(rt.name());
                    sceneEntityVo = new SceneEntityVo();
                    sceneEntityVo.setName(rt.name());
                    sceneEntityVo.setLabel(rt.label());
                    sceneEntityVo.setIsMultiple(rt.isMultiple());
                    sceneEntityVo.setModuleId(rt.moduleId());
                    sceneEntityVo.setDescription(String.join("；", rt.functionPathList()));
                }
            }
            if (sceneEntityVo == null) {
                continue;
            }
            for (Field field : c.getDeclaredFields()) {
                ResourceField rf = field.getAnnotation(ResourceField.class);
                if (rf != null) {
                    if (StringUtils.isNotBlank(rf.name())) {
                        EntityField ef = field.getAnnotation(EntityField.class);
                        fieldMap.computeIfAbsent(sceneEntityVo.getName(), key -> new ArrayList<>()).add(new JSONObject().fluentPut("property", field.getName()).fluentPut("column", rf.name()).fluentPut("label", ef.name()));
                    }
                }
            }
            sceneEntityList.add(sceneEntityVo);
        }
        classList = ref.getTypesAnnotatedWith(ResourceTypes.class, true);
        for (Class<?> c : classList) {
            ResourceTypes resourceTypes = c.getAnnotation(ResourceTypes.class);
            if (resourceTypes != null) {
                for (ResourceType rt : resourceTypes.value()) {
                    if (viewNameList.contains(rt.name())) {
                        logger.error("view '" + rt.name() + "' repeats the declaration");
                        System.exit(1);
                    }
                    viewNameList.add(rt.name());
                    SceneEntityVo sceneEntityVo = new SceneEntityVo();
                    sceneEntityVo.setName(rt.name());
                    sceneEntityVo.setLabel(rt.label());
                    sceneEntityVo.setIsMultiple(rt.isMultiple());
                    sceneEntityVo.setModuleId(rt.moduleId());
                    sceneEntityVo.setDescription(String.join("；", rt.functionPathList()));
                    for (Field field : c.getDeclaredFields()) {
                        ResourceField rf = field.getAnnotation(ResourceField.class);
                        if (rf != null) {
                            if (StringUtils.isNotBlank(rf.name())) {
                                EntityField ef = field.getAnnotation(EntityField.class);
                                fieldMap.computeIfAbsent(sceneEntityVo.getName(), key -> new ArrayList<>()).add(new JSONObject().fluentPut("property", field.getName()).fluentPut("column", rf.name()).fluentPut("label", ef.name()));
                            }
                        }
                    }
                    sceneEntityList.add(sceneEntityVo);
                }
            }
        }
        String[] viewNameArray = new String[viewNameList.size()];
        viewNameList.toArray(viewNameArray);
        Arrays.sort(viewNameArray);
        viewNameList = Arrays.asList(viewNameArray);
        sceneEntityList.sort(Comparator.comparingInt(e -> viewNameList.indexOf(e.getName())));
    }

    public static List<SceneEntityVo> getSceneEntityList() {
        List<SceneEntityVo> resultList = new ArrayList<>();
        for (SceneEntityVo sceneEntity : sceneEntityList) {
            if (Objects.equals(sceneEntity.getIsMultiple(), false)) {
                resultList.add(sceneEntity);
            }
        }
        return resultList;
    }

    public static List<SceneEntityVo> getMultipleSceneEntityList() {
        List<SceneEntityVo> resultList = new ArrayList<>();
        for (SceneEntityVo sceneEntity : sceneEntityList) {
            if (Objects.equals(sceneEntity.getIsMultiple(), true)) {
                resultList.add(sceneEntity);
            }
        }
        return resultList;
    }

    public static SceneEntityVo getSceneEntityByViewName(String viewName) {
        SceneEntityVo sceneEntityVo = null;
        for (SceneEntityVo sceneEntity : sceneEntityList) {
            if (Objects.equals(viewName, sceneEntity.getName())) {
                sceneEntityVo = new SceneEntityVo();
                sceneEntityVo.setName(sceneEntity.getName());
                sceneEntityVo.setLabel(sceneEntity.getLabel());
                sceneEntityVo.setIsMultiple(sceneEntity.getIsMultiple());
                sceneEntityVo.setModuleId(sceneEntity.getModuleId());
                sceneEntityVo.setDescription(sceneEntity.getDescription());
            }
        }
        return sceneEntityVo;
    }
    public static List<String> getFieldNameListByViewName(String viewName) {
        List<String> fieldNameList = new ArrayList<>();
        List<JSONObject> list = fieldMap.get(viewName);
        if (CollectionUtils.isNotEmpty(list)) {
            for (JSONObject jsonObj : list) {
                fieldNameList.add(jsonObj.getString("column"));
            }
        }
        return fieldNameList;
    }

    public static List<String> getFieldNameListByViewNameAndPropertyList(String viewName, List<String> propertyList) {
        List<String> fieldNameList = new ArrayList<>();
        List<JSONObject> list = fieldMap.get(viewName);
        if (CollectionUtils.isNotEmpty(list)) {
            for (String property : propertyList) {
                List<String> tempList = new ArrayList<>();
                if (Objects.equals(property, "allIp")) {
                    tempList.add("allIpId");
                    tempList.add("allIpIp");
                    tempList.add("allIpLabel");
                } else if (Objects.equals(property, "bgList")) {
                    tempList.add("bgId");
                    tempList.add("bgName");
                } else if (Objects.equals(property, "ownerList")) {
                    tempList.add("userId");
                    tempList.add("userUuid");
                    tempList.add("userName");
                } else {
                    tempList.add(property);
                }
                for (JSONObject jsonObj : list) {
                    if (tempList.contains(jsonObj.getString("property"))) {
                        fieldNameList.add(jsonObj.getString("column"));
                    }
                }
            }
        }
        return fieldNameList;
    }

    public static List<ValueTextVo> getFieldListByViewName(String viewName) {
        List<ValueTextVo> fieldList = new ArrayList<>();
        List<JSONObject> list = fieldMap.get(viewName);
        if (CollectionUtils.isNotEmpty(list)) {
            for (JSONObject jsonObj : list) {
                fieldList.add(new ValueTextVo(jsonObj.getString("column"), jsonObj.getString("label")));
            }
        }
        return new ArrayList<>(fieldList);
    }
}
