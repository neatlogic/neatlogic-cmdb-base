/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.customview;

import neatlogic.framework.cmdb.dto.customview.CustomViewAttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class CustomViewAttrNameIsExistsException extends ApiRuntimeException {
    public CustomViewAttrNameIsExistsException(CustomViewAttrVo customViewAttrVo) {
        super("属性唯一标识“" + customViewAttrVo.getName() + "”已存在");
    }

}
