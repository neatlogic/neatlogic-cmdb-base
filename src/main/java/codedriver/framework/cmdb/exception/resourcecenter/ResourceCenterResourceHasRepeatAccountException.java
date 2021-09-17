/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author lvzk
 * @since 2021/7/27 10:34
 **/
public class ResourceCenterResourceHasRepeatAccountException extends ApiRuntimeException {

    private static final long serialVersionUID = 6934793951984585148L;

    public ResourceCenterResourceHasRepeatAccountException(String resourceId, String account, String protocol) {
        super("资源\""+ resourceId+"）\"存在多个 协议为“"+protocol+"”用户名为“"+account+"”的账号,请联系管理员");
    }
}
