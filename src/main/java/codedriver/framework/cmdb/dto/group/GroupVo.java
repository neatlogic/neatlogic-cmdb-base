/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.group;

import codedriver.framework.cmdb.enums.group.GroupType;
import codedriver.framework.cmdb.enums.group.Status;
import codedriver.framework.common.config.Config;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class GroupVo extends BaseEditorVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "类型", type = ApiParamType.ENUM, member = GroupType.class)
    private String type;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    private String typeName;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "规则列表", type = ApiParamType.JSONARRAY)
    private List<CiGroupVo> ciGroupList;
    @EntityField(name = "授权列表", type = ApiParamType.JSONARRAY)
    private List<GroupAuthVo> groupAuthList;

    @EntityField(name = "配置项数量", type = ApiParamType.INTEGER)
    private int ciEntityCount;
    @JSONField(serialize = false)
    private Integer isSync;//是否同步，同步会删除不符合规则的配置项关系
    @EntityField(name = "状态", type = ApiParamType.ENUM, member = Status.class)
    private String status = Status.DONE.getValue();
    @JSONField(serialize = false)
    private Integer serverId;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "授权字符串列表", type = ApiParamType.STRING)
    private List<String> authList;
    @JSONField(serialize = false)
    private List<Long> idList;//id列表，精确查找用

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Integer getServerId() {
        if (serverId == null) {
            serverId = Config.SCHEDULE_SERVER_ID;
        }
        return serverId;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<GroupAuthVo> getGroupAuthList() {
        return groupAuthList;
    }

    public void setGroupAuthList(List<GroupAuthVo> groupAuthList) {
        this.groupAuthList = groupAuthList;
    }

    public List<String> getAuthList() {
        if (CollectionUtils.isEmpty(authList) && CollectionUtils.isNotEmpty(groupAuthList)) {
            authList = groupAuthList.stream().map(a -> a.getAuthType() + "#" + a.getAuthUuid()).collect(Collectors.toList());
        }
        return authList;
    }

    public void setAuthList(List<String> authList) {
        this.authList = authList;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public List<CiGroupVo> getCiGroupList() {
        return ciGroupList;
    }

    public void setCiGroupList(List<CiGroupVo> ciGroupList) {
        this.ciGroupList = ciGroupList;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTypeName() {
        if (StringUtils.isNotBlank(type) && StringUtils.isBlank(typeName)) {
            typeName = GroupType.getText(type);
        }
        return typeName;
    }

    public Integer getIsSync() {
        return isSync;
    }

    public void setIsSync(Integer isSync) {
        this.isSync = isSync;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getCiEntityCount() {
        return ciEntityCount;
    }

    public void setCiEntityCount(int ciEntityCount) {
        this.ciEntityCount = ciEntityCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
