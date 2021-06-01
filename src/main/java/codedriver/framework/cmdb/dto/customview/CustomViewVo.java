/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomViewVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "是否私有视图", type = ApiParamType.INTEGER)
    private Integer isPrivate;
    @EntityField(name = "所有者uuid", type = ApiParamType.STRING)
    private String ownerUuid;
    @EntityField(name = "所有者名称", type = ApiParamType.STRING)
    private String ownerName;
    @EntityField(name = "配置", type = ApiParamType.JSONOBJECT)
    private JSONObject config;
    @EntityField(name = "模型列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewCiVo> ciList;
    @EntityField(name = "关系列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewLinkVo> linkList;
    @JSONField(serialize = false)
    private transient String configStr;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public List<CustomViewLinkVo> getLinkListByFromToCustomCiUuid(String fromCustomViewCiUuid, String toCustomViewCiUuid) {
        if (CollectionUtils.isNotEmpty(linkList)) {
            return linkList.stream().filter(link -> link.getFromCustomViewCiUuid().equalsIgnoreCase(fromCustomViewCiUuid) && link.getToCustomViewCiUuid().equalsIgnoreCase(toCustomViewCiUuid)).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 显示所有属性
     *
     * @return 属性列表
     */
    public List<CustomViewAttrVo> getAttrList() {
        return getAttrList(false);
    }

    /**
     * 显示非隐藏属性
     *
     * @param hiddenHidden true:只返回非隐藏属性,false:返回所有属性
     * @return 属性列表
     */
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
            attrList.sort((o1, o2) -> o1.getSort().compareTo(o2.getSort()));
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

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getOwnerUuid() {
        return ownerUuid;
    }

    public void setOwnerUuid(String ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public JSONObject getConfig() {
        if (config == null && StringUtils.isNotBlank(configStr)) {
            try {
                config = JSONObject.parseObject(configStr);
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
            this.ciList.sort((o1, o2) -> o1.getSort().compareTo(o2.getSort()));
        }
    }

    public List<CustomViewLinkVo> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<CustomViewLinkVo> linkList) {
        this.linkList = linkList;
    }
}
