/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.attr;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AttrValueIrregularException extends ApiRuntimeException {

    public AttrValueIrregularException(AttrVo attrVo, String value) {
        super("属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")”的值“" + value + "”不是合法的" + attrVo.getTypeText() + "类型");
    }

}
