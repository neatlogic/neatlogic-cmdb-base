/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.group;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class CiGroupVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "团体id", type = ApiParamType.LONG)
    private Long groupId;
    @EntityField(name = "规则", type = ApiParamType.JSONOBJECT)
    private JSONObject rule;
    @JSONField(serialize = false)
    private String ruleStr;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public JSONObject getRule() {
        if (rule == null && StringUtils.isNotBlank(ruleStr)) {
            try {
                rule = JSONObject.parseObject(ruleStr);
            } catch (Exception ignored) {

            }
        }
        return rule;
    }

    public void setRule(JSONObject rule) {
        this.rule = rule;
    }

    public String getRuleStr() {
        if (ruleStr == null && rule != null) {
            ruleStr = rule.toString();
        }
        return ruleStr;
    }

    public void setRuleStr(String ruleStr) {
        this.ruleStr = ruleStr;
    }
}
