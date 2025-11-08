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

import neatlogic.framework.cmdb.dto.ci.AttrVo;

import java.util.List;

/**
 * 用于判断attr是否存在attrIdList中，如果存在才显示，提升查询配置项SQL性能
 */
public class IsAttrInAttrIdList {
    public static boolean isExists(AttrVo attrVo, List<Long> attrIdList) {
        if (attrVo != null && attrIdList != null) {
            return attrIdList.stream().anyMatch(d -> d != null && d.equals(attrVo.getId()));
        }
        return true;
    }
}
