/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dao.ognl;

import codedriver.framework.cmdb.dto.ci.RelVo;
import codedriver.framework.cmdb.dto.cientity.RelCiEntityFilterVo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 用于判断rel是否存在relCiEntityFilterList中，如果存在才进行join，提升查询配置项SQL性能
 */
public class IsRelExistsInCiEntityFilter {
    public static boolean isExists(RelVo relVo, List<RelCiEntityFilterVo> relCiEntityFilterList) {
        if (relVo != null && CollectionUtils.isNotEmpty(relCiEntityFilterList)) {
            return relCiEntityFilterList.stream().anyMatch(d -> d.getRelId().equals(relVo.getId()) && d.getDirection().equals(relVo.getDirection()));
        }
        return false;
    }
}
