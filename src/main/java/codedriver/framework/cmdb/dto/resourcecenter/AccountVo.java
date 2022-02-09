/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.cmdb.dto.tag.TagVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.constvalue.CiphertextPrefix;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.common.util.RC4Util;
import codedriver.framework.dto.OperateVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linbq
 * @since 2021/5/30 15:20
 **/
public class AccountVo extends BaseEditorVo {
    private static final long serialVersionUID = 4163974111792082330L;
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "账号", type = ApiParamType.STRING)
    private String account;
    @EntityField(name = "解密密码", type = ApiParamType.STRING)
    private String passwordPlain;
    @JSONField(serialize = false)
    @EntityField(name = "加密密码", type = ApiParamType.STRING)
    private String passwordCipher;
    @EntityField(name = "标签", type = ApiParamType.JSONARRAY)
    private List<TagVo> tagList;
    @EntityField(name = "标签Id列表", type = ApiParamType.JSONARRAY)
    private List<Long> tagIdList;
    @EntityField(name = "协议ID", type = ApiParamType.LONG)
    private Long protocolId;
    @EntityField(name = "协议", type = ApiParamType.STRING)
    private String protocol;
    @EntityField(name = "协议端口", type = ApiParamType.INTEGER)
    private Integer protocolPort;
    @EntityField(name = "资产依赖数", type = ApiParamType.INTEGER)
    private Integer resourceReferredCount = 0;
    @EntityField(name = "tagent依赖数", type = ApiParamType.INTEGER)
    private Integer tagentReferredCount = 0;
    @EntityField(name = "依赖数", type = ApiParamType.INTEGER)
    private Integer referredCount = 0;
    @EntityField(name = "tagent ip", type = ApiParamType.STRING)
    private String ip;

    @EntityField(name = "操作列表")
    private List<OperateVo> operateList = new ArrayList<>();

    private Long resourceId;

    private List<String> protocolList;

   public AccountVo(){

    }

    public AccountVo(String name, Long protocolId, Integer protocolPort, String ip, String passwordPlain){
        this.name=name;
        this.protocolId = protocolId;
        this.protocolPort = protocolPort;
        this.ip = ip;
        this.passwordPlain = passwordPlain;
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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswordPlain() {
        if (StringUtils.isBlank(passwordPlain)) {
            if (StringUtils.isNotBlank(passwordCipher)) {
                if (passwordCipher.startsWith(CiphertextPrefix.RC4.getValue())) {
                    this.passwordPlain = RC4Util.decrypt(this.passwordCipher.substring(4));
                } else {
                    this.passwordPlain = this.passwordCipher;
                }
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
                this.passwordCipher = CiphertextPrefix.RC4.getValue() + RC4Util.encrypt(passwordPlain);
            }
        }
        return passwordCipher;
    }

    public void setPasswordCipher(String passwordCipher) {
        this.passwordCipher = passwordCipher;
    }

    public List<TagVo> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagVo> tagList) {
        this.tagList = tagList;
    }

    public Long getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(Long protocolId) {
        this.protocolId = protocolId;
    }

    public Integer getProtocolPort() {
        return protocolPort;
    }

    public void setProtocolPort(Integer protocolPort) {
        this.protocolPort = protocolPort;
    }

    public Integer getResourceReferredCount() {
        return resourceReferredCount;
    }

    public void setResourceReferredCount(Integer resourceReferredCount) {
        this.resourceReferredCount = resourceReferredCount;
    }

    public List<OperateVo> getOperateList() {
        return operateList;
    }

    public void setOperateList(List<OperateVo> operateList) {
        this.operateList = operateList;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public List<String> getProtocolList() {
        return protocolList;
    }

    public void setProtocolList(List<String> protocolList) {
        this.protocolList = protocolList;
    }

    public List<Long> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<Long> tagIdList) {
        this.tagIdList = tagIdList;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getTagentReferredCount() {
        return tagentReferredCount;
    }

    public void setTagentReferredCount(Integer tagentReferredCount) {
        this.tagentReferredCount = tagentReferredCount;
    }

    public Integer getReferredCount() {
        return tagentReferredCount + resourceReferredCount;
    }
}
