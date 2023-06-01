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
 * @author lvzk
 * @since 2021/7/27 10:34
 **/
public class ResourceCenterResourceHasRepeatAccountException extends ApiRuntimeException {

    private static final long serialVersionUID = 6934793951984585148L;

    public ResourceCenterResourceHasRepeatAccountException(String resourceId, String account, String protocol) {
        super("资源“{0}”存在多个 协议为“{2}”用户名为“{1}”的账号,请联系管理员", resourceId, protocol, account);
    }
}
