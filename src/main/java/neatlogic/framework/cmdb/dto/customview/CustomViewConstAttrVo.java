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

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;

import java.io.Serializable;

public class CustomViewConstAttrVo implements Serializable {
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "视图模型uuid", type = ApiParamType.STRING)
    private String customViewCiUuid;
    @EntityField(name = "属性名称", type = ApiParamType.STRING)
    private String constName;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "别名", type = ApiParamType.STRING)
    private String alias;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort = 0;
    @EntityField(name = "是否隐藏", type = ApiParamType.INTEGER)
    private Integer isHidden = 0;
    @EntityField(name = "是否主键", type = ApiParamType.INTEGER)
    private Integer isPrimary = 0;

    public CustomViewConstAttrVo() {

    }

    public CustomViewConstAttrVo(Long _customViewId) {
        this.customViewId = _customViewId;
    }

    public CustomViewConstAttrVo(JSONObject jsonObj) {
        this.uuid = jsonObj.getString("uuid");
        JSONObject conf = jsonObj.getJSONObject("config");
        if (MapUtils.isNotEmpty(conf)) {
            this.constName = conf.getString("constName");
            this.alias = conf.getString("alias");
            this.name = conf.getString("name");
            this.isHidden = conf.getIntValue("isHidden");
            this.sort = conf.getIntValue("sort");
            this.isPrimary = conf.getIntValue("isPrimary");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName = constName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }


    public Long getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(Long customViewId) {
        this.customViewId = customViewId;
    }

    public String getCustomViewCiUuid() {
        return customViewCiUuid;
    }

    public void setCustomViewCiUuid(String customViewCiUuid) {
        this.customViewCiUuid = customViewCiUuid;
    }


    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

    public Integer getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Integer isPrimary) {
        this.isPrimary = isPrimary;
    }
}
