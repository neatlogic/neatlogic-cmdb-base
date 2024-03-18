/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.dto.resourcecenter;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.lang3.StringUtils;

public class AccountAccessTestVo {
    @EntityField(name = "IP", type = ApiParamType.STRING)
    private String host;
    @EntityField(name = "port")
    private Object port;
    @EntityField(name = "协议端口")
    private Object protocolPort;
    @EntityField(name = "协议", type = ApiParamType.STRING)
    private String protocol;
    @EntityField(name = "节点名称", type = ApiParamType.STRING)
    private String nodeName;
    @EntityField(name = "节点类型", type = ApiParamType.STRING)
    private String nodeType;
    @EntityField(name = "用户名", type = ApiParamType.STRING)
    private String username;
    @EntityField(name = "密码", type = ApiParamType.STRING)
    private String password;
    @EntityField(name = "账号名称", type = ApiParamType.STRING)
    private String name;

    public AccountAccessTestVo() {

    }

    public AccountAccessTestVo(String host, Object port, Object protocolPort, String protocol, String nodeName, String nodeType, String username, String password, String name) {
        this.host = host;
        this.port = port;
        this.protocolPort = protocolPort;
        this.protocol = protocol;
        this.nodeName = nodeName;
        this.nodeType = nodeType;
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public String getHost() {
        return host != null ? host : StringUtils.EMPTY;
    }

    public Object getPort() {
        return port != null ? port : StringUtils.EMPTY;
    }

    public Object getProtocolPort() {
        return protocolPort != null ? protocolPort : StringUtils.EMPTY;
    }

    public String getProtocol() {
        return protocol != null ? protocol : StringUtils.EMPTY;
    }

    public String getNodeName() {
        return nodeName != null ? nodeName : StringUtils.EMPTY;
    }

    public String getNodeType() {
        return nodeType != null ? nodeType : StringUtils.EMPTY;
    }

    public String getUsername() {
        return username != null ? username : StringUtils.EMPTY;
    }

    public String getPassword() {
        return password != null ? password : StringUtils.EMPTY;
    }

    public String getName() {
        return name;
    }
}
