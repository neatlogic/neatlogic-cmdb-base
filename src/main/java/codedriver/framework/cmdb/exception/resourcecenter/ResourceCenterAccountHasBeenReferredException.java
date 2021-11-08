/*
 * Copyright(c) 2021. TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

import java.util.Objects;

public class ResourceCenterAccountHasBeenReferredException extends ApiRuntimeException {

    private static final long serialVersionUID = 3895106015882702526L;

    public ResourceCenterAccountHasBeenReferredException(String name) {
        super("账号：被 " + (Objects.equals(name, "resource") ? "资产" : name) + " 引用,无法删除");
    }
}
