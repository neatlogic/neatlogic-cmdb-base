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

package neatlogic.framework.cmdb.auth.label;

import neatlogic.framework.auth.core.AuthBase;

public class TRANSACTION_MANAGE extends AuthBase {
    @Override
    public String getAuthDisplayName() {
        return "事务审计权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "查看事务审计权限，可以查看所有配置项的修改记录";
    }

    @Override
    public String getAuthGroup() {
        return "cmdb";
    }

    @Override
    public Integer getSort() {
        return 12;
    }
}
