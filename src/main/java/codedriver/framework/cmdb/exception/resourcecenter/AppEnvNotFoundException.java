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
public class AppEnvNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -5353639287406720093L;

    public AppEnvNotFoundException(String name) {
        super("环境：'" + name + "'不存在");
    }

    public AppEnvNotFoundException(Long id) {
        super("环境：'" + id + "'不存在");
    }
}
