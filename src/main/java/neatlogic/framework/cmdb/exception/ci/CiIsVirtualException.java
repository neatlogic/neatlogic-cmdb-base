/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiIsVirtualException extends ApiRuntimeException {
    public CiIsVirtualException(String ciName) {
        super("配置项模型：" + ciName + "是虚拟模型，不能添加数据。");
    }
}
