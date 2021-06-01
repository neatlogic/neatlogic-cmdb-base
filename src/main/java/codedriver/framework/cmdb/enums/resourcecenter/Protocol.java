/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.resourcecenter;

import codedriver.framework.common.constvalue.IEnum;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * 连接协议枚举类
 *
 * @author linbq
 * @since 2021/6/1 11:51
 **/
public enum Protocol implements IEnum {
    FTP("ftp"),
    LOCAL("local"),
    RLOGIN("rlogin"),
    SERIAL("serial"),
    SFTP("sftp"),
    SSH("ssh"),
    TELNET("telnet");
    private final String value;

    Protocol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public List getValueTextList() {
        JSONArray array = new JSONArray();
        for (Protocol type : values()) {
            array.add(new JSONObject() {
                {
                    this.put("value", type.getValue());
                    this.put("text", type.getValue());
                }
            });
        }
        return array;
    }
}
