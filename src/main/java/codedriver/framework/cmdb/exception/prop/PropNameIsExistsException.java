/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.prop;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class PropNameIsExistsException extends ApiRuntimeException {
    public PropNameIsExistsException(String msg) {
        super("属性定义：" + msg + " 已被引用");
    }

}
