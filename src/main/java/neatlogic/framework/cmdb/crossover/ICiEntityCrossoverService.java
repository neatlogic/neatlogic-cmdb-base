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

package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.cmdb.dto.transaction.CiEntityTransactionVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.HashMap;
import java.util.List;

public interface ICiEntityCrossoverService extends ICrossoverService {
    CiEntityVo getCiEntityById(Long ciId, Long ciEntityId);

    CiEntityVo getCiEntityById(CiEntityVo ciEntityVo);

    //List<CiEntityVo> getCiEntityByIdList(CiEntityVo ciEntityVo);
    List<CiEntityVo> getCiEntityByIdList(List<Long> ciEntityIdList);

    List<CiEntityVo> searchCiEntity(CiEntityVo ciEntityVo);

    /**
     * 该接口为了升级时节约时间，升级后会删除
     */
    List<CiEntityVo> ciEntityBuilder(CiEntityVo ciEntityVo, List<HashMap<String, Object>> resultList);

    List<Long> getCiEntityIdByCiId(CiEntityVo ciEntityVo);

    Long saveCiEntity(List<CiEntityTransactionVo> ciEntityTransactionList);

    String getCiEntityNameByCiEntityId(Long ciEntityId);
}
