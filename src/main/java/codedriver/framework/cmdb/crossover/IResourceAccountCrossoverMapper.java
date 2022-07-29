/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.AccountIpVo;
import codedriver.framework.cmdb.dto.resourcecenter.AccountProtocolVo;
import codedriver.framework.cmdb.dto.resourcecenter.AccountVo;
import codedriver.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IResourceAccountCrossoverMapper extends ICrossoverService {

    AccountVo getAccountById(Long id);

    AccountVo getResourceAccountByIpAndPort(@Param("host") String host, @Param("port") Integer port);

    AccountVo getAccountByTagentIpAndPort(@Param("ip") String ip, @Param("port") Integer port);

    List<AccountVo> getAccountListByIpList(@Param("ipList") List<String> ipList);

    List<AccountVo> getAllAccountList();

    List<AccountProtocolVo> searchAccountProtocolListByProtocolName(AccountProtocolVo searchVo);

    AccountProtocolVo getAccountProtocolVoByProtocolId(Long protocolId);

    List<AccountVo> getResourceAccountListByResourceIdAndProtocolAndAccount(@Param("resourceIdList") List<Long> resourceIdList, @Param("protocolId") Long protocolId, @Param("userName") String userName);

    AccountProtocolVo getAccountProtocolVoByProtocolName(String name);

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
