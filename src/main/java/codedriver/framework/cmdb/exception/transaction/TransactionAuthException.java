/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.transaction;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class TransactionAuthException extends ApiRuntimeException {
    public TransactionAuthException() {
        super("您没有权限处理当前事务");
    }
}
