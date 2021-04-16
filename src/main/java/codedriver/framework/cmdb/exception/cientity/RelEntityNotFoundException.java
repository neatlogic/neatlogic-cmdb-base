/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.cientity;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class RelEntityNotFoundException extends ApiRuntimeException {
    public RelEntityNotFoundException(String label) {
        super("关系：" + label + " 不能为空");
    }

}
