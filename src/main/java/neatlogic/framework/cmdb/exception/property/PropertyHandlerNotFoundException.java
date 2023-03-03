package neatlogic.framework.cmdb.exception.property;

import neatlogic.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class PropertyHandlerNotFoundException extends ApiRuntimeException {

    public PropertyHandlerNotFoundException(String msg) {
        super("属性类型：" + msg + " 不存在");
    }

}
