/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.customview;

import codedriver.framework.exception.core.ApiRuntimeException;

public class DeleteCustomViewFailedException extends ApiRuntimeException {
    public DeleteCustomViewFailedException(String msg) {
        super("删除视图失败，异常：" + msg);
    }

}
