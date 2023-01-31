/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiUniqueRuleAttrTypeIrregularException extends ApiRuntimeException {
    public CiUniqueRuleAttrTypeIrregularException(CiVo ciVo, AttrVo attrVo) {
        super("模型“" + ciVo.getLabel() + "(" + ciVo.getName() + ")”的唯一规则属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")”不能是一个表达式属性或引用型属性");
    }
}
