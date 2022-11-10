/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.AppSystemVo;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceVo;
import codedriver.framework.cmdb.dto.resourcecenter.entity.AppEnvironmentVo;
import codedriver.framework.cmdb.dto.resourcecenter.entity.ModuleVo;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.crossover.ICrossoverService;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface IResourceCrossoverMapper extends ICrossoverService {

    int getResourceCount(ResourceSearchVo searchVo);

    List<Long> getResourceIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getResourceListByIdList(List<Long> idList);

    int getIpObjectResourceCountByAppSystemIdAndAppModuleIdAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    List<Long> getIpObjectResourceIdListByAppSystemIdAndAppModuleIdAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    int getOsResourceCountByAppSystemIdAndAppModuleIdAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    List<Long> getOsResourceIdListByAppSystemIdAndAppModuleIdAndEnvIdAndTypeId(ResourceSearchVo searchVo);

    List<ResourceVo> getAppInstanceResourceListByIdList(List<Long> idList);

    List<ResourceVo> getAppInstanceResourceListByIdListAndKeyword(@Param("idList") List<Long> idList, @Param("keyword") String keyword);

    List<ResourceVo> getAppInstanceResourceListByIdListSimple(List<Long> idList);

    List<ResourceVo> getResourceByIdList(List<Long> idList);

    ResourceVo getResourceById(Long id);

    int checkResourceIsExists(Long id);

    List<Long> getHasModuleAppSystemIdListByAppSystemIdList(@Param("appSystemIdList") List<Long> appSystemIdList);

    List<Long> getHasEnvAppSystemIdListByAppSystemIdList(@Param("appSystemIdList") List<Long> appSystemIdList);

    List<Long> getAppSystemModuleIdListByAppSystemId(Long appSystemId);

    List<Long> getAppSystemModuleIdListByAppSystemIdAndAppModuleIdList(@Param("appSystemId") Long appSystemId, @Param("appModuleIdList") JSONArray appModuleIdList);

    List<ModuleVo> getAppModuleListByAppSystemIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getAppModuleListByIdListSimple(@Param("idList") List<Long> idList, @Param("needOrder") boolean needOrder);

    Set<Long> getIpObjectResourceTypeIdListByAppSystemIdAndEnvId(ResourceSearchVo searchVo);

    Set<Long> getOsResourceTypeIdListByAppSystemIdAndEnvId(ResourceSearchVo searchVo);

    List<ResourceVo> getResourceListByResourceVoList(@Param("resourceList") List<ResourceVo> resourceList);

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

    ResourceVo getAppSystemByName(String name);

    ResourceVo getAppModuleById(Long id);

    ResourceVo getAppModuleByName(String name);

    ResourceVo getAppEnvById(Long id);

    ResourceVo getAppEnvByName(String name);

    List<AppEnvironmentVo> getAllAppEnv();

    ResourceVo getResourceByIpAndPort(@Param("ip") String ip, @Param("port") Integer port);

    int getAppSystemCountByKeyword(BasePageVo searchVo);

    List<AppSystemVo> getAppSystemListByKeyword(BasePageVo searchVo);
}
