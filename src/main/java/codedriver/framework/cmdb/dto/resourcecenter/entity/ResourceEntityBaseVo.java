/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.cmdb.exception.resourcecenter.ResourceEntityViewNameNotFoundException;
import codedriver.framework.common.dto.BasePageVo;
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
