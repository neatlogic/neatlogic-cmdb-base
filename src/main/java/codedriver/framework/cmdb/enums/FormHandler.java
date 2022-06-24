/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums;

import codedriver.framework.form.constvalue.IFormHandler;

public enum FormHandler implements IFormHandler {
    CIENTITYSELECT("cientityselect", "配置项修改组件"),
    FORMCMDBCIENTITY("formcmdbcientity", "配置项组件"),
    PROTOCOL("protocol", "连接协议"),
    FORMRESOURECES("formresoureces", "执行目标"),
    ;

    private final String handler;
    private final String handlerName;

    FormHandler(String handler, String handlerName) {
        this.handler = handler;
        this.handlerName = handlerName;
    }

    @Override
    public String getHandler() {
        return handler;
    }

    @Override
    public String getHandlerName() {
        return handlerName;
    }
}
