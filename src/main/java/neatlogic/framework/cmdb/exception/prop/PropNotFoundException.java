/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.prop;

import neatlogic.framework.exception.core.ApiRuntimeException;

@SuppressWarnings("serial")
public class PropNotFoundException extends ApiRuntimeException {
    public PropNotFoundException(Long propId) {
        super("属性定义：" + propId + " 不存在");
    }

}
