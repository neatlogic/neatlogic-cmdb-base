/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */
package neatlogic.framework.cmdb.dto.resourcecenter;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.common.util.RC4Util;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author longrf
 * @date 2023/4/12 11:34
 */

public class AccountBaseVo extends BaseEditorVo {

    private static final long serialVersionUID = 4163974111234082330L;
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "解密密码", type = ApiParamType.STRING)
    @JSONField(serialize = false)
    private transient String passwordPlain;
    @EntityField(name = "加密密码", type = ApiParamType.STRING)
    private String passwordCipher;
    @EntityField(name = "协议ID", type = ApiParamType.LONG)
    private Long protocolId;
    @EntityField(name = "协议", type = ApiParamType.STRING)
    private String protocol;
    @EntityField(name = "协议端口", type = ApiParamType.INTEGER)
    private Integer protocolPort;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    private String ip;

    public AccountBaseVo() {
    }

    public AccountBaseVo(String name, Long protocolId, Integer protocolPort, String ip, String passwordPlain) {
        this.name = name;
        this.protocolId = protocolId;
        this.protocolPort = protocolPort;
        this.ip = ip;
        this.passwordPlain = passwordPlain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountBaseVo accountVo = (AccountBaseVo) o;
        return Objects.equals(getPasswordPlain(), accountVo.getPasswordPlain()) && Objects.equals(protocolId, accountVo.protocolId) && Objects.equals(protocolPort, accountVo.protocolPort) && Objects.equals(ip, accountVo.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passwordPlain, protocolId, protocolPort, ip);
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswordPlain() {
        if (StringUtils.isBlank(passwordPlain)) {
            if (StringUtils.isNotBlank(passwordCipher)) {
                this.passwordPlain = RC4Util.decrypt(this.passwordCipher);
            }
        }
        return passwordPlain;
    }

    public void setPasswordPlain(String passwordPlain) {
        this.passwordPlain = passwordPlain;
    }

    public String getPasswordCipher() {
        if (StringUtils.isBlank(passwordCipher)) {
            if (StringUtils.isNotBlank(passwordPlain)) {
                this.passwordCipher = RC4Util.encrypt(passwordPlain);
            }
        }
        return passwordCipher;
    }

    public void setPasswordCipher(String passwordCipher) {
        this.passwordCipher = passwordCipher;
    }


    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getProtocolPort() {
        return protocolPort;
    }

    public void setProtocolPort(Integer protocolPort) {
        this.protocolPort = protocolPort;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
