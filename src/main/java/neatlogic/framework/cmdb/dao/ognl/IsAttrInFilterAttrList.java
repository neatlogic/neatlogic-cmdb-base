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

import neatlogic.framework.cmdb.dto.customview.CustomViewConditionFieldVo;
import neatlogic.framework.cmdb.dto.customview.CustomViewConditionFilterVo;

import java.util.List;

/**
 * 用于判断CustomViewConditionFieldVo是否存在attrFilterList中，如果存在才输出hash字段，减少group_concat和md5操作
 */
public class IsAttrInFilterAttrList {
    public static boolean isExists(CustomViewConditionFieldVo attrVo, List<CustomViewConditionFilterVo> attrFilterList) {
        if (attrVo != null && attrFilterList != null) {
            return attrFilterList.stream().anyMatch(d -> d != null && d.getAttrUuid().equals(attrVo.getName()));
        }
        return true;
    }
}
