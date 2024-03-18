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

package neatlogic.framework.cmdb.dto.cientity;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.List;

public class CiEntityStatusVo {
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "告警颜色", type = ApiParamType.STRING)
    private String alertColor;
    @EntityField(name = "告警级别名称", type = ApiParamType.STRING)
    private String alertLevelName;
    @EntityField(name = "告警级别", type = ApiParamType.INTEGER)
    private int alertLevel;
    @EntityField(name = "告警列表", type = ApiParamType.JSONARRAY)
    private List<CiEntityAlertVo> alertList;

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public String getAlertColor() {
        return alertColor;
    }

    public void setAlertColor(String alertColor) {
        this.alertColor = alertColor;
    }

    public String getAlertLevelName() {
        return alertLevelName;
    }

    public void setAlertLevelName(String alertLevelName) {
        this.alertLevelName = alertLevelName;
    }

    public int getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(int alertLevel) {
        this.alertLevel = alertLevel;
    }

    public List<CiEntityAlertVo> getAlertList() {
        return alertList;
    }

    public void setAlertList(List<CiEntityAlertVo> alertList) {
        this.alertList = alertList;
    }
}
