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

package neatlogic.framework.cmdb.exception.sync;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.sync.SyncCiCollectionVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class UniqueAttrNotCertifyException extends ApiRuntimeException {
    public UniqueAttrNotCertifyException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo) {
        super("请确保配置“{0}->{1}({2})”中所有唯一规则属性都已经配置映射关系，并且集合中对应的属性值不能为空", syncCiCollectionVo.getCollectionName(), ciVo.getLabel(), ciVo.getName());
    }
}
