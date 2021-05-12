/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.exception.core.ApiRuntimeException;

public class CiViewSqlIrregularException extends ApiRuntimeException {
    public CiViewSqlIrregularException(Exception msg) {
        super("虚拟模型SQL语句不是合法的SELECT语句：" + msg.getMessage());
    }

    public CiViewSqlIrregularException() {
        super("配置文件不是合法的XML文件");
    }
}
