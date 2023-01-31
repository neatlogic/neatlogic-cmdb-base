/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class NoChangeException extends ApiRuntimeException {
    public NoChangeException() {
        super("配置项没有任何修改");
    }

}
