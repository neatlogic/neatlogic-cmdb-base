/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.config.ITenantConfig;
import neatlogic.framework.util.$;

public enum CmdbTenantConfig implements ITenantConfig {
    IS_RESOURCECENTER_AUTH("is.resourcecenter.auth", "0", "nfce.cmdbtenantconfig.isresourcecenterauth"),
    RESOURCECENTER_DATA_COMPARISON_MODE_ENABLE("resourcecenter.data.comparison.mode.enable", "0", "nfce.cmdbtenantconfig.resourcecentercomparisonmodeenable"),
    RESOURCECENTER_SQL_MODE("resourcecenter.sql.mode", "jsqlparser", "nfce.cmdbtenantconfig.resourcecentersqlmode"),
    ;

    String key;
    String value;
    String description;

    CmdbTenantConfig(String key, String value, String description) {
        this.key = key;
        this.value = value;
        this.description = description;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }

    /** 返回当前语言环境下的租户配置描述。 */
    @Override
    public String getDescription() {
        return $.t(description);
    }

    @Override
    public String getModuleGroup() {
        return "cmdb";
    }
}
