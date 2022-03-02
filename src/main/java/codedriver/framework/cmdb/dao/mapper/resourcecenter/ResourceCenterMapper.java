/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dao.mapper.resourcecenter;

import codedriver.framework.cmdb.dto.resourcecenter.*;
import codedriver.framework.cmdb.dto.tag.TagVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author linbq
 * @since 2021/5/27 16:34
 **/
public interface ResourceCenterMapper {

    int getResourceCount(ResourceSearchVo searchVo);

    List<Long> getResourceIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    int getIpObjectResourceCountByAppModuleIdAndTypeIdAndEnvId(ResourceSearchVo searchVo);

    List<Long> getIpObjectResourceIdListByAppModuleIdAndTypeIdAndEnvId(ResourceSearchVo searchVo);

    int getOsResourceCount(ResourceSearchVo searchVo);

    List<Long> getOsResourceIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getOsResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

//    int getStorageResourceCount(ResourceSearchVo searchVo);
//
//    List<Long> getStorageResourceIdList(ResourceSearchVo searchVo);
//
//    List<ResourceVo> getStorageResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);
//
//    int getNetDevResourceCount(ResourceSearchVo searchVo);
//
//    List<Long> getNetDevResourceIdList(ResourceSearchVo searchVo);
//
//    List<ResourceVo> getNetDevResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

//    int getAppInstanceResourceCount(ResourceSearchVo searchVo);
//
//    List<Long> getAppInstanceResourceIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getAppInstanceResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

//    int getDbInstanceResourceCount(ResourceSearchVo searchVo);
//
//    List<Long> getDbInstanceResourceIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getDbInstanceResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

//    int getAppInstanceClusterResourceCount(ResourceSearchVo searchVo);
//
//    List<Long> getAppInstanceClusterResourceIdList(ResourceSearchVo searchVo);
//
//    List<ResourceVo> getAppInstanceClusterResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);
//
//    int getDbInstanceClusterResourceCount(ResourceSearchVo searchVo);
//
//    List<Long> getDbInstanceClusterResourceIdList(ResourceSearchVo searchVo);
//
//    List<ResourceVo> getDbInstanceClusterResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);
//
//    int getAccessEndPointResourceCount(ResourceSearchVo searchVo);
//
//    List<Long> getAccessEndPointResourceIdList(ResourceSearchVo searchVo);
//
//    List<ResourceVo> getAccessEndPointResourceListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    Long getResourceIdByIpAndPortAndName(ResourceSearchVo searchVo);

    Long getResourceIdByIpAndPortAndNameWithFilter(ResourceSearchVo searchVo);

    ResourceVo getResourceIpPortById(@Param("id") Long id, @Param("schemaName") String schemaName);

    List<ResourceVo> getResourceByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    ResourceVo getResourceById(@Param("id") Long id, @Param("schemaName") String schemaName);

    List<ResourceVo> getResourceFromSoftwareServiceByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    int checkResourceIsExists(@Param("id") Long id, @Param("schemaName") String schemaName);

    List<Long> checkResourceIdListIsExists(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    List<TagVo> getTagListByResourceId(Long resourceId);

    int getAccountCount(AccountVo searchVo);

    AccountVo getAccountById(Long id);

    List<AccountVo> getAccountListByIdList(List<Long> accountIdList);

    int checkAccountNameIsRepeats(AccountVo vo);

    int checkAccountHasBeenResourceReferredById(Long id);

    int searchAccountCount(AccountVo searchVo);

    List<AccountVo> searchAccount(AccountVo searchVo);

    List<AccountVo> getAccountListForSelect(AccountVo searchVo);

    int getTagCount(TagVo searchVo);

    List<TagVo> getTagListForSelect(TagVo searchVo);

    List<String> getTagNameListForSelect(TagVo searchVo);

    List<TagVo> searchTag(TagVo vo);

    int searchTagCount(TagVo vo);

    int checkTagNameIsRepeats(TagVo vo);

    int checkTagIsExistsById(Long id);

    TagVo getTagById(Long id);

    int checkTagHasBeenReferredById(Long id);

    List<Long> getAccountIdListByAccountAndProtocol(@Param("account") String account, @Param("protocol") String protocol);

    List<Long> getNoCorrespondingAccountResourceIdListByTagListAndAccountIdAndProtocol(@Param("tagList") List<Long> tagList, @Param("account") String account, @Param("protocol") String protocol);

    List<ResourceVo> getNoCorrespondingResourceListByAccountIdAndProtocol(ResourceSearchVo searchVo);

    Long checkResourceIsExistsCorrespondingAccountByResourceIdAndAccountIdAndProtocol(@Param("resourceId") Long resourceId, @Param("account") String account, @Param("protocol") String protocol);

    List<Long> getAppSystemIdList(ResourceSearchVo searchVo);

    List<Long> getAppModuleIdList(ResourceSearchVo searchVo);

    List<Long> getAppModuleIdListByAppSystemIdList(ResourceSearchVo searchVo);

    List<ResourceVo> getAppModuleListByIdList(@Param("idList") List<Long> idList, @Param("schemaName") String schemaName);

    int checkAppModuleIsExists(@Param("id") Long id, @Param("schemaName") String schemaName);

    Set<Long> getIpObjectResourceTypeIdListByAppModuleIdAndEnvId(ResourceSearchVo searchVo);

    Set<Long> getOsResourceTypeIdListByAppModuleIdAndEnvId(ResourceSearchVo searchVo);

    Set<Long> getNetWorkDeviceResourceTypeIdListByAppModuleIdAndEnvId(ResourceSearchVo searchVo);

    List<Long> getResourceIdListByProtocolIdList(ResourceSearchVo searchVo);

    List<Long> getResourceIdListByTagIdList(ResourceSearchVo searchVo);

    List<Long> checkAccountIdListIsExists(List<Long> idList);

    List<TagVo> getTagListByTagNameList(List<String> tagNameList);

    List<TagVo> getTagListByIdList(List<Long> idList);

    List<Long> checkTagIdExistsByTagIdList(List<Long> tagIdList);

    List<ResourceAccountVo> getResourceAccountListByResourceIdList(List<Long> resourceIdList);

    List<ResourceAccountVo> getResourceAccountListByAccountId(Long accountId);

    List<ResourceTagVo> getResourceTagListByResourceIdList(List<Long> resourceIdList);

    List<ResourceVo> getResourceListByResourceVoList(@Param("resourceList") List<ResourceVo> resourceList, @Param("schemaName") String schemaName);

    List<AccountVo> getResourceAccountListByResourceIdAndProtocolAndAccount(@Param("resourceIdList") List<Long> resourceIdList, @Param("protocolId") Long protocolId, @Param("userName") String userName);

    AccountVo getResourceAccountByResourceIdAndAccountId(@Param("resourceId") Long resourceId, @Param("accountId") Long accountId);

    AccountVo getResourceAccountByIpAndAccountId(@Param("host")String host, @Param("accountId")Long accountId);

    AccountVo getResourceAccountByIpAndPort(@Param("host")String host,@Param("port") Integer port);

    AccountVo getAccountByTagentIpAndPort(@Param("ip")String ip,@Param("port") Integer port);

    List<AccountVo> getAccountListByIpList(@Param("ipList") List<String> ipList);

    List<AccountVo> getResourceAccountListByResourceId(Long resourceId);

    List<AccountProtocolVo> searchAccountProtocolListByProtocolName(AccountProtocolVo searchVo);

    List<ResourceScriptVo> getResourceScriptListByResourceIdList(@Param("resourceIdList") List<Long> resourceIdList);

    ResourceScriptVo getResourceScriptByResourceId(Long resourceId);

    int checkAccountProtocolIsRepeats(AccountProtocolVo searchVo);

    List<AccountTagVo> getAccountTagListByAccountIdList(List<Long> AccountIdList);

    int checkAccountIsExists(Long accountId);

    int checkAccountProtocolHasBeenReferredByProtocolId(Long id);

    int checkAccountProtocolIsExistsById(Long id);

    AccountProtocolVo getAccountProtocolVoByProtocolId(Long protocolId);

    List<AccountProtocolVo> getAccountProtocolListByIdList(List<Long> idList);

    List<TagVo> searchTagListByIdList(List<Long> tagIdList);

    List<TagVo> getTagListByAccountId(Long id);

    List<AccountComponentVo> searchAccountComponent(@Param("accountComponentVo") AccountComponentVo accountComponentVo, @Param("schemaName") String schemaName);

    Integer searchAccountComponentCount(@Param("accountComponentVo") AccountComponentVo accountComponentVo, @Param("schemaName") String schemaName);

    AccountProtocolVo getAccountProtocolVoByProtocolName(String name);

    AccountVo getAccountByName(String name);

    List<AccountIpVo> getAccountIp(AccountIpVo ipVo);

    int updateAccount(AccountVo vo);

    int updateTag(TagVo vo);

    int updateAccountProtocol(AccountProtocolVo searchVo);

    void insertAccount(AccountVo vo);

    int insertTag(TagVo vo);

    int insertIgnoreResourceAccount(List<ResourceAccountVo> resourceAccountVoList);

    int insertIgnoreResourceTag(List<ResourceTagVo> resourceTagVoList);

    int insertIgnoreAccountTag(List<AccountTagVo> accountTagVoList);

    int insertAccountProtocol(AccountProtocolVo searchVo);

    int insertAccountIp(AccountIpVo ipVo);

    int insertResourceScript(@Param("resourceId") Long resourceId, @Param("scriptId") Long scriptId, @Param("config") String config);

    int deleteAccountIpByAccountId(Long value);

    int deleteTagById(Long id);

    int deleteAccountById(Long id);

    int deleteResourceAccountByResourceId(Long resourceId);

    int deleteResourceAccountByResourceIdListAndAccountIdList(@Param("resourceIdList") List<Long> resourceIdList, @Param("accountIdList") List<Long> accountIdList);

    int deleteResourceTagByResourceId(Long resourceId);

    int deleteResourceTagByResourceIdAndTagIdList(@Param("resourceIdList") List<Long> resourceIdList, @Param("tagIdList") List<Long> tagIdList);

    int deleteAccountTagByAccountId(Long accountId);

    int deleteResourceAccountProtocolById(Long id);

    int deleteResourceAccountByAccountId(Long accountId);

    int deleteAccountIpByIpList(@Param("ipList") List<String> resourceIpList);

    int deleteResourceScriptByResourceId(Long resourceId);
}
