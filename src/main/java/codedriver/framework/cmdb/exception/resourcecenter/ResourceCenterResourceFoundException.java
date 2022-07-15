/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ResourceCenterResourceFoundException extends ApiRuntimeException {

    public ResourceCenterResourceFoundException(String resource, String field) {
        super("资源实体：" + resource + "中没有定义" + field + "字段");
    }

    public ResourceCenterResourceFoundException(String resource) {
        super("资源实体：" + resource + "没定义");
    }
}
