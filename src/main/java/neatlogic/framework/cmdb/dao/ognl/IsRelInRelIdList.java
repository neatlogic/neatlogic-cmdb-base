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
