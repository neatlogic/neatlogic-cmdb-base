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

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.config.ITenantConfig;
import neatlogic.framework.util.$;

public enum CmdbTenantConfig implements ITenantConfig {
    IS_RESOURCECENTER_AUTH("is.resourcecenter.auth", "0", "nfce.cmdbtenantconfig.isresourcecenterauth"),
    RESOURCECENTER_DATA_COMPARISON_MODE_ENABLE("resourcecenter.data.comparison.mode.enable", "0", "是否开启资产清单新SQL和旧SQL查询结果对比模式，结果不一致会打印error日志"),
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

    @Override
    public String getDescription() {
        return $.t(description);
    }
}
