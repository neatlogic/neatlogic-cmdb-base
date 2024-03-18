/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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

import neatlogic.framework.cmdb.dto.resourcecenter.AccountIpVo;
import neatlogic.framework.cmdb.dto.resourcecenter.AccountProtocolVo;
import neatlogic.framework.cmdb.dto.resourcecenter.AccountVo;
import neatlogic.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IResourceAccountCrossoverMapper extends ICrossoverService {

    AccountVo getAccountById(Long id);

    AccountVo getPublicAccountByName(String name);

    AccountVo getResourceAccountByIpAndPort(@Param("host") String host, @Param("port") Integer port);

    AccountVo getAccountByTagentIpAndPort(@Param("ip") String ip, @Param("port") Integer port);

    List<AccountVo> getAccountListByIpListAndProtocolId(@Param("ipList") List<String> ipList, @Param("protocolId") Long protocolId);

    AccountVo getAccountByTagentId(Long id);

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
