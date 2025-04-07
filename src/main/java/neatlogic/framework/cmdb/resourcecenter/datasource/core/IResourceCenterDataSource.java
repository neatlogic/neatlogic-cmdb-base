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

    List<ResourceVo> getResourceList(ResourceSearchVo searchVo);

    List<ResourceTypeVo> getResourceTypeTree(String keyword);

    List<ResourceTypeVo> getResourceTypeListTree(String keyword);

    JSONArray getTheadList(List<String> fieldNameList);

    List<ValueTextVo> getAssertAllTheadList();

    List<ValueTextVo> getAppAssertAllTheadList();

    List<AppSystemVo> getAppSystemListForTree(BasePageVo searchVo);

    List<ResourceVo> getAppSystemListForSelect(BasePageVo searchVo);

    List<AppModuleVo> getAppModuleListForTree(Long appSystemId);

    List<ResourceVo> getAppModuleList(ResourceSearchVo searchVo);

    List<ResourceVo> getAppEnvListForSelect(BasePageVo searchVo);

    List<AppEnvVo> getAppEnvListByAppSystemId(Long appSystemId);

    List<ResourceVo> getStateListForSelect(BasePageVo searchVo);

    List<ResourceVo> getVendorListForSelect(BasePageVo searchVo);

    Map<String, List<Long>> getAppResourceTypeIdListByAppSystemId(Long appSystemId);

    Map<String, List<Long>> getAppResourceTypeIdListByAppSystemIdAndAppModuleIdAndEnvId(Long appSystemId, Long appModuleId, Long envId);

    Map<String, List<Long>> getAppResourceTypeIdListByAppSystemIdAndAppModuleIdAndEnvIdAndInspectStatusList(Long appSystemId, Long appModuleId, Long envId, List<String> inspectStatusList);

    List<Long> getAppSystemIdListById(Long id);

    List<ResourceEntityVo> getAppViewList();
}
