/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class AppSystemNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 1625737834478103452L;

    public AppSystemNotFoundException(String name) {
        super("应用：'" + name + "'不存在");
    }
    public AppSystemNotFoundException(Long id) {
        super("应用：'" + id + "'不存在");
    }
}
