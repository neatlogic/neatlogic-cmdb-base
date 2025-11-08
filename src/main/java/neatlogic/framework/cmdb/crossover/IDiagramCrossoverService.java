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

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.crossover.ICrossoverService;
import org.springframework.transaction.annotation.Transactional;

public interface IDiagramCrossoverService extends ICrossoverService {
    /**
     * 必要属性：id
     * 选填属性：statusId,statusName,statusText三选一
     */
    @Transactional
    void updateDiagramVersionStatus(JSONArray diagramVersionList);
}
