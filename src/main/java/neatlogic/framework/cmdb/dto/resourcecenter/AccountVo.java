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

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.tag.TagVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.dto.OperateVo;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author linbq
 * @since 2021/5/30 15:20
 **/
public class AccountVo extends AccountBaseVo {
    private static final long serialVersionUID = 4163974111792082330L;
    @EntityField(name = "帐号", type = ApiParamType.STRING)
    private String account;
    @EntityField(name = "标签", type = ApiParamType.JSONARRAY)
    private List<TagVo> tagList;
    @EntityField(name = "标签Id列表", type = ApiParamType.JSONARRAY)
    private List<Long> tagIdList;
    @JSONField(serialize = false)
    private List<Long> protocolIdList;
    @EntityField(name = "资产依赖数", type = ApiParamType.INTEGER)
    private Integer resourceReferredCount = 0;
    @EntityField(name = "tagent依赖数", type = ApiParamType.INTEGER)
    private Integer tagentReferredCount = 0;
    @EntityField(name = "依赖数", type = ApiParamType.INTEGER)
    private Integer referredCount = 0;

    @EntityField(name = "操作列表")
    private List<OperateVo> operateList = new ArrayList<>();

    private Long resourceId;

    private List<String> protocolList;

    @EntityField(name = "类型", type = ApiParamType.STRING)
    private String type;

    @EntityField(name = "是否默认帐号", type = ApiParamType.INTEGER)
    private Integer isDefault = 0;

    public AccountVo() {

    }

    public AccountVo(String name, Long protocolId, Integer protocolPort, String ip, String passwordPlain) {
        super.setName(name);
        super.setProtocolId(protocolId);
        super.setProtocolPort(protocolPort);
        super.setIp(ip);
        super.setPasswordPlain(passwordPlain);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountVo accountVo = (AccountVo) o;
        return Objects.equals(getPasswordPlain(), accountVo.getPasswordPlain()) && Objects.equals(super.getProtocolId(), accountVo.getProtocolId()) && Objects.equals(super.getProtocolPort(), accountVo.getProtocolPort()) && Objects.equals(super.getIp(), accountVo.getIp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getPasswordPlain(), super.getProtocolId(), super.getProtocolPort(), super.getIp());
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<TagVo> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagVo> tagList) {
        this.tagList = tagList;
    }

    public List<Long> getProtocolIdList() {
        return protocolIdList;
    }

    public void setProtocolIdList(List<Long> protocolIdList) {
        this.protocolIdList = protocolIdList;
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

    public Integer getTagentReferredCount() {
        return tagentReferredCount;
    }

    public void setTagentReferredCount(Integer tagentReferredCount) {
        this.tagentReferredCount = tagentReferredCount;
    }

    public Integer getReferredCount() {
        return tagentReferredCount + resourceReferredCount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }
}
