/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.transaction;

import codedriver.framework.cmdb.enums.TransactionStatus;
import codedriver.framework.exception.core.ApiRuntimeException;

public class TransactionStatusIrregularException extends ApiRuntimeException {
    public TransactionStatusIrregularException(TransactionStatus status) {
        super("当前事务" + status.getText());
    }
}
