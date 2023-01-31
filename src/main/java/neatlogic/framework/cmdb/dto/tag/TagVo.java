/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.tag;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.dto.OperateVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TagVo extends BasePageVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;

    @EntityField(name = "资产数", type = ApiParamType.INTEGER)
    private Integer assetsCount;

    @EntityField(name = "操作列表")
    private List<OperateVo> operateList = new ArrayList<>();

    public TagVo(){

    }

    public TagVo(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
