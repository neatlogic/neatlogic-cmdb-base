/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

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

import java.util.Objects;

public class ResourceCenterAccountHasBeenReferredException extends ApiRuntimeException {

    private static final long serialVersionUID = 3895106015882702526L;

    public ResourceCenterAccountHasBeenReferredException(String name) {
        super("帐号：被 " + (Objects.equals(name, "resource") ? "资产" : name) + " 引用,无法删除");
    }
}
