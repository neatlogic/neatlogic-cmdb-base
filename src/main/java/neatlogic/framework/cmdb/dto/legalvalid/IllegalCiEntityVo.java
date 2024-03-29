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
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;

public class IllegalCiEntityVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型唯一标识", type = ApiParamType.STRING)
    private String ciName;
    @EntityField(name = "模型名称", type = ApiParamType.STRING)
    private String ciLabel;
    @EntityField(name = "配置项名称", type = ApiParamType.STRING)
    private String ciEntityName;
    @JSONField(serialize = false)
    private List<Long> ciIdList;//模型id列表，用于查询所有子模型
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "规则名称", type = ApiParamType.STRING)
    private String legalValidName;
    @EntityField(name = "规则类型", type = ApiParamType.ENUM, member = LegalValidType.class)
    private String legalValidType;
    @EntityField(name = "规则类型名称", type = ApiParamType.STRING)
    private String legalValidTypeText;
    @EntityField(name = "规则id", type = ApiParamType.LONG)
    private Long legalValidId;
    @EntityField(name = "校验时间", type = ApiParamType.LONG)
    private Date validTime;
    @JSONField(serialize = false)
    public String errorStr;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private JSONArray error;
    @EntityField(name = "检查时间范围", type = ApiParamType.JSONARRAY)
    public List<String> validTimeRange;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public String getCiLabel() {
        return ciLabel;
    }

    public void setCiLabel(String ciLabel) {
        this.ciLabel = ciLabel;
    }

    public String getCiEntityName() {
        return ciEntityName;
    }

    public List<Long> getCiIdList() {
        return ciIdList;
    }

    public void setCiIdList(List<Long> ciIdList) {
        this.ciIdList = ciIdList;
    }

    public void setCiEntityName(String ciEntityName) {
        this.ciEntityName = ciEntityName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLegalValidName() {
        return legalValidName;
    }

    public void setLegalValidName(String legalValidName) {
        this.legalValidName = legalValidName;
    }

    public String getLegalValidType() {
        return legalValidType;
    }

    public void setLegalValidType(String legalValidType) {
        this.legalValidType = legalValidType;
    }

    public List<String> getValidTimeRange() {
        return validTimeRange;
    }

    public void setValidTimeRange(List<String> validTimeRange) {
        this.validTimeRange = validTimeRange;
    }

    public String getLegalValidTypeText() {
        if (StringUtils.isBlank(legalValidTypeText) && StringUtils.isNotBlank(legalValidType)) {
            legalValidTypeText = LegalValidType.getText(legalValidType);
        }
        return legalValidTypeText;
    }

    public void setLegalValidTypeText(String legalValidTypeText) {
        this.legalValidTypeText = legalValidTypeText;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public Long getLegalValidId() {
        return legalValidId;
    }

    public void setLegalValidId(Long legalValidId) {
        this.legalValidId = legalValidId;
    }

    public Date getValidTime() {
        return validTime;
    }

    public void setValidTime(Date validTime) {
        this.validTime = validTime;
    }

    public String getErrorStr() {
        if (StringUtils.isBlank(errorStr) && CollectionUtils.isNotEmpty(error)) {
            errorStr = error.toJSONString();
        }
        return errorStr;
    }

    public void setErrorStr(String errorStr) {
        this.errorStr = errorStr;
    }

    public JSONArray getError() {
        if (error == null && StringUtils.isNotBlank(errorStr)) {
            try {
                error = JSONArray.parseArray(errorStr);
            } catch (Exception ignored) {

            }
        }
        return error;
    }

    public void setError(JSONArray error) {
        this.error = error;
    }
}
