/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.customview;

import java.io.Serializable;

public class CustomViewValueFilterVo implements Serializable {
    private String uuid;
    private String value;

    public CustomViewValueFilterVo() {
    }

    public CustomViewValueFilterVo(String _uuid, String _value) {
        uuid = _uuid;
        value = _value;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
