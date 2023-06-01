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

import java.util.Collections;
import java.util.List;

public class SYNC_MODIFY extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "配置项模型自动采集映射管理权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "管理配置项模型的属性或关系与采集数据之间的映射关系，配置了映射关系后才能使用自动采集功能。";
    }

    @Override
    public String getAuthGroup() {
        return "cmdb";
    }

    @Override
    public Integer getSort() {
        return 2;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths() {
        return Collections.singletonList(CMDB_BASE.class);
    }
}
