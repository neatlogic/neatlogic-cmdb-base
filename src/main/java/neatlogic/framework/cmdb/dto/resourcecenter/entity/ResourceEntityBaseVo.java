/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
