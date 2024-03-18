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

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class CustomViewAttrVo implements Serializable {
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "视图模型uuid", type = ApiParamType.STRING)
    private String customViewCiUuid;
    @EntityField(name = "属性id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "别名", type = ApiParamType.STRING)
    private String alias;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort = 0;
    @EntityField(name = "条件", type = ApiParamType.JSONOBJECT)
    private JSONObject condition;
    @JSONField(serialize = false)
    private String conditionStr;
    @EntityField(name = "是否隐藏", type = ApiParamType.INTEGER)
    private Integer isHidden = 0;
    @EntityField(name = "是否主键", type = ApiParamType.INTEGER)
    private Integer isPrimary = 0;
    @EntityField(name = "属性定义", type = ApiParamType.JSONOBJECT)
    private AttrVo attrVo;

    public CustomViewAttrVo() {

    }

    public CustomViewAttrVo(Long _customViewId) {
        this.customViewId = _customViewId;
    }

    public CustomViewAttrVo(JSONObject jsonObj) {
        this.uuid = jsonObj.getString("uuid");
        JSONObject conf = jsonObj.getJSONObject("config");
        if (MapUtils.isNotEmpty(conf)) {
            this.attrId = conf.getLong("attrId");
            this.alias = conf.getString("alias");
            this.name = conf.getString("name");
            this.isHidden = conf.getIntValue("isHidden");
            this.isPrimary = conf.getIntValue("isPrimary");
            this.sort = conf.getIntValue("sort");
            this.condition = conf.getJSONObject("condition");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
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

    public Integer getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Integer isPrimary) {
        this.isPrimary = isPrimary;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public AttrVo getAttrVo() {
        return attrVo;
    }

    public void setAttrVo(AttrVo attrVo) {
        this.attrVo = attrVo;
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

    public JSONObject getCondition() {
        if (condition == null && StringUtils.isNotBlank(conditionStr)) {
            try {
                condition = JSONObject.parseObject(conditionStr);
            } catch (Exception ignored) {

            }
        }
        return condition;
    }

    public void setCondition(JSONObject condition) {
        this.condition = condition;
    }

    public String getConditionStr() {
        if (condition != null && StringUtils.isBlank(conditionStr)) {
            conditionStr = condition.toJSONString();
        }
        return conditionStr;
    }

    public void setConditionStr(String conditionStr) {
        this.conditionStr = conditionStr;
    }

    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

}
