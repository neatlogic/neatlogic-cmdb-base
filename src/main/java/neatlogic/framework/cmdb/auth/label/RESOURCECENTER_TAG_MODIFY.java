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

package neatlogic.framework.cmdb.auth.label;

import neatlogic.framework.auth.core.AuthBase;

import java.util.Arrays;
import java.util.List;

public class RESOURCECENTER_TAG_MODIFY extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "资源中心-标签管理权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "对资源中心的标签进行新增、修改、删除、编辑操作";
    }

    @Override
    public String getAuthGroup() {
        return "cmdb";
    }

    @Override
    public Integer getSort() {
        return 9;
    }

    @Override
    public List<Class<? extends AuthBase>> getIncludeAuths() {
        return Arrays.asList(CMDB_BASE.class, RESOURCECENTER_BASE.class);
    }
}
