package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountNotCreateTagentAccountException extends ApiRuntimeException {
    public ResourceCenterAccountNotCreateTagentAccountException() {
        super("使用tagent协议的帐号不支持手动添加");
    }
}
