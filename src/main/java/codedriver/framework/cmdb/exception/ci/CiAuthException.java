/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.exception.core.ApiRuntimeException;

public class CiAuthException extends ApiRuntimeException {
    public CiAuthException() {
        super("您没有权限修改配置项模型");
    }

    public CiAuthException(String ciLabel) {
        super("您没有权限修改配置项模型：" + ciLabel);
    }
}
