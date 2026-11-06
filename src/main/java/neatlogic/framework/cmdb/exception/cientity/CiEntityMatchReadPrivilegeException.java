package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.exception.core.ApiRuntimeException;

/** 区分匹配读取权限不足与规则元数据失效，防止预览跳过未授权规则。 */
public class CiEntityMatchReadPrivilegeException extends ApiRuntimeException {
    private static final long serialVersionUID = 1L;

    /** 保留原有权限提示，由调用方决定是否终止整次匹配。 */
    public CiEntityMatchReadPrivilegeException(String message) {
        super(message);
    }
}
