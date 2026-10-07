/*
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package neatlogic.framework.cmdb.attrvaluehandler.core;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.cientity.AttrEntityVo;
import neatlogic.framework.cmdb.dto.cientity.InvokeEntityVo;

import java.util.List;

public interface IAttrInvokeHandler {

    void afterSaveCiEntity(AttrEntityVo attrEntityVo, JSONArray oldValueList);

    void afterDeleteCiEntity(AttrEntityVo attrEntityVo);

    List<InvokeEntityVo> convertValueListToInvokeEntityList(AttrEntityVo attrEntityVo);

    JSONArray convertInvokeEntityListToValueList(AttrVo attrVo, List<InvokeEntityVo> invokeEntityList);

    /**
     * 将显示值解析为引用记录条件数组；null表示处理器不支持文本搜索。
     * 外层数组中的候选组之间为OR，组内type与invokeId条件之间为AND。
     */
    default JSONArray getInvokeEntitySearchValueList(String expression, String value) {
        return null;
    }
}
