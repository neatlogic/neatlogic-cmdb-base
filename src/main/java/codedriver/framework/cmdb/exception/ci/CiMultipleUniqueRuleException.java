/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.exception.core.ApiRuntimeException;

public class CiMultipleUniqueRuleException extends ApiRuntimeException {
    public CiMultipleUniqueRuleException(CiVo ciVo) {
        super("模型“" + ciVo.getLabel() + "(" + ciVo.getName() + ")”唯一规则包含了多个属性，引用属性关联单值不支持这种配置方式");
    }
}
