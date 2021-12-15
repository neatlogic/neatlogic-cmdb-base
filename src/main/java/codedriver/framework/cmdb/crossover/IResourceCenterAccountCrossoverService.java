/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.AccountProtocolVo;
import codedriver.framework.cmdb.dto.resourcecenter.AccountVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;
import java.util.Optional;

/**
 * @author lvzk
 * @since 2021/11/8 15:09
 **/
public interface IResourceCenterAccountCrossoverService extends ICrossoverService {
    /**
     * 根据账号id刷新账号ip
     *
     * @param accountId 账号id
     */
    void refreshAccountIpByAccountId(Long accountId);

    /**
     * 根据资产id刷新账号ip
     *
     * @param resourceIdList 资产id
     */
    void refreshAccountIpByResourceIdList(List<Long> resourceIdList);

    /**
     * 按以下规则顺序匹配account
     * 1、通过 ”资产id+协议id+用户“ 匹配
     * 2、通过 ”组合工具配置的执行节点的ip+协议id“ 匹配 账号表
     * 3、通过 ”组合工具配置的执行节点的ip+端口“ 匹配 账号表
     *
     * @param accountVoList
     * @param allAccountVoList
     * @param protocolVoList
     * @param resourceId
     * @param protocolId
     * @param ip
     * @param port
     * @return
     */
    Optional<AccountVo> filterAccountByRules(List<AccountVo> accountVoList, List<AccountVo> allAccountVoList, List<AccountProtocolVo> protocolVoList, Long resourceId, Long protocolId, String ip, Integer port);

    /**
     * 删除账号
     *
     * @param accountId 账号id
     */
    void deleteAccount(Long accountId, boolean isTagent);
}
