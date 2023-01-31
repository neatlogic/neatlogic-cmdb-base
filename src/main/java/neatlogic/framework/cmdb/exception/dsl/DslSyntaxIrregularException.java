/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.dsl;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class DslSyntaxIrregularException extends ApiRuntimeException {
    public DslSyntaxIrregularException(int row, int col, String msg) {
        super("行" + row + "，列" + col + "出现语法错误：" + msg);
    }

    public DslSyntaxIrregularException(String msg) {
        super(msg);
    }

}
