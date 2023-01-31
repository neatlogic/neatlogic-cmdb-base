/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.customview;

import neatlogic.framework.cmdb.dto.customview.CustomViewCiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class ErrorStartCustomViewCiException extends ApiRuntimeException {
    public ErrorStartCustomViewCiException(CustomViewCiVo ci) {
        super("“" + ci.getAlias() + "”是起始模型，不能存在连入关系");
    }
}
