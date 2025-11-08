/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.dao.ognl;

import neatlogic.framework.cmdb.dto.ci.RelVo;
import neatlogic.framework.cmdb.dto.cientity.RelCiEntityFilterVo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 用于判断rel是否存在relCiEntityFilterList中，如果存在才进行join，提升查询配置项SQL性能
 */
public class IsRelExistsInCiEntityFilter {
    public static boolean isExists(RelVo relVo, List<RelCiEntityFilterVo> relCiEntityFilterList) {
        if (relVo != null && CollectionUtils.isNotEmpty(relCiEntityFilterList)) {
            return relCiEntityFilterList.stream().anyMatch(d -> d != null && d.getRelId().equals(relVo.getId()) && d.getDirection().equals(relVo.getDirection()));
        }
        return false;
    }
}
