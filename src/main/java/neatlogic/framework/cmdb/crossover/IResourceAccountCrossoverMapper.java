/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.resourcecenter.AccountIpVo;
import neatlogic.framework.cmdb.dto.resourcecenter.AccountProtocolVo;
import neatlogic.framework.cmdb.dto.resourcecenter.AccountVo;
import neatlogic.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IResourceAccountCrossoverMapper extends ICrossoverService {

    AccountVo getAccountById(Long id);

    AccountVo getResourceAccountByIpAndPort(@Param("host") String host, @Param("port") Integer port);

    AccountVo getAccountByTagentIpAndPort(@Param("ip") String ip, @Param("port") Integer port);

    List<AccountVo> getAccountListByIpListAndProtocolId(@Param("ipList") List<String> ipList, @Param("protocolId") Long protocolId);

    AccountVo getAccountIdByTagentId(Long id);

    List<AccountVo> getAccountListByIpList(@Param("ipList") List<String> ipList);

    List<AccountVo> getAllAccountList();

    List<AccountVo> getAccountListByIpAndProtocolNameAndAccountAndProtocolPort(@Param("ip") String ip, @Param("protocolName") String protocolName, @Param("account") String account, @Param("protocolPort") Integer protocolPort);

    List<AccountVo> getAccountListByProtocolNameAndAccountAndProtocolPort(@Param("protocolName") String protocolName, @Param("account") String account, @Param("protocolPort") Integer protocolPort);

    List<AccountProtocolVo> searchAccountProtocolListByProtocolName(AccountProtocolVo searchVo);

    List<AccountProtocolVo> getAllAccountProtocolList();

    AccountProtocolVo getAccountProtocolVoByProtocolId(Long protocolId);

    List<AccountVo> getDefaultAccountListByProtocolIdListAndAccount(@Param("list") List<Long> protocolIdList, @Param("account") String account);

    List<AccountVo> getResourceAccountListByResourceIdAndProtocolAndAccount(@Param("resourceIdList") List<Long> resourceIdList, @Param("protocolId") Long protocolId, @Param("userName") String userName);

    AccountProtocolVo getAccountProtocolVoByProtocolName(String name);

    AccountProtocolVo getAccountProtocolVoByNameAndPort(@Param("name") String name, @Param("port") Integer port);

    List<String> getAccountIpByIpListAndPort(@Param("ipList") List<String> ipList, @Param("port") Integer port);

    int updateAccount(AccountVo vo);

    int updateAccountPasswordById(@Param("id") Long id, @Param("password") String password);

    void insertAccount(AccountVo vo);

    int insertAccountProtocol(AccountProtocolVo searchVo);

    int insertAccountIp(AccountIpVo ipVo);

    int deleteAccountIpByAccountId(Long value);

    int deleteAccountById(Long id);

    int deleteAccountTagByAccountId(Long accountId);

    int deleteResourceAccountByAccountId(Long accountId);

}
