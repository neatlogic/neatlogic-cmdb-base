/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.validator;

import codedriver.framework.cmdb.validator.core.IValidator;
import codedriver.framework.cmdb.validator.core.ValidatorFactory;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class ValidatorVo extends BasePageVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "处理器类名", type = ApiParamType.STRING)
    private String handler;
    @EntityField(name = "处理器名称", type = ApiParamType.STRING)
    private String handlerName;
    @EntityField(name = "配置", type = ApiParamType.STRING)
    private JSONObject config;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    private String description;
    @EntityField(name = "错误内容模板", type = ApiParamType.STRING)
    private String errorTemplate;
    @EntityField(name = "是否激活", type = ApiParamType.INTEGER)
    private Integer isActive;
    @EntityField(name = "使用次数", type = ApiParamType.INTEGER)
    private int invokeCount;
    @JSONField(serialize = false)
    private String configStr;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getInvokeCount() {
        return invokeCount;
    }

    public void setInvokeCount(int invokeCount) {
        this.invokeCount = invokeCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public String getHandlerName() {
        if (StringUtils.isBlank(handlerName) && StringUtils.isNotBlank(handler)) {
            IValidator validator = ValidatorFactory.getValidator(handler);
            if (validator != null) {
                this.handlerName = validator.getName();
            }
        }
        return handlerName;
    }


    public JSONObject getConfig() {
        return config;
    }

    public void setConfig(String config) {
        try {
            if (StringUtils.isNotBlank(config)) {
                this.config = JSONObject.parseObject(config);
            }
        } catch (Exception ex) {

        }
    }

    public String getConfigStr() {
        if (this.config != null) {
            return config.toJSONString();
        }
        return null;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getErrorTemplate() {
        return errorTemplate;
    }

    public void setErrorTemplate(String errorTemplate) {
        this.errorTemplate = errorTemplate;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }


}
