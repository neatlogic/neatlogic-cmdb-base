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

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.Md5Util;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class CiEntityAlertVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "配置项名称", type = ApiParamType.STRING)
    private String ciEntityName;
    @JSONField(serialize = false)
    private List<Long> ciEntityIdList;
    @EntityField(name = "配置项唯一标识", type = ApiParamType.STRING)
    private String ciEntityUuid;
    @EntityField(name = "告警信息", type = ApiParamType.STRING)
    private String alertMessage;
    @EntityField(name = "告警时间", type = ApiParamType.LONG)
    private Date alertTime;
    @EntityField(name = "告警属性", type = ApiParamType.STRING)
    private String metricName;
    @EntityField(name = "告警值", type = ApiParamType.STRING)
    private String metricValue;
    @EntityField(name = "告警级别", type = ApiParamType.INTEGER)
    private int level;
    @EntityField(name = "告警级别名称", type = ApiParamType.STRING)
    private String levelName;
    @EntityField(name = "告警级别颜色", type = ApiParamType.STRING)
    private String levelColor;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    private String ip;
    @EntityField(name = "告警外部链接", type = ApiParamType.STRING)
    private String alertLink;

    public List<Long> getCiEntityIdList() {
        return ciEntityIdList;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public void setCiEntityIdList(List<Long> ciEntityIdList) {
        this.ciEntityIdList = ciEntityIdList;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public String getCiEntityName() {
        return ciEntityName;
    }

    public void setCiEntityName(String ciEntityName) {
        this.ciEntityName = ciEntityName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public String getCiEntityUuid() {
        if (StringUtils.isNotBlank(ciEntityUuid) && !Md5Util.isMd5(ciEntityUuid)) {
            ciEntityUuid = Md5Util.encryptMD5(ciEntityUuid);
        }
        return ciEntityUuid;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public String getLevelColor() {
        return levelColor;
    }

    public void setLevelColor(String levelColor) {
        this.levelColor = levelColor;
    }

    public void setCiEntityUuid(String ciEntityUuid) {
        this.ciEntityUuid = ciEntityUuid;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    public Date getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Date alertTime) {
        this.alertTime = alertTime;
    }

    public String getMetricName() {
        return metricName;
    }

    public void setMetricName(String metricName) {
        this.metricName = metricName;
    }

    public String getMetricValue() {
        return metricValue;
    }

    public void setMetricValue(String metricValue) {
        this.metricValue = metricValue;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAlertLink() {
        return alertLink;
    }

    public void setAlertLink(String alertLink) {
        this.alertLink = alertLink;
    }
}
