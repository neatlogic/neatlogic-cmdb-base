/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x - 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.cientity.AttrInvokeVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

public interface IAttrInvokeCrossoverService extends ICrossoverService {

    List<AttrInvokeVo> getAttrInvokeListByAttrId(Long attrId);

    List<AttrInvokeVo> getAttrInvokeListByAttrTypeAndTypeAndInvokeIdList(String attrType, String type, List<Long> invokeIdList);

    List<AttrInvokeVo> getAttrInvokeListByCiEntityIdListAndAttrIdList(List<Long> ciEntityIdList, List<Long> attrIdList);

    void updateAttrInvokeList(List<AttrInvokeVo> attrInvokeList);
}
