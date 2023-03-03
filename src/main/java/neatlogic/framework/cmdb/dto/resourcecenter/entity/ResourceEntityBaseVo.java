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

package neatlogic.framework.cmdb.dto.resourcecenter.entity;

import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.cmdb.exception.resourcecenter.ResourceEntityViewNameNotFoundException;
import neatlogic.framework.common.dto.BasePageVo;
import org.apache.commons.lang3.StringUtils;

import java.lang.annotation.Annotation;

public class ResourceEntityBaseVo extends BasePageVo {
    public final String getSchemaName() {
        return TenantContext.get().getDataDbName();
    }

    public final String getViewName() {
        String viewName = "";
        Annotation[] annotations = this.getClass().getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof ResourceType) {
                viewName = TenantContext.get().getDataDbName() + "." + ((ResourceType) annotation).name();
                break;
            }
        }
        if (StringUtils.isNotBlank(viewName)) {
            return viewName;
        } else {
            throw new ResourceEntityViewNameNotFoundException();
        }

    }
}
