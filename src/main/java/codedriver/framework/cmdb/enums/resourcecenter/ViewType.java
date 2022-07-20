/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.resourcecenter;

public enum ViewType {
    RESOURCE("resource"), SCENE("scene");
    private final String value;

    ViewType(String _value) {
        this.value = _value;
    }

    public String getValue() {
        return value;
    }
}
