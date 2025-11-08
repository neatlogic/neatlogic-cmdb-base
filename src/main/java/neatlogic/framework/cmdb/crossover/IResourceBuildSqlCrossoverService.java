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

package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.resourcecenter.AccountComponentVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceVo;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

public interface IResourceBuildSqlCrossoverService extends ICrossoverService {

    String buildGetResourceIdListSql(ResourceSearchVo searchVo);

    String buildGetResourceCountSql(ResourceSearchVo searchVo);

    String buildGetResourceListSql(List<Long> idList, List<String> selectFieldNameList);

    String buildGetResourceListSql(List<Long> idList);

    String buildGetResourceCountByNameKeywordSql(ResourceSearchVo searchVo);

    String buildGetResourceCountByIpKeywordSql(ResourceSearchVo searchVo);

    String buildGetAuthResourceListSql(ResourceSearchVo searchVo);

    String buildGetResourceListByIpAndPortAndNameWithFilterSql(ResourceSearchVo searchVo);

    String buildGetResourceTypeIdListByAuthSql(ResourceSearchVo searchVo);

    String buildGetResourceIdByIpAndPortAndNameSql(ResourceSearchVo searchVo);

    String buildGetResourceIdListByIpAndPortAndNameSql(ResourceSearchVo searchVo);

    String buildGetResourceListByIpAndPortAndNameSql(ResourceSearchVo searchVo);

    String buildGetResourceByIdListSql(List<Long> idList);

    String buildGetResourceByIdSql(Long id, List<String> selectFieldNameList);

    String buildGetResourceByIdSql(Long id);

    String buildGetResourceIdByResourceIdSql(Long id);

    String buildCheckResourceIdListIsExistsSql(List<Long> idList);

    String buildGetResourceIdListByAppSystemIdAndModuleIdAndEnvIdSql(ResourceVo resourceVo);

    String buildGetResourceListByTypeIdListAndIpListSql(List<Long> typeIdList, List<String> ipList);

    String buildGetResourceByIpAndPortAndNameAndTypeNameSql(String ip, Integer port, String name, String typeName);

    String buildGetResourceByIpAndPortSql(String ip, Integer port);

    String buildSearchAccountComponentSql(AccountComponentVo accountComponentVo);

    String buildSearchAccountComponentCountSql(AccountComponentVo accountComponentVo);

    String buildGetAppEnvListByAppSystemIdAndAppModuleIdSql(Long appSystemId, Long appModuleId);

    String buildGetAppEnvCountMapByAppSystemIdGroupByAppModuleIdSql(Long appSystemId);

    String buildGetResourceCountByDynamicConditionSql(ResourceSearchVo searchVo);

    String buildGetResourceIdListByDynamicConditionSql(ResourceSearchVo searchVo);

    String buildGetAppResourceCountSql(ResourceSearchVo searchVo);

    String buildGetAppResourceIdListSql(ResourceSearchVo searchVo);

    String buildGetAppResourceListByIdListSql(ResourceSearchVo searchVo, List<String> selectFieldNameList);

    String buildGetAppResourceListByIdListSql(ResourceSearchVo searchVo);

    String buildGetAppEnvListByViewNameAndAppSystemIdAndAppModuleIdAndInspectStatusListSql(String viewName, Long appSystemId, Long appModuleId, List<String> inspectStatusList);

    String buildGetAppResourceTypeIdListByViewNameAndAppSystemIdSql(String viewName, Long appSystemId, Long appModuleId, Long envId, List<String> inspectStatusList);

    String buildGetAppSystemIdListByIdSql(String viewName, Long id);

    String buildSearchVendorCountSql(BasePageVo searchVo);

    String buildSearchVendorIdListSql(BasePageVo searchVo);

    String buildSearchVendorListByIdListSql(List<Long> idList);

    String buildSearchStateCountSql(BasePageVo searchVo);

    String buildSearchStateIdListSql(BasePageVo searchVo);

    String buildSearchStateListByIdListSql(List<Long> idList);
    // InspectMapper
    String buildGetInspectResourceListByIdListSql(List<Long> idList, List<String> selectFieldNameList);

    String buildGetInspectResourceListByIdListSql(List<Long> idList);

    String buildGetInspectResourceCountSql(ResourceSearchVo searchVo);

    String buildGetInspectResourceCountByIpKeywordSql(ResourceSearchVo searchVo);

    String buildGetInspectResourceCountByNameKeywordSql(ResourceSearchVo searchVo);

    String buildGetInspectResourceIdListSql(ResourceSearchVo searchVo);

    String buildGetInspectAutoexecJobNodeResourceCountSql(ResourceSearchVo searchVo, Long jobId);

    String buildGetInspectAutoexecJobNodeResourceCountByIpKeywordSql(ResourceSearchVo searchVo, Long jobId);

    String buildGetInspectAutoexecJobNodeResourceCountByNameKeywordSql(ResourceSearchVo searchVo, Long jobId);

    String buildGetInspectAutoexecJobNodeResourceIdListSql(ResourceSearchVo searchVo, Long jobId);

    String buildGetInspectResourceListByIdListAndJobIdSql(List<Long> IdList, Long jobId);

    String buildGetInspectResourceListByIdListAndJobIdSql(List<Long> IdList, Long jobId, List<String> selectFieldNameList);

    // InspectConfigFileMapper
    String buildGetInspectConfigFileResourceIdListSql(ResourceSearchVo searchVo);

    String buildGetInspectConfigFilePathCountSql(ResourceSearchVo searchVo);

    String buildGetInspectConfigFilePathIdListSql(ResourceSearchVo searchVo);

    String buildGetInspectConfigFilePathListSql(List<Long> idList);

    String buildGetInspectConfigFilePathListByJobIdSql(Long jobId);
}
