/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.exception.sync;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.sync.SyncCiCollectionVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class UniqueAttrNotCertifyException extends ApiRuntimeException {
    public UniqueAttrNotCertifyException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo) {
        super("请确保配置“" + syncCiCollectionVo.getCollectionName() + "->" + ciVo.getLabel() + "(" + ciVo.getName() + ")”中所有唯一规则属性都已经配置映射关系，并且集合中对应的属性值不能为空");
    }
}
