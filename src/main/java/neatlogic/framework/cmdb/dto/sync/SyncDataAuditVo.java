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

package neatlogic.framework.cmdb.dto.sync;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

public class SyncDataAuditVo extends BasePageVo {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "审计id", type = ApiParamType.LONG)
    private Long auditId;
    @EntityField(name = "同步配置id", type = ApiParamType.LONG)
    private Long ciCollectionId;
    @EntityField(name = "集合名称", type = ApiParamType.STRING)
    private String collectionName;
    @EntityField(name = "数据id", type = ApiParamType.STRING)
    private String dataId;
    @JSONField(serialize = false)
    private String errorListStr;
    @EntityField(name = "异常", type = ApiParamType.JSONARRAY)
    private JSONArray errorList;

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public Long getCiCollectionId() {
        return ciCollectionId;
    }


    public void setCiCollectionId(Long ciCollectionId) {
        this.ciCollectionId = ciCollectionId;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getErrorListStr() {
        if (errorList != null) {
            errorListStr = errorList.toJSONString();
        }
        return errorListStr;
    }

    public void setErrorListStr(String errorListStr) {
        this.errorListStr = errorListStr;
    }

    public JSONArray getErrorList() {
        if (errorList == null && StringUtils.isNotBlank(errorListStr)) {
            try {
                errorList = JSON.parseArray(errorListStr);
            } catch (Exception ignored) {

            }
        }
        return errorList;
    }

    public void setErrorList(JSONArray errorList) {
        this.errorList = errorList;
    }
}
