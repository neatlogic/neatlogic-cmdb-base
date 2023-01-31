/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.rel;

import neatlogic.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class RelGroupNameIsExistsException extends ApiRuntimeException {
    public RelGroupNameIsExistsException(String name) {
        super("模型关系分组：" + name + " 已存在");
    }
}
