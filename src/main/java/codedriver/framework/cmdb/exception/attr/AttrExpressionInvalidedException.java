/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.attr;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class AttrExpressionInvalidedException extends ApiRuntimeException {
    public AttrExpressionInvalidedException() {
        super("当前属性是表达式类型，表达式不能为空");
    }
}
