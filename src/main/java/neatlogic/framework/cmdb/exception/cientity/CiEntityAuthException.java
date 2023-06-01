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

package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiEntityAuthException extends ApiRuntimeException {
    private static final long serialVersionUID = 3825462374254380532L;

    public CiEntityAuthException(String action) {
        super("您没有权限{0}配置项", action);
    }

    public CiEntityAuthException(CiVo ciVo, String action) {
        super("您没有权限{0}“{1}({2})”的配置项", action, ciVo.getLabel(), ciVo.getName());
    }

    public CiEntityAuthException(String ciLabel, String action) {
        super("您没有权限{0}“{1}”的配置项", action, ciLabel);
    }

    public CiEntityAuthException(Long ciEntityId, String ciEntityName, String action) {
        super("您没有权限{0}配置项“{1}({2})”", action, ciEntityName, ciEntityId);
    }
}
