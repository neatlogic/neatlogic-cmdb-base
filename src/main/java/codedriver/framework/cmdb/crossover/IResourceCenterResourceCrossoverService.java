/*
 * Copyright (c)  2021 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import codedriver.framework.cmdb.dto.resourcecenter.ResourceVo;
import codedriver.framework.crossover.ICrossoverService;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface IResourceCenterResourceCrossoverService extends ICrossoverService {
    ResourceSearchVo assembleResourceSearchVo(JSONObject jsonObj);

    /**
     * 补充资产的账号信息和标签信息
     * @param idList
     * @param resourceVoList
     */
    void getResourceAccountAndTag(List<Long> idList, List<ResourceVo> resourceVoList);
}

