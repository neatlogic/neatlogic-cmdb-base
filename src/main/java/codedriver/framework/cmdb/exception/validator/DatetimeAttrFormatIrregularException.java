/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.validator;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.exception.core.ApiRuntimeException;

public class DatetimeAttrFormatIrregularException extends ApiRuntimeException {
    public DatetimeAttrFormatIrregularException(AttrVo attrVo, String value, String format) {
        super("属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")”的值“" + value + "”不符合格式“" + format + "”");
    }
}
