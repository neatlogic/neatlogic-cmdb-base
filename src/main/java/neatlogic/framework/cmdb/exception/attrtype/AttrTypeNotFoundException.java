/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.attrtype;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AttrTypeNotFoundException extends ApiRuntimeException {
    public AttrTypeNotFoundException(String attrType) {
        super("属性类型：" + attrType + "不存在");
    }
}
