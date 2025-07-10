/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.cmdb.dto.resourcecenter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class ApplicationListDisplayVo implements Serializable {
    private Long id;

    private Long appSystemId;

    private Long appModuleId;

    private Long envId;

    private JSONObject config;

    @JSONField(serialize = false)
    private String configStr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppSystemId() {
        return appSystemId;
    }

    public void setAppSystemId(Long appSystemId) {
        this.appSystemId = appSystemId;
    }

    public Long getAppModuleId() {
        return appModuleId;
    }

    public void setAppModuleId(Long appModuleId) {
        this.appModuleId = appModuleId;
    }

    public Long getEnvId() {
        return envId;
    }

    public void setEnvId(Long envId) {
        this.envId = envId;
    }

    public JSONObject getConfig() {
        if (config == null && configStr != null) {
            config = JSON.parseObject(configStr);
        }
        return config;
    }

    public void setConfig(JSONObject config) {
        this.config = config;
    }

    public String getConfigStr() {
        if (config != null) {
            return config.toJSONString();
        }
        return configStr;
    }

    public void setConfigStr(String configStr) {
        this.configStr = configStr;
    }
}
