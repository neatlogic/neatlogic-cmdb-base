/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.attr;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AttrNotFoundException extends ApiRuntimeException {
    public AttrNotFoundException(Long attrId) {
        super("配置项模型属性：" + attrId + " 不存在");
    }

    public AttrNotFoundException(String ciName, String attrName) {
        super("配置项模型：" + ciName + "不存在属性：" + attrName);
    }
}
