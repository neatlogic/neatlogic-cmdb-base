/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.cientity;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class CiEntityIsLockedException extends ApiRuntimeException {
    public CiEntityIsLockedException(Long id) {
        super("配置项：" + id + " 已被锁定编辑");
    }

}
