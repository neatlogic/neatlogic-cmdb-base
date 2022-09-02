/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.customview;

import codedriver.framework.exception.core.ApiRuntimeException;

public class CustomViewTypeIrregularException extends ApiRuntimeException {
    public CustomViewTypeIrregularException(String name) {
        super("当前视图不是“" + name + "”");
    }

}
