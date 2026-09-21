/*
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.cientity.InvokeEntityVo;
import neatlogic.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ICiEntityAttrInvokeCrossoverMapper extends ICrossoverService {

    List<Long> getCiEntityIdListByAttrId(Long attrId);

    // 按视图聚合的引用值读取属性索引，供跨模块属性处理器还原显示值。
    List<InvokeEntityVo> getAttrInvokeListByInvokeIdList(@Param("invokeIdList") List<Long> invokeIdList, @Param("attrIdList") List<Long> attrIdList);
}
