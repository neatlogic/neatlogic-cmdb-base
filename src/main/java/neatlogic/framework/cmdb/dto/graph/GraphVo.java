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

package neatlogic.framework.cmdb.dto.graph;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.cmdb.enums.customview.CustomViewType;
import neatlogic.framework.cmdb.enums.graph.GraphType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.constvalue.GroupSearch;
import neatlogic.framework.common.constvalue.UserType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphVo extends BaseEditorVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @JSONField(serialize = false)
    private Long excludeId;//排除id
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "图标", type = ApiParamType.STRING)
    private String icon;
    @EntityField(name = "说明", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "配置", type = ApiParamType.JSONOBJECT)
    private JSONObject config;
    @EntityField(name = "被引用视图id", type = ApiParamType.LONG)
    private Long toGraphId;
    @EntityField(name = "配置项id列表", type = ApiParamType.JSONARRAY)
    private List<Long> ciEntityIdList;

    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;

    @EntityField(name = "是否拥有父视图", type = ApiParamType.BOOLEAN)
    private Boolean hasParent;

    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    private String typeName;

    @JSONField(serialize = false)
    private boolean isAdmin;//是否管理员 如果是true，则同时搜索公共视图和个人视图

    @EntityField(name = "类型", type = ApiParamType.ENUM, member = GraphType.class)
    private String type;
    @EntityField(name = "授权列表", type = ApiParamType.JSONARRAY)
    private List<String> authList;
    @JSONField(serialize = false)
    private List<GraphAuthVo> graphAuthList;
    @JSONField(serialize = false)
    private String configStr;
    private String alertLevel;

    public Boolean getHasParent() {
        return hasParent;
    }

    public void setHasParent(Boolean hasParent) {
        this.hasParent = hasParent;
    }

    @JSONField(serialize = false)
    private String userUuid;
    @JSONField(serialize = false)
    private List<String> teamUuidList;
    @JSONField(serialize = false)
    private List<String> roleUuidList;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public List<Long> getCiEntityIdList() {
        return ciEntityIdList;
    }

    public void setCiEntityIdList(List<Long> ciEntityIdList) {
        this.ciEntityIdList = ciEntityIdList;
    }

    public Long getExcludeId() {
        return excludeId;
    }

    public void setExcludeId(Long excludeId) {
        this.excludeId = excludeId;
    }

    public Long getToGraphId() {
        return toGraphId;
    }

    public void setToGraphId(Long toGraphId) {
        this.toGraphId = toGraphId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        if (StringUtils.isNotBlank(type) && StringUtils.isBlank(typeName)) {
            typeName = CustomViewType.getText(type);
        }
        return typeName;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public List<String> getTeamUuidList() {
        return teamUuidList;
    }

    public void setTeamUuidList(List<String> teamUuidList) {
        this.teamUuidList = teamUuidList;
    }

    public List<String> getRoleUuidList() {
        return roleUuidList;
    }

    public void setRoleUuidList(List<String> roleUuidList) {
        this.roleUuidList = roleUuidList;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public JSONObject getConfig() {
        if (config == null && StringUtils.isNotBlank(configStr)) {
            try {
                config = JSONObject.parseObject(configStr);
            } catch (Exception ignored) {

            }
        }
        if (config == null) {
            config = new JSONObject();
        }
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
    }

    public String getConfigStr() {
        if (config != null) {
            configStr = config.toJSONString();
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public List<String> getAuthList() {
        if (CollectionUtils.isEmpty(authList)) {
            authList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(graphAuthList)) {
                for (GraphAuthVo authorityVo : this.graphAuthList) {
                    if (authorityVo.getType().equals(GroupSearch.ROLE.getValue())) {
                        authList.add(GroupSearch.ROLE.getValuePlugin() + authorityVo.getUuid());
                    } else if (authorityVo.getType().equals(GroupSearch.USER.getValue())) {
                        authList.add(GroupSearch.USER.getValuePlugin() + authorityVo.getUuid());
                    } else if (authorityVo.getType().equals(GroupSearch.TEAM.getValue())) {
                        authList.add(GroupSearch.TEAM.getValuePlugin() + authorityVo.getUuid());
                    } else if (authorityVo.getType().equals(GroupSearch.COMMON.getValue())) {
                        authList.add(GroupSearch.COMMON.getValuePlugin() + authorityVo.getUuid());
                    }
                }
            }
        }
        return authList;
    }

    public void setAuthList(List<String> authList) {
        this.authList = authList;
    }

    public List<GraphAuthVo> getGraphAuthList() {
        //以authList为准
        if (CollectionUtils.isNotEmpty(authList)) {
            graphAuthList = new ArrayList<>();
            for (String value : authList) {
                GraphAuthVo authorityVo = new GraphAuthVo();
                if (value.startsWith(GroupSearch.ROLE.getValuePlugin())) {
                    authorityVo.setType(GroupSearch.ROLE.getValue());
                    authorityVo.setUuid(value.replace(GroupSearch.ROLE.getValuePlugin(), StringUtils.EMPTY));
                } else if (value.startsWith(GroupSearch.USER.getValuePlugin())) {
                    authorityVo.setType(GroupSearch.USER.getValue());
                    authorityVo.setUuid(value.replace(GroupSearch.USER.getValuePlugin(), StringUtils.EMPTY));
                } else if (value.startsWith(GroupSearch.TEAM.getValuePlugin())) {
                    authorityVo.setType(GroupSearch.TEAM.getValue());
                    authorityVo.setUuid(value.replace(GroupSearch.TEAM.getValuePlugin(), StringUtils.EMPTY));
                } else if (value.startsWith(GroupSearch.COMMON.getValue())) {
                    authorityVo.setType(GroupSearch.COMMON.getValue());
                    authorityVo.setUuid(value.replace(GroupSearch.COMMON.getValuePlugin(), StringUtils.EMPTY));
                }
                graphAuthList.add(authorityVo);
            }
        }
        return graphAuthList;
    }

    public boolean hasPrivilege() {
        if (Objects.equals(this.getType(), GraphType.PRIVATE.getValue())) {
            return Objects.equals(this.getFcu(), UserContext.get().getUserUuid(true));
        } else {
            if (CollectionUtils.isEmpty(this.getGraphAuthList())) {
                return true;
            }
            String pUserUuid = UserContext.get().getUserUuid(true);
            List<String> pTeamUuidList = UserContext.get().getTeamUuidList();
            List<String> pRoleUuidList = UserContext.get().getRoleUuidList();
            for (GraphAuthVo authVo : this.getGraphAuthList()) {
                switch (authVo.getType()) {
                    case "common":
                        if (authVo.getUuid().equals(UserType.ALL.getValue())) {
                            return true;
                        }
                        break;
                    case "user":
                        if (pUserUuid.equals(authVo.getUuid())) {
                            return true;
                        }
                        break;
                    case "team":
                        if (pTeamUuidList.contains(authVo.getUuid())) {
                            return true;
                        }
                        break;
                    case "role":
                        if (pRoleUuidList.contains(authVo.getUuid())) {
                            return true;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return false;
    }

    public void setGraphAuthList(List<GraphAuthVo> graphAuthList) {
        this.graphAuthList = graphAuthList;
    }
}
