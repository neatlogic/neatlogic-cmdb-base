/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.validator;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.exception.core.ApiRuntimeException;

import java.util.List;

public class ValidatorIsInUsedException extends ApiRuntimeException {
    public ValidatorIsInUsedException(List<AttrVo> attrList) {
        super("当前校验规则已被" + attrList.size() + "个属性使用，请先删除");
    }
}
