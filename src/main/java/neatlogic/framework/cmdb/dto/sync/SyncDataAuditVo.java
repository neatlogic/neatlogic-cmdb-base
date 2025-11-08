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
