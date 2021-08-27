/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.cientity;

import codedriver.framework.cmdb.dto.cientity.CiEntityVo;
import codedriver.framework.cmdb.enums.TransactionActionType;
import codedriver.framework.exception.core.ApiRuntimeException;

public class CiEntityHasUnCommitTransactionException extends ApiRuntimeException {
    public CiEntityHasUnCommitTransactionException(CiEntityVo ciEntityVo, TransactionActionType action) {
        super("配置项“" + ciEntityVo.getName() + "”存在未提交的" + action.getText() + "事务");
    }
}
