package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountNameIsNotNullException extends ApiRuntimeException {
    public ResourceCenterAccountNameIsNotNullException() {
        super("用户名不能为空");
    }
}
