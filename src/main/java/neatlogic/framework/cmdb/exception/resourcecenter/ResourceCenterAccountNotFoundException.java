/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterAccountNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 560397839803209200L;

    public ResourceCenterAccountNotFoundException(Long id) {
        super("账号：'" + id + "'不存在");
    }
    public ResourceCenterAccountNotFoundException(String name) {
        super("账号：'" + name + "'不存在");
    }

    public ResourceCenterAccountNotFoundException() {
        super("账号不存在");
    }

}
