/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.group;

import codedriver.framework.cmdb.enums.GroupType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;

import java.util.Date;
import java.util.List;

public class GroupVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "类型", type = ApiParamType.ENUM, member = GroupType.class)
    private String type;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "规则列表", type = ApiParamType.JSONARRAY)
    private List<CiGroupVo> ciGroupList;
    @EntityField(name = "创建者uuid", type = ApiParamType.STRING)
    private String fcu;
    @EntityField(name = "创建时间", type = ApiParamType.LONG)
    private Date fcd;
    @EntityField(name = "修改者uuid", type = ApiParamType.STRING)
    private String lcu;
    @EntityField(name = "修改时间", type = ApiParamType.LONG)
    private Date lcd;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
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

    public String getFcu() {
        return fcu;
    }

    public void setFcu(String fcu) {
        this.fcu = fcu;
    }

    public Date getFcd() {
        return fcd;
    }

    public void setFcd(Date fcd) {
        this.fcd = fcd;
    }

    public String getLcu() {
        return lcu;
    }

    public void setLcu(String lcu) {
        this.lcu = lcu;
    }

    public Date getLcd() {
        return lcd;
    }

    public void setLcd(Date lcd) {
        this.lcd = lcd;
    }
}
