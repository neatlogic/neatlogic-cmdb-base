/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.customview;

import codedriver.framework.exception.core.ApiRuntimeException;

public class IsolatedCustomViewCiException extends ApiRuntimeException {
    public IsolatedCustomViewCiException() {
        super("当前视图存在孤立模型（没有任何关系连入或连出的模型）");
    }

}
