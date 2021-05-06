/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.transaction;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class CiEntityTransactionNotFoundException extends ApiRuntimeException {
    public CiEntityTransactionNotFoundException(Long transactionId) {
        super("事务：" + transactionId + "没有修改任何配置项");
    }
}