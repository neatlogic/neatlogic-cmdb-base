/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiNameExpressionHasNotExistsAttrException extends ApiRuntimeException {
    public CiNameExpressionHasNotExistsAttrException(String attrName) {
        super("名字表达式包含不存在的属性：" + attrName);
    }
}
