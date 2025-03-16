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
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.common.dto.ValueTextVo;

import java.util.List;

public interface IResourceCenterDataSource {

    /**
     * 优先级，默认是最高优先级，该接口默认实现类会把该字段设置为最低优先级，客户模块如果实现该接口，则以客户模块的实现类逻辑
     * @return
     */
    default Ordered getOrdered() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    JSONArray getAppResourceList(Long appSystemId, Long appModuleId, Long envId, List<Long> resourceTypeIdList, String viewName, Integer currentPage, Integer pageSize);

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

    List<ResourceVo> getStateListForSelect(BasePageVo searchVo);

    List<ResourceVo> getVendorListForSelect(BasePageVo searchVo);
}
