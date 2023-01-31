/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AttrEntityMultipleException extends ApiRuntimeException {
    public AttrEntityMultipleException(AttrVo attrVo) {
        super("属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")”只能单选");
    }
}
