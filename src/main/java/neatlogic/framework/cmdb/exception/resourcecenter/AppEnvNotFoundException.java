/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author linbq
 * @since 2021/6/17 10:34
 **/
public class AppEnvNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -5353639287406720093L;

    public AppEnvNotFoundException(String name) {
        super("环境：“{0}”不存在", name);
    }

    public AppEnvNotFoundException(Long id) {
        super("环境：“{0}”不存在", id);
    }
}
