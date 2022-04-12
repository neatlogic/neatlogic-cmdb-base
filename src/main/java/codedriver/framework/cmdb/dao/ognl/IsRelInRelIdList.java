/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dao.ognl;

import codedriver.framework.cmdb.dto.ci.RelVo;

import java.util.List;

/**
 * 用于判断rel是否存在relIdList中，如果存在才显示，提升查询配置项SQL性能
 */
public class IsRelInRelIdList {
    public static boolean isExists(RelVo relVo, List<Long> relIdList) {
        if (relVo != null && relIdList != null) {
            return relIdList.stream().anyMatch(d -> d != null && d.equals(relVo.getId()));
        }
        return true;
    }
}
