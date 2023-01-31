/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class CiNameIsExistsException extends ApiRuntimeException {
    public CiNameIsExistsException(String name) {
        super("模型唯一标识：" + name + " 已存在");
    }
}
