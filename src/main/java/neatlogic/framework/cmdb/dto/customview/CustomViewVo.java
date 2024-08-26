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

package neatlogic.framework.cmdb.dto.customview;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.tag.TagVo;
import neatlogic.framework.cmdb.enums.customview.CustomViewType;
import neatlogic.framework.cmdb.exception.customview.*;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.constvalue.GroupSearch;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class CustomViewVo extends BasePageVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "类型", type = ApiParamType.ENUM, member = CustomViewType.class)
    private String type;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    private String typeName;
    @JSONField(serialize = false)
    private boolean isAdmin;//是否管理员 如果是true，则同时搜索公共视图和个人视图
    @EntityField(name = "创建人", type = ApiParamType.STRING)
    private String fcu;
    @EntityField(name = "修改人", type = ApiParamType.STRING)
    private String lcu;
    @EntityField(name = "创建时间", type = ApiParamType.LONG)
    private Date fcd;
    @EntityField(name = "修改时间", type = ApiParamType.LONG)
    private Date lcd;
    @EntityField(name = "起始模型id", type = ApiParamType.LONG)
    private Long startCiId;
    @EntityField(name = "配置", type = ApiParamType.JSONOBJECT)
    private JSONObject config;
    @EntityField(name = "模型列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewCiVo> ciList;
    @EntityField(name = "关系列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewLinkVo> linkList;
    @JSONField(serialize = false)
    private String configStr;

    @EntityField(name = "场景视图关联的模型id", type = ApiParamType.LONG)
    private Long ciId;

    @EntityField(name = "授权列表", type = ApiParamType.JSONARRAY)
    @JSONField(serialize = false)
    private List<CustomViewAuthVo> customViewAuthList;

    @EntityField(name = "授权列表", type = ApiParamType.STRING)
    private List<String> authList;
    @EntityField(name = "标签列表", type = ApiParamType.JSONARRAY)
    private List<TagVo> tagList;
    @JSONField(serialize = false)
    private Long tagId;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "图标", type = ApiParamType.STRING)
    private String icon;
    @JSONField(serialize = false)
    private CustomViewCiVo startCustomViewCi;//起始模型
    @EntityField(name = "起始模型uuid", type = ApiParamType.STRING)
    private String startCustomViewCiUuid;

    @EntityField(name = "自定义模板", type = ApiParamType.JSONOBJECT)
    private CustomViewTemplateVo customViewTemplate;
    @JSONField(serialize = false)
    private String userUuid;
    @JSONField(serialize = false)
    private List<String> teamUuidList;
    @JSONField(serialize = false)
    private List<String> roleUuidList;

    public Long getStartCiId() {
        return startCiId;
    }

    public void setStartCiId(Long startCiId) {
        this.startCiId = startCiId;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public CustomViewTemplateVo getCustomViewTemplate() {
        return customViewTemplate;
    }

    public void setCustomViewTemplate(CustomViewTemplateVo customViewTemplate) {
        this.customViewTemplate = customViewTemplate;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    /**
     * 验证视图是否合法
     *
     * @return true 合法
     */
    @JSONField(serialize = false)
    public boolean valid() {
        if (CollectionUtils.isNotEmpty(ciList)) {
            int startCount = 0;
            int isolatedCount = 0;
            for (CustomViewCiVo ciVo : ciList) {
                if (ciVo.getIsStart().equals(1)) {
                    startCount += 1;
                    if (CollectionUtils.isNotEmpty(linkList) && linkList.stream().anyMatch(link -> link.getToCustomViewCiUuid().equalsIgnoreCase(ciVo.getUuid()))) {
                        throw new ErrorStartCustomViewCiException(ciVo);
                    }
                }
                if (CollectionUtils.isEmpty(getLinkListByCustomCiUuid(ciVo.getUuid()))) {
                    isolatedCount += 1;
                }
            }
            if (isolatedCount > 0 && ciList.size() > 1) {
                throw new IsolatedCustomViewCiException();
            }
            if (startCount == 0) {
                throw new NoStartCustomViewCiException();
            } else if (startCount > 1) {
                throw new OneMoreStartCustomViewCiException();
            }
        } else {
            throw new CustomViewCiNotFoundException();
        }
        return true;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public String getStartCustomViewCiUuid() {
        if (StringUtils.isBlank(startCustomViewCiUuid)) {
            CustomViewCiVo startCi = this.getStartCustomViewCi();
            if (startCi != null) {
                startCustomViewCiUuid = startCi.getUuid();
            }
        }
        return startCustomViewCiUuid;
    }

    public CustomViewCiVo getStartCustomViewCi() {
        if (startCustomViewCi == null) {
            if (CollectionUtils.isNotEmpty(ciList)) {
                for (CustomViewCiVo ciVo : ciList) {
                    //如果模型的关系都是往外连出，则为驱动模型
                    if (ciVo.getIsStart().equals(1)) {
                        startCustomViewCi = ciVo;
                        break;
                    }
                }
            }
        }
        return startCustomViewCi;
    }

    /**
     * 根据来源模型uuid和目标模型uuid查找关系
     *
     * @param fromCustomViewCiUuid 来源模型uuid
     * @param toCustomViewCiUuid   目标模型uuid
     * @return 关系列表
     */
    @JSONField(serialize = false)
    public List<CustomViewLinkVo> getLinkListByFromToCustomCiUuid(String fromCustomViewCiUuid, String toCustomViewCiUuid) {
        if (CollectionUtils.isNotEmpty(linkList)) {
            return linkList.stream().filter(link -> link.getFromCustomViewCiUuid().equalsIgnoreCase(fromCustomViewCiUuid) && link.getToCustomViewCiUuid().equalsIgnoreCase(toCustomViewCiUuid)).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 根据来源模型uuid查找关系
     *
     * @param fromCustomViewCiUuid 来源模型uuid
     * @return 关系列表
     */
    @JSONField(serialize = false)
    public List<CustomViewLinkVo> getLinkListByFromCustomCiUuid(String fromCustomViewCiUuid) {
        if (CollectionUtils.isNotEmpty(linkList)) {
            return linkList.stream().filter(link -> link.getFromCustomViewCiUuid().equalsIgnoreCase(fromCustomViewCiUuid)).collect(Collectors.toList());
        }
        return null;
    }

    /*
      根据目标模型uuid查找关系

      @param toCustomViewCiUuid 目标模型uuid
     * @return 关系列表
     */
   /* @JSONField(serialize = false)
    public List<CustomViewLinkVo> getLinkListByToCustomCiUuid(String toCustomViewCiUuid) {
        if (CollectionUtils.isNotEmpty(linkList)) {
            return linkList.stream().filter(link -> link.getToCustomViewCiUuid().equalsIgnoreCase(toCustomViewCiUuid)).collect(Collectors.toList());
        }
        return null;
    }*/

    /**
     * 根据模型uuid查找关系
     *
     * @param customViewCiUuid 模型uuid
     * @return 关系列表
     */
    @JSONField(serialize = false)
    public List<CustomViewLinkVo> getLinkListByCustomCiUuid(String customViewCiUuid) {
        if (CollectionUtils.isNotEmpty(linkList)) {
            return linkList.stream().filter(link -> link.getFromCustomViewCiUuid().equalsIgnoreCase(customViewCiUuid) || link.getToCustomViewCiUuid().equalsIgnoreCase(customViewCiUuid)).collect(Collectors.toList());
        }
        return null;
    }


    /**
     * 根据uuid获取CI模型
     *
     * @param customCiUuid ci uuid
     * @return ci模型对象
     */
    @JSONField(serialize = false)
    public CustomViewCiVo getCustomCiByUuid(String customCiUuid) {
        Optional<CustomViewCiVo> op = this.ciList.stream().filter(ci -> ci.getUuid().equalsIgnoreCase(customCiUuid)).findFirst();
        return op.orElse(null);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        if (StringUtils.isNotBlank(type) && StringUtils.isBlank(typeName)) {
            typeName = CustomViewType.getText(type);
        }
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    /**
     * 显示所有全局属性
     *
     * @return 全局属性列表
     */
    @JSONField(serialize = false)//不能返回
    public List<CustomViewGlobalAttrVo> getGlobalAttrList() {
        return getGlobalAttrList(false);
    }

    /**
     * 显示所有属性
     *
     * @return 属性列表
     */
    @JSONField(serialize = false)//不能返回，除非clone一次attrVo
    public List<CustomViewAttrVo> getAttrList() {
        return getAttrList(false);
    }

    /**
     * 显示非隐藏全局属性
     *
     * @param hiddenHidden true:只返回非隐藏属性,false:返回所有属性
     * @return 全局属性列表
     */
    @JSONField(serialize = false)
    public List<CustomViewGlobalAttrVo> getGlobalAttrList(boolean hiddenHidden) {
        if (CollectionUtils.isNotEmpty(ciList)) {
            List<CustomViewGlobalAttrVo> attrList = new ArrayList<>();
            for (CustomViewCiVo customViewCiVo : ciList) {
                if (hiddenHidden) {
                    attrList.addAll(customViewCiVo.getGlobalAttrList().stream().filter(a -> a.getIsHidden().equals(0)).collect(Collectors.toList()));
                } else {
                    attrList.addAll(customViewCiVo.getGlobalAttrList());
                }
            }
            attrList.sort(Comparator.comparing(CustomViewGlobalAttrVo::getSort));
            return attrList;
        }
        return null;
    }

    /**
     * 显示非隐藏属性
     *
     * @param hiddenHidden true:只返回非隐藏属性,false:返回所有属性
     * @return 属性列表
     */
    @JSONField(serialize = false)
    public List<CustomViewAttrVo> getAttrList(boolean hiddenHidden) {
        if (CollectionUtils.isNotEmpty(ciList)) {
            List<CustomViewAttrVo> attrList = new ArrayList<>();
            for (CustomViewCiVo customViewCiVo : ciList) {
                if (hiddenHidden) {
                    attrList.addAll(customViewCiVo.getAttrList().stream().filter(a -> a.getIsHidden().equals(0)).collect(Collectors.toList()));
                } else {
                    attrList.addAll(customViewCiVo.getAttrList());
                }
            }
            attrList.sort(Comparator.comparing(CustomViewAttrVo::getSort));
            return attrList;
        }
        return null;
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


    public String getFcu() {
        return fcu;
    }

    public void setFcu(String fcu) {
        this.fcu = fcu;
    }

    public String getLcu() {
        return lcu;
    }

    public void setLcu(String lcu) {
        this.lcu = lcu;
    }

    public Date getFcd() {
        return fcd;
    }

    public void setFcd(Date fcd) {
        this.fcd = fcd;
    }

    public Date getLcd() {
        return lcd;
    }

    public void setLcd(Date lcd) {
        this.lcd = lcd;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public JSONObject getConfig() {
        if (config == null && StringUtils.isNotBlank(configStr)) {
            try {
                config = JSON.parseObject(configStr);
            } catch (Exception ignored) {

            }
        }
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
    }

    public String getConfigStr() {
        if (StringUtils.isBlank(configStr) && config != null) {
            configStr = config.toJSONString();
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }

    public List<CustomViewCiVo> getCiList() {
        return ciList;
    }

    public void setCiList(List<CustomViewCiVo> ciList) {
        this.ciList = ciList;
        if (CollectionUtils.isNotEmpty(this.ciList)) {
            this.ciList.sort(Comparator.comparing(CustomViewCiVo::getSort));
        }
    }

    public List<CustomViewLinkVo> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<CustomViewLinkVo> linkList) {
        this.linkList = linkList;
    }

    public List<CustomViewAuthVo> getCustomViewAuthList() {
        //以authList为准
        if (CollectionUtils.isNotEmpty(authList)) {
            customViewAuthList = new ArrayList<>();
            for (String value : authList) {
                CustomViewAuthVo authorityVo = new CustomViewAuthVo();
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
                customViewAuthList.add(authorityVo);
            }
        }
        return customViewAuthList;
    }

    public void setCustomViewAuthList(List<CustomViewAuthVo> customViewAuthList) {
        this.customViewAuthList = customViewAuthList;
    }

    public List<String> getAuthList() {
        if (CollectionUtils.isEmpty(authList)) {
            authList = new ArrayList<>();
            if (CollectionUtils.isNotEmpty(customViewAuthList)) {
                for (CustomViewAuthVo authorityVo : this.customViewAuthList) {
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

    public List<TagVo> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagVo> tagList) {
        this.tagList = tagList;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
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
}
