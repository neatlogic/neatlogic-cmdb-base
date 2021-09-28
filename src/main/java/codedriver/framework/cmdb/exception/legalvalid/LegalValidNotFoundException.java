/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.legalvalid;

import codedriver.framework.exception.core.ApiRuntimeException;

public class LegalValidNotFoundException extends ApiRuntimeException {
    public LegalValidNotFoundException(Long id) {
        super("合规校验规则“" + id + "”不存在");
    }
}
