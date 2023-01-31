/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.customview;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CustomViewPrivilegeException extends ApiRuntimeException {
    public enum Action {
        SAVE, READ, DELETE;
    }

    public CustomViewPrivilegeException(Action action) {
        super("您没有权限" + (action == Action.SAVE ? "保存" : (action == Action.DELETE ? "删除" : "查看")) + "公共自定义视图");
    }

}
