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

package neatlogic.framework.cmdb.dto.legalvalid;

import neatlogic.framework.cmdb.enums.legalvalid.LegalValidType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class LegalValidVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "时间规则", type = ApiParamType.STRING)
    private String cron;
    @EntityField(name = "校验类型", type = ApiParamType.ENUM, member = LegalValidType.class)
    private String type;
    @EntityField(name = "校验规则名称", type = ApiParamType.STRING)
    public String typeText;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @JSONField(serialize = false)
    private String ruleStr;
    @EntityField(name = "规则", type = ApiParamType.JSONOBJECT)
    private JSONObject rule;
    @EntityField(name = "不合法配置项数量", type = ApiParamType.INTEGER)
    private int illegalCiEntityCount;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIllegalCiEntityCount() {
        return illegalCiEntityCount;
    }

    public void setIllegalCiEntityCount(int illegalCiEntityCount) {
        this.illegalCiEntityCount = illegalCiEntityCount;
    }

    public String getTypeText() {
        if (StringUtils.isBlank(typeText) && StringUtils.isNotBlank(type)) {
            typeText = LegalValidType.getText(type);
        }
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //自定义规则才需要返回规则内容，否则直接舍弃掉
    public String getRuleStr() {
        if ("custom".equals(type) && StringUtils.isBlank(ruleStr) && MapUtils.isNotEmpty(rule)) {
            ruleStr = rule.toString(SerializerFeature.DisableCircularReferenceDetect);
        }
        return ruleStr;
    }

    public void setRuleStr(String ruleStr) {
        this.ruleStr = ruleStr;
    }

    //自定义规则才需要返回规则内容，否则直接舍弃掉
    public JSONObject getRule() {
        if ("custom".equals(type) && rule == null && StringUtils.isNotBlank(ruleStr)) {
            rule = JSONObject.parseObject(ruleStr);
        }
        return rule;
    }

    public void setRule(JSONObject rule) {
        this.rule = rule;
    }
}
