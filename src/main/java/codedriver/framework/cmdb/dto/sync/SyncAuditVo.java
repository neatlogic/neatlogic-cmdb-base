/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.sync;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;

import java.util.Date;

public class SyncAuditVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "同步配置id", type = ApiParamType.LONG)
    private Long syncConfigId;
    @EntityField(name = "开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "触发方式", type = ApiParamType.LONG)
    private String execType;
    @EntityField(name = "状态", type = ApiParamType.LONG)
    private String status;
    @EntityField(name = "事务组id", type = ApiParamType.LONG)
    private Long transactionGroupId;
    @EntityField(name = "服务器id", type = ApiParamType.LONG)
    private Integer serverId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSyncConfigId() {
        return syncConfigId;
    }

    public void setSyncConfigId(Long syncConfigId) {
        this.syncConfigId = syncConfigId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getExecType() {
        return execType;
    }

    public void setExecType(String execType) {
        this.execType = execType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTransactionGroupId() {
        return transactionGroupId;
    }

    public void setTransactionGroupId(Long transactionGroupId) {
        this.transactionGroupId = transactionGroupId;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }
}
