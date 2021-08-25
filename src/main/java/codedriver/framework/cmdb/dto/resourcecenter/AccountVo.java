/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.cmdb.dto.tag.TagVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.dto.OperateVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linbq
 * @since 2021/5/30 15:20
 **/
public class AccountVo extends BaseEditorVo {
    @EntityField(name = "主键id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "账号", type = ApiParamType.STRING)
    private String account;
    @EntityField(name = "密码", type = ApiParamType.STRING)
    private String password;
    @EntityField(name = "标签", type = ApiParamType.JSONARRAY)
    private List<TagVo> tagList;
    @EntityField(name = "标签Id列表", type = ApiParamType.JSONARRAY)
    private List<Long> tagIdList;
    @EntityField(name = "协议ID", type = ApiParamType.LONG)
    private Long protocolId;
    @EntityField(name = "协议", type = ApiParamType.STRING)
    private String  protocol;
    @EntityField(name = "端口", type = ApiParamType.INTEGER)
    private Integer port;
    @EntityField(name = "资产数", type = ApiParamType.INTEGER)
    private Integer assetsCount = 0;

    @EntityField(name = "操作列表")
    private List<OperateVo> operateList = new ArrayList<>();

    private Long resourceId;

    private List<String> protocolList;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getAssetsCount() {
        return assetsCount;
    }

    public void setAssetsCount(Integer assetsCount) {
        this.assetsCount = assetsCount;
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
}
