/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.attr;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class AttrPropIdIsValidedException extends ApiRuntimeException {
    public AttrPropIdIsValidedException() {
        super("当前属性是属性定义类型，请选择有效的属性定义");
    }
}
