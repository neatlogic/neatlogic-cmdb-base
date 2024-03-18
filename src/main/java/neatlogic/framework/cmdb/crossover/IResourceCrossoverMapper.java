/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.crossover;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.cmdb.dto.resourcecenter.AppSystemVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceVo;
import neatlogic.framework.cmdb.dto.resourcecenter.entity.AppEnvironmentVo;
import neatlogic.framework.cmdb.dto.resourcecenter.entity.ModuleVo;
import neatlogic.framework.cmdb.dto.resourcecenter.entity.SoftwareServiceOSVo;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface IResourceCrossoverMapper extends ICrossoverService {

    int getResourceCount(ResourceSearchVo searchVo);

    List<Long> getResourceIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getResourceListByIdList(List<Long> idList);

    List<Long> getAppSystemModuleIdListByAppSystemIdAndAppModuleIdListAndEnvId(@Param("appSystemId") Long appSystemId, @Param("envId") Long envId, @Param("appModuleIdList") JSONArray appModuleIdList);

    int getIpObjectResourceCountByAppSystemIdAndAppModuleIdAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    List<Long> getIpObjectResourceIdListByAppSystemIdAndAppModuleIdAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    int getOsResourceCountByAppSystemIdAndAppModuleIdAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    List<Long> getOsResourceIdListByAppSystemIdAndAppModuleIdAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    int getOsResourceCountByAppSystemIdAndAppModuleIdListAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    List<Long> getOsResourceIdListByAppSystemIdAndAppModuleIdListAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    List<ResourceVo> getAppInstanceResourceListByIdList(List<Long> idList);

    List<ResourceVo> getAppInstanceResourceListByIdListAndKeyword(@Param("idList") List<Long> idList, @Param("keyword") String keyword);

    List<ResourceVo> getAppInstanceResourceListByIdListSimple(List<Long> idList);

    Long getResourceIdByIpAndPortAndName(ResourceSearchVo searchVo);

    List<ResourceVo> getResourceByIdList(List<Long> idList);

    List<ResourceVo> getAuthResourceList(ResourceSearchVo searchVo);

    ResourceVo getResourceById(Long id);

    int checkResourceIsExists(Long id);

    List<Long> checkResourceIdListIsExists(List<Long> idList);

    List<Long> getHasModuleAppSystemIdListByAppSystemIdList(@Param("appSystemIdList") List<Long> appSystemIdList);

    List<Long> getHasEnvAppSystemIdListByAppSystemIdList(@Param("appSystemIdList") List<Long> appSystemIdList);

    List<Long> getAppSystemModuleIdListByAppSystemId(Long appSystemId);

    List<Long> getAppSystemModuleIdListByAppSystemIdAndAppModuleIdList(@Param("appSystemId") Long appSystemId, @Param("appModuleIdList") JSONArray appModuleIdList);

    List<ModuleVo> getAppModuleListByAppSystemIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getAppModuleListByIdListSimple(@Param("idList") List<Long> idList, @Param("needOrder") boolean needOrder);

    Set<Long> getIpObjectResourceTypeIdListByAppSystemIdAndEnvId(ResourceSearchVo searchVo);

    Set<Long> getOsResourceTypeIdListByAppSystemIdAndEnvId(ResourceSearchVo searchVo);

    Set<Long> getResourceAppSystemIdListByResourceId(Long id);

    List<ResourceVo> getResourceAppSystemListByResourceIdList(List<Long> id);

    List<ResourceVo> getResourceListByResourceVoList(@Param("resourceList") List<ResourceVo> resourceList,@Param("searchVo") ResourceSearchVo searchVo);

    Long getAppSystemIdByResourceId(Long id);

    Set<Long> getResourceTypeIdListByAppSystemIdAndModuleIdAndEnvIdAndInspectStatusList(ResourceSearchVo searchVo);

    List<Long> getResourceIdListByAppSystemIdAndModuleIdAndEnvId(ResourceVo resourceVo);

    List<Long> getAppInstanceResourceIdListByAppSystemIdAndModuleIdAndEnvId(ResourceVo resourceVo);

    /**
     * 根据类型和IP列表查询资源
     *
     * @param typeIdList
     * @param ipList
     * @return
     */
    List<ResourceVo> getResourceListByTypeIdListAndIpList(@Param("typeIdList") List<Long> typeIdList, @Param("ipList") List<String> ipList);

    ResourceVo getAppSystemById(Long id);

    List<ResourceVo> getAppSystemVoListByIdList(List<Long> idList);

    ResourceVo getAppSystemByName(String name);

    ResourceVo getAppModuleById(Long id);

    ResourceVo getAppModuleByName(String name);

    ResourceVo getAppEnvById(Long id);

    List<ResourceVo> getAppEnvListByIdList(List<Long> idList);

    ResourceVo getAppEnvByName(String name);

    List<AppEnvironmentVo> getAllAppEnv();

    ResourceVo getResourceByIpAndPort(@Param("ip") String ip, @Param("port") Integer port);

    List<AppSystemVo> getAppSystemListByIdList(List<Long> appSystemIdList);

    int getAppSystemCountByKeyword(BasePageVo searchVo);

    List<AppSystemVo> getAppSystemListByKeyword(BasePageVo searchVo);

    List<ResourceVo> searchAppSystemListByIdList(List<Long> idList);

    List<ResourceVo> getOsResourceListenPortListByResourceIdList(List<Long> resourceIdList);

    List<ResourceVo> getSoftwareResourceListenPortListByResourceIdList(List<Long> resourceIdList);

    List<SoftwareServiceOSVo> getOsResourceListByResourceIdList(List<Long> resourceIdList);
}
