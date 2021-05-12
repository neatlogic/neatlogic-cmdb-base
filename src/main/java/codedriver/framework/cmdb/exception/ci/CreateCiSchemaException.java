/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.exception.core.ApiRuntimeException;

public class CreateCiSchemaException extends ApiRuntimeException {
    public CreateCiSchemaException(String ciName) {
        super("创建模型：" + ciName + "数据表失败。");
    }

    public CreateCiSchemaException(String ciName, boolean isView) {
        super("创建模型：" + ciName + "数据视图失败。");
    }
}
