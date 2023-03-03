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
