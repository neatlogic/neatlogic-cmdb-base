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

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.cmdb.dto.resourcecenter.*;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityVo;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.common.dto.ValueTextVo;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;

public interface IResourceCenterDataSource {

    /**
     * 优先级，默认是最高优先级，该接口默认实现类会把该字段设置为最低优先级，客户模块如果实现该接口，则以客户模块的实现类逻辑
     * @return
     */
    default Ordered getOrdered() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    JSONArray getAppResourceList(@Nullable Long appSystemId, @Nullable Long appModuleId, @Nullable Long envId, @Nullable List<String> inspectStatusList, @Nullable String viewName, @Nullable Integer currentPage, @Nullable Integer pageSize);

    List<ResourceVo> getAppResourceList(ResourceSearchVo searchVo, boolean needPage);

    List<Long> getAppResourceIdList(ResourceSearchVo searchVo, boolean needPage);

    JSONArray getTbodyList(List<String> fieldList, List<ResourceVo> resourceList, ResourceEntityVo resourceEntityVo);

    List<ResourceVo> getResourceList(ResourceSearchVo searchVo, List<String> theadFieldNameList);

    List<ResourceTypeVo> getResourceTypeTree(String keyword);

    List<ResourceTypeVo> getResourceTypeListTree(String keyword);

    JSONArray getTheadList(List<String> fieldNameList);

    List<ValueTextVo> getAssertAllTheadList();

    List<ValueTextVo> getAppAssertAllTheadList();

    List<AppSystemVo> getAppSystemListForTree(BasePageVo searchVo);

    List<ResourceVo> getAppSystemListForSelect(BasePageVo searchVo);

    /**
     * 按模块过滤应用树列表，默认兼容旧逻辑。
     *
     * @param searchVo 查询条件
     * @param moduleName 模块名
     * @return 应用树列表
     */
    default List<AppSystemVo> getAppSystemListForTree(BasePageVo searchVo, String moduleName) {
        return getAppSystemListForTree(searchVo);
    }

    /**
     * 按模块过滤应用下拉列表，默认兼容旧逻辑。
     *
     * @param searchVo 查询条件
     * @param moduleName 模块名
     * @return 应用下拉列表
     */
    default List<ResourceVo> getAppSystemListForSelect(BasePageVo searchVo, String moduleName) {
        return getAppSystemListForSelect(searchVo);
    }

    List<AppModuleVo> getAppModuleListForTree(Long appSystemId);

    List<ResourceVo> getAppModuleList(ResourceSearchVo searchVo);

    List<ResourceVo> getAppEnvListForSelect(BasePageVo searchVo, boolean needPage);

    List<AppEnvVo> getAppEnvListByAppSystemIdAndAppModuleIdAndInspectStatusList(Long appSystemId, Long appModuleId, List<String> inspectStatusList);

    List<ResourceVo> getStateListForSelect(BasePageVo searchVo);

    List<ResourceVo> getVendorListForSelect(BasePageVo searchVo);

    Map<String, List<Long>> getAppResourceTypeIdListByAppSystemId(Long appSystemId);

    Map<String, List<Long>> getAppResourceTypeIdListByAppSystemIdAndAppModuleIdAndEnvId(Long appSystemId, Long appModuleId, Long envId);

    Map<String, List<Long>> getAppResourceTypeIdListByAppSystemIdAndAppModuleIdAndEnvIdAndInspectStatusList(Long appSystemId, Long appModuleId, Long envId, List<String> inspectStatusList);

    List<Long> getAppSystemIdListById(Long id);

    List<ResourceEntityVo> getAppViewList();

    Map<String, List<String>> getApplicationListDisplayViewName2FieldListMap();
}
