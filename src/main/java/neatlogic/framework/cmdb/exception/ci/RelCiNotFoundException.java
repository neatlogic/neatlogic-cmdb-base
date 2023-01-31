/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class RelCiNotFoundException extends ApiRuntimeException {

    public RelCiNotFoundException(String relName, String ciName) {
        super("关系“" + relName + "”的关联模型“" + ciName + "”不存在");
    }
}
