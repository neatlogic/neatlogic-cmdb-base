/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dao.ognl;

import codedriver.framework.cmdb.dto.ci.RelVo;
import codedriver.framework.cmdb.dto.cientity.RelFilterVo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 用于判断rel是否存在relFilterList中，如果存在才进行join，提升查询配置项SQL性能
 */
public class IsRelExistsInFilter {
    public static boolean isExists(RelVo relVo, List<RelFilterVo> relFilterList) {
        if (relVo != null && CollectionUtils.isNotEmpty(relFilterList)) {
            return relFilterList.stream().anyMatch(d -> d != null && d.getRelId().equals(relVo.getId()) && d.getDirection().equals(relVo.getDirection()));
        }
        return false;
    }
}
