/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.attr;

import codedriver.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class AttrNameRepeatException extends ApiRuntimeException {
    public AttrNameRepeatException(String name) {
        super("配置项模型属性：" + name + "已存在");
    }
}
