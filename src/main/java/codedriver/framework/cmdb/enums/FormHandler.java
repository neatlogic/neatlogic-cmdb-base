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

    private String handler;
    private String handlerName;

    FormHandler(String value, String text) {
        handler = value;
        handlerName = text;
    }

    @Override
    public String getHandler() {
        return null;
    }

    @Override
    public String getHandlerName() {
        return null;
    }
}
