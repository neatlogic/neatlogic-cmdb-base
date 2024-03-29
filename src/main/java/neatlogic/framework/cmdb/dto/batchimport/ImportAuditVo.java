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

package neatlogic.framework.cmdb.dto.batchimport;

import neatlogic.framework.cmdb.enums.ImportStatus;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ImportAuditVo extends BasePageVo implements Serializable {

    private static final long serialVersionUID = 7432609786418756446L;
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型ID", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "导入的文件ID", type = ApiParamType.LONG)
    private Long fileId;
    @EntityField(name = "模型中文名", type = ApiParamType.STRING)
    private String ciName;
    @EntityField(name = "导入者UUID", type = ApiParamType.STRING)
    private String importUser;
    @EntityField(name = "导入者用户名", type = ApiParamType.STRING)
    private String importUserName;
    @EntityField(name = "发起时间", type = ApiParamType.LONG)
    private Date importDate;
    @EntityField(name = "完成时间", type = ApiParamType.LONG)
    private Date finishDate;
    private Integer importCount;
    @EntityField(name = "状态", type = ApiParamType.STRING)
    private String status;
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusText;
    @EntityField(name = "导入类型", type = ApiParamType.STRING)
    private String action;
    @EntityField(name = "导入类型文本", type = ApiParamType.STRING)
    private String actionText;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "成功数量", type = ApiParamType.INTEGER)
    private Integer successCount;
    @EntityField(name = "失败数量", type = ApiParamType.INTEGER)
    private Integer failedCount;
    @EntityField(name = "导入总数", type = ApiParamType.INTEGER)
    private Integer totalCount;
    private Integer serverId;
    @JSONField(serialize = false)
    private List<Long> idList;


    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public String getImportUser() {
        return importUser;
    }

    public void setImportUser(String importUser) {
        this.importUser = importUser;
    }

    public String getImportUserName() {
        return importUserName;
    }

    public void setImportUserName(String importUserName) {
        this.importUserName = importUserName;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Integer getImportCount() {
        return importCount;
    }

    public void setImportCount(Integer importCount) {
        this.importCount = importCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        if (StringUtils.isNotBlank(status) && StringUtils.isBlank(statusText)) {
            statusText = ImportStatus.getText(status);
        }
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }

    public String getActionText() {
        if (action != null) {
            if (action.equals("append")) {
                return "增量导入";
            } else if (action.equals("update")) {
                return "存量导入";
            } else if (action.equals("all")) {
                return "全量导入";
            }
        }
        return actionText;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getSuccessCount() {
        return successCount;
    }

    public void setSuccessCount(Integer successCount) {
        this.successCount = successCount;
    }

    public Integer getFailedCount() {
        return failedCount;
    }

    public void setFailedCount(Integer failedCount) {
        this.failedCount = failedCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }
}
