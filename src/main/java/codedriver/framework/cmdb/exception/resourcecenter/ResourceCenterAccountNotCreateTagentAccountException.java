package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountNotCreateTagentAccountException extends ApiRuntimeException {
    public ResourceCenterAccountNotCreateTagentAccountException() {
        super("使用tagent协议的账号不支持手动添加");
    }
}
