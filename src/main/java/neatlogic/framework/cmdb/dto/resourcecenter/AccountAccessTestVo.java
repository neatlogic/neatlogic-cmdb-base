/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    @EntityField(name = "帐号名称", type = ApiParamType.STRING)
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
