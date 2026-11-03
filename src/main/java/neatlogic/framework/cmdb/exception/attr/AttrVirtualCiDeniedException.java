package neatlogic.framework.cmdb.exception.attr;

import neatlogic.framework.exception.core.ApiRuntimeException;

/** 虚拟模型字段由视图配置生成，禁止独立维护。 */
public class AttrVirtualCiDeniedException extends ApiRuntimeException {
    /** 提示调用方通过视图配置维护字段。 */
    public AttrVirtualCiDeniedException() {
        super("cmdb.attr.error.virtualci");
    }
}
