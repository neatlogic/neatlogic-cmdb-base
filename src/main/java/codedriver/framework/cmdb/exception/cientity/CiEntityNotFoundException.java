/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.cientity;

import codedriver.framework.exception.core.ApiRuntimeException;

public class CiEntityNotFoundException extends ApiRuntimeException {
    public CiEntityNotFoundException(Long ciEntityId) {
        super("配置项：" + ciEntityId + " 不存在");
    }

    public CiEntityNotFoundException(String ciEntityName) {
        super("配置项：" + ciEntityName + " 不存在");
    }

}
