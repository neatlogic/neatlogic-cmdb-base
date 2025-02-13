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

package neatlogic.framework.cmdb.resourcecenter.sceneview.core;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.cmdb.dto.resourcecenter.config.SceneEntityVo;
import neatlogic.framework.common.RootComponent;
import neatlogic.framework.common.dto.ValueTextVo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

@RootComponent
public class SceneViewDefinitionFactory extends ModuleInitializedListenerBase {

    private static final Map<String, ISceneViewDefinition> componentMap = new HashMap<>();
    /**
     * 视图信息列表
     */
    private static final List<SceneEntityVo> sceneEntityList = new ArrayList<>();
    /**
     * 视图名称列表
     */
    private static final List<String> viewNameList = new ArrayList<>();

    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, ISceneViewDefinition> myMap = context.getBeansOfType(ISceneViewDefinition.class);
        for (Map.Entry<String, ISceneViewDefinition> entry : myMap.entrySet()) {
            ISceneViewDefinition sceneView = entry.getValue();
            ISceneViewDefinition other = componentMap.get(sceneView.getName());
            if (other != null) {
                if (other.getOrdered().getValue() < sceneView.getOrdered().getValue()) {
                    componentMap.remove(other.getName());
                    componentMap.put(sceneView.getName(), sceneView);
                }
            } else {
                componentMap.put(sceneView.getName(), sceneView);
            }
        }
    }

    @Override
    protected void myInit() {

    }

    public static List<SceneEntityVo> getSceneEntityList() {
        if (CollectionUtils.isEmpty(sceneEntityList)) {
            for (Map.Entry<String, ISceneViewDefinition> entry : componentMap.entrySet()) {
                ISceneViewDefinition sceneView = entry.getValue();
                if (sceneView.isEnable()) {
                    SceneEntityVo sceneEntityVo = new SceneEntityVo();
                    sceneEntityVo.setName(sceneView.getName());
                    sceneEntityVo.setLabel(sceneView.getLabel());
                    sceneEntityVo.setDescription(String.join("；", sceneView.getFunctionPathList()));
                    sceneEntityList.add(sceneEntityVo);
                }
            }
            List<String> viewNameList = getViewNameList();
            sceneEntityList.sort(Comparator.comparingInt(e -> viewNameList.indexOf(e.getName())));
        }
        return sceneEntityList;
    }

    public static SceneEntityVo getSceneEntityByViewName(String viewName) {
        SceneEntityVo sceneEntityVo = null;
        for (SceneEntityVo sceneEntity : sceneEntityList) {
            if (Objects.equals(viewName, sceneEntity.getName())) {
                sceneEntityVo = new SceneEntityVo();
                sceneEntityVo.setName(sceneEntity.getName());
                sceneEntityVo.setLabel(sceneEntity.getLabel());
                sceneEntityVo.setDescription(sceneEntity.getDescription());
            }
        }
        return sceneEntityVo;
    }
    public static List<String> getFieldNameListByViewName(String viewName) {
        List<String> fieldNameList = new ArrayList<>();
        ISceneViewDefinition sceneView = componentMap.get(viewName);
        if (sceneView != null && sceneView.isEnable()) {
            List<SceneViewFieldVo> fieldList = sceneView.getFieldList();
            if (CollectionUtils.isNotEmpty(fieldList)) {
                for (SceneViewFieldVo sceneViewFieldVo : fieldList) {
                    fieldNameList.add(sceneViewFieldVo.getName());
                }
            }
        }
        return fieldNameList;
    }

    public static List<ValueTextVo> getFieldListByViewName(String viewName) {
        List<ValueTextVo> resultList = new ArrayList<>();
        ISceneViewDefinition sceneView = componentMap.get(viewName);
        if (sceneView != null && sceneView.isEnable()) {
            List<SceneViewFieldVo> fieldList = sceneView.getFieldList();
            if (CollectionUtils.isNotEmpty(fieldList)) {
                for (SceneViewFieldVo sceneViewFieldVo : fieldList) {
                    resultList.add(new ValueTextVo(sceneViewFieldVo.getName(), sceneViewFieldVo.getLabel()));
                }
            }
        }
        return resultList;
    }

    public static List<String> getViewNameList() {
        if (CollectionUtils.isEmpty(viewNameList)) {
            List<String> nameList = new ArrayList<>();
            for (Map.Entry<String, ISceneViewDefinition> entry : componentMap.entrySet()) {
                ISceneViewDefinition sceneView = entry.getValue();
                if (sceneView.isEnable()) {
                    nameList.add(sceneView.getName());
                }
            }
            String[] viewNameArray = new String[nameList.size()];
            nameList.toArray(viewNameArray);
            Arrays.sort(viewNameArray);
            viewNameList.addAll(Arrays.asList(viewNameArray));
        }
        return new ArrayList<>(viewNameList);
    }
}
