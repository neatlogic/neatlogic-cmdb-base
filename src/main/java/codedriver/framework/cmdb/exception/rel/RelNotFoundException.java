/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.rel;

import codedriver.framework.exception.core.ApiRuntimeException;

public class RelNotFoundException extends ApiRuntimeException {
    public RelNotFoundException(Long relId) {
        super("配置项模型关系：" + relId + " 不存在");
    }
}
