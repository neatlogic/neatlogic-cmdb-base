/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceVo;
import codedriver.framework.cmdb.dto.resourcecenter.entity.ModuleVo;
import codedriver.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IResourceCrossoverMapper extends ICrossoverService {

    int getResourceCount(ResourceSearchVo searchVo);

    List<Long> getResourceIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    List<ResourceVo> getAppInstanceResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    List<ResourceVo> getAppInstanceResourceListByIdListSimple(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    List<ResourceVo> getResourceByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    ResourceVo getResourceById(@Param("id") Long id, @Param("schemaName") String schemaName);

    List<ResourceVo> getResourceFromSoftwareServiceByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    int checkResourceIsExists(@Param("id") Long id, @Param("schemaName") String schemaName);

    List<Long> getHasModuleAppSystemIdListByAppSystemIdList(@Param("appSystemIdList") List<Long> appSystemIdList);

    List<Long> getHasEnvAppSystemIdListByAppSystemIdList(@Param("appSystemIdList") List<Long> appSystemIdList);

    List<Long> getAppSystemModuleIdListByAppSystemId(@Param("appSystemId") Long appSystemId);

    List<ModuleVo> getAppModuleListByAppSystemIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getAppModuleListByIdListSimple(@Param("idList") List<Long> idList);

    List<ResourceVo> getResourceListByResourceVoList(@Param("resourceList") List<ResourceVo> resourceList, @Param("schemaName") String schemaName);

    List<Long> getResourceIdListByAppSystemIdAndModuleIdAndEnvId(@Param("resourceVo") ResourceVo resourceVo, @Param("schemaName") String schemaName);

    List<Long> getAppInstanceResourceIdListByAppSystemIdAndModuleIdAndEnvId(@Param("resourceVo") ResourceVo resourceVo, @Param("schemaName") String schemaName);

    /**
     * 根据类型和IP列表查询资源
     *
     * @param schemaName
     * @param typeIdList
     * @param ipList
     * @return
     */
    List<ResourceVo> getResourceListByTypeIdListAndIpList(@Param("schemaName") String schemaName, @Param("typeIdList") List<Long> typeIdList, @Param("ipList") List<String> ipList);

    ResourceVo getAppSystemById(@Param("id") Long id, @Param("schemaName") String schemaName);

    ResourceVo getAppModuleById(@Param("id") Long id, @Param("schemaName") String schemaName);

    ResourceVo getAppEnvById(@Param("id") Long id, @Param("schemaName") String schemaName);
}
