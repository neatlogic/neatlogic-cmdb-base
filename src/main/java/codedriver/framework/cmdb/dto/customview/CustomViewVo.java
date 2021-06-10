/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.cmdb.dto.tag.TagVo;
import codedriver.framework.cmdb.exception.customview.CustomViewCiNotFoundException;
import codedriver.framework.cmdb.exception.customview.IsolatedCustomViewCiException;
import codedriver.framework.cmdb.exception.customview.NoStartCustomViewCiException;
import codedriver.framework.cmdb.exception.customview.OneMoreStartCustomViewCiException;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class CustomViewVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @JSONField(serialize = false)
    private transient String keyword;
    @EntityField(name = "是否私有视图", type = ApiParamType.INTEGER)
    private Integer isPrivate = 0;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "创建人", type = ApiParamType.STRING)
    private String fcu;
    @EntityField(name = "修改人", type = ApiParamType.STRING)
    private String lcu;
    @EntityField(name = "创建时间", type = ApiParamType.LONG)
    private Date fcd;
    @EntityField(name = "修改时间", type = ApiParamType.LONG)
    private Date lcd;
    @EntityField(name = "配置", type = ApiParamType.JSONOBJECT)
    private JSONObject config;
    @EntityField(name = "模型列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewCiVo> ciList;
    @EntityField(name = "关系列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewLinkVo> linkList;
    @JSONField(serialize = false)
    private transient String configStr;
    @EntityField(name = "授权列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewAuthVo> authList;
    @EntityField(name = "标签列表", type = ApiParamType.JSONARRAY)
    private List<TagVo> tagList;
    @JSONField(serialize = false)
    private transient Long tagId;
    private transient CustomViewCiVo startCustomViewCi;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    /**
     * 验证视图是否合法
     *
     * @return true 合法
     */
    public boolean valid() {
        if (CollectionUtils.isNotEmpty(ciList)) {
            if (ciList.size() > 1) {
                int startCount = 0;
                int isolatedCount = 0;
                for (CustomViewCiVo ciVo : ciList) {
                    if (CollectionUtils.isEmpty(getLinkListByToCustomCiUuid(ciVo.getUuid()))) {
                        startCount += 1;
                    }
                    if (CollectionUtils.isEmpty(getLinkListByCustomCiUuid(ciVo.getUuid()))) {
                        isolatedCount += 1;
                    }
                }
                if (isolatedCount > 0) {
                    throw new IsolatedCustomViewCiException();
                }
                if (startCount == 0) {
                    throw new NoStartCustomViewCiException();
                } else if (startCount > 1) {
                    throw new OneMoreStartCustomViewCiException();
                }
            }
        } else {
            throw new CustomViewCiNotFoundException();
        }
        return true;
    }

    public CustomViewCiVo getStartCustomViewCi() {
        if (startCustomViewCi == null) {
            if (CollectionUtils.isNotEmpty(ciList)) {
                if (ciList.size() == 1) {
                    startCustomViewCi = ciList.get(0);
                } else {
                    for (CustomViewCiVo ciVo : ciList) {
                        //如果模型的关系都是往外连出，则为驱动模型
                        if (CollectionUtils.isEmpty(getLinkListByToCustomCiUuid(ciVo.getUuid()))) {
                            startCustomViewCi = ciVo;
                            break;
                        }
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
    public List<CustomViewLinkVo> getLinkListByFromCustomCiUuid(String fromCustomViewCiUuid) {
        if (CollectionUtils.isNotEmpty(linkList)) {
            return linkList.stream().filter(link -> link.getFromCustomViewCiUuid().equalsIgnoreCase(fromCustomViewCiUuid)).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 根据目标模型uuid查找关系
     *
     * @param toCustomViewCiUuid 目标模型uuid
     * @return 关系列表
     */
    public List<CustomViewLinkVo> getLinkListByToCustomCiUuid(String toCustomViewCiUuid) {
        if (CollectionUtils.isNotEmpty(linkList)) {
            return linkList.stream().filter(link -> link.getToCustomViewCiUuid().equalsIgnoreCase(toCustomViewCiUuid)).collect(Collectors.toList());
        }
        return null;
    }

    /**
     * 根据模型uuid查找关系
     *
     * @param customViewCiUuid 模型uuid
     * @return 关系列表
     */
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
    public CustomViewCiVo getCustomCiByUuid(String customCiUuid) {
        Optional<CustomViewCiVo> op = this.ciList.stream().filter(ci -> ci.getUuid().equalsIgnoreCase(customCiUuid)).findFirst();
        return op.orElse(null);
    }

    @Override
    public String getKeyword() {
        return keyword;
    }

    @Override
    public void setKeyword(String keyword) {
        this.keyword = keyword;
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

    public Integer getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Integer isPrivate) {
        this.isPrivate = isPrivate;
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
            this.ciList.sort(Comparator.comparing(CustomViewCiVo::getSort));
        }
    }

    public List<CustomViewLinkVo> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<CustomViewLinkVo> linkList) {
        this.linkList = linkList;
    }

    public List<CustomViewAuthVo> getAuthList() {
        return authList;
    }

    public void setAuthList(List<CustomViewAuthVo> authList) {
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
}
