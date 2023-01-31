/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.customview;

import java.io.Serializable;

public class CustomViewConditionFieldVo implements Serializable {
    private String name;
    private String type;

    private String alias;

    public CustomViewConditionFieldVo(String _name, String _type) {
        name = _name;
        type = _type;
    }

    public CustomViewConditionFieldVo(String _name, String _type, String _alias) {
        name = _name;
        type = _type;
        alias = _alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
