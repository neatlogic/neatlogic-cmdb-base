/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.AccountVo;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceVo;
import codedriver.framework.cmdb.dto.tag.TagVo;
import codedriver.framework.crossover.ICrossoverService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Map;

public interface IResourceCenterResourceCrossoverService extends ICrossoverService {
    ResourceSearchVo assembleResourceSearchVo(JSONObject jsonObj);

    /**
     * 查询所有后代模型的id列表
     * @param idList
     * @return
     */
    List<Long> getDownwardCiIdListByCiIdList(List<Long> idList);

    /**
     * 获取资产的账号信息
     *
     * @param idList
     */
    Map<Long, List<AccountVo>> getResourceAccountByResourceIdList(List<Long> idList);

    /**
     * 获取资产的标签信息
     *
     * @param idList 资产id列表
     * @return 标签列表
     */
    Map<Long, List<TagVo>> getResourceTagByResourceIdList(List<Long> idList);

    /**
     * 补充资产的账号信息
     *
     * @param idList         资产id列表
     * @param resourceVoList 资产列表
     */
    void addResourceAccount(List<Long> idList, List<ResourceVo> resourceVoList);

    /**
     * 补充资产的标签信息
     *
     * @param idList         资产id列表
     * @param resourceVoList 资产列表
     */
    void addResourceTag(List<Long> idList, List<ResourceVo> resourceVoList);

    /**
     * 获取对应模块的应用清单列表
     * 其中清单列表有 系统 存储设备 网络设备 应用实例 应用实例集群 DB实例 DB实例集群 访问入口
     *
     * @param searchVo resourceSearchVo
     * @return tableList
     */
    JSONArray getAppModuleResourceList(ResourceSearchVo searchVo);


    /**
     * 获取模块列表
     *
     * @param searchVo resourceSearchVo
     * @return 资产列表
     */
    List<ResourceVo> getAppModuleList(ResourceSearchVo searchVo);

}

