/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.cmdb.dto.ci.RelVo;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class CustomViewRelVo implements Serializable {
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "视图模型uuid", type = ApiParamType.STRING)
    private String customViewCiUuid;
    @EntityField(name = "属性id", type = ApiParamType.LONG)
    private Long relId;
    @JSONField(serialize = false)
    private transient RelVo relVo;

    public CustomViewRelVo() {

    }

    public CustomViewRelVo(JSONObject jsonObj) {
        this.uuid = jsonObj.getString("uuid");
        this.relId = jsonObj.getJSONObject("config").getLong("relId");
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

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public RelVo getRelVo() {
        return relVo;
    }

    public void setRelVo(RelVo relVo) {
        this.relVo = relVo;
    }
}
