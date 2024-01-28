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

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiNotFoundException extends ApiRuntimeException {
    public CiNotFoundException(Long ciId) {
        super("配置项模型“{0}”不存在", ciId);
    }


    public CiNotFoundException(String ciName) {
        super("配置项模型“{0}”不存在", ciName);
    }

    public CiNotFoundException(String ciName, String configurationPath, String actualPath) {
        super("配置项模型“{0}”不存在，配置路径：{1}，实际路径：{2}", ciName, configurationPath, actualPath);
    }
}
