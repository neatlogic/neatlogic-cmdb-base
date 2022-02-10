/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dao.ognl;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.cmdb.dto.cientity.AttrFilterVo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 用于判断attr是否存在attrFilterList中，如果存在才进行join，提升查询配置项SQL性能
 */
public class IsAttrExistsInFilter {
    public static boolean isExists(AttrVo attrVo, List<AttrFilterVo> attrFilterList) {
        if (attrVo != null && CollectionUtils.isNotEmpty(attrFilterList)) {
            return attrFilterList.stream().anyMatch(d -> d != null && d.getAttrId().equals(attrVo.getId()));
        }
        return false;
    }
}
