/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author linbq
 * @since 2021/6/17 10:34
 **/
public class AppModuleNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8738518138638398100L;

    public AppModuleNotFoundException(Long id) {
        super("应用模块：'" + id + "'不存在");
    }

    public AppModuleNotFoundException(String name) {
        super("应用模块：'" + name + "'不存在");
    }

    public AppModuleNotFoundException() {
        super("应用模块 id | name 不存在");
    }
}
