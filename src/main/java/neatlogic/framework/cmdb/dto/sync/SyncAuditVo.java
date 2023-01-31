/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.sync;

import neatlogic.framework.cmdb.enums.sync.SyncStatus;
import neatlogic.framework.common.config.Config;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.constvalue.InputFrom;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SyncAuditVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "同步配置id", type = ApiParamType.LONG)
    private Long ciCollectionId;
    @EntityField(name = "开始时间", type = ApiParamType.LONG)
    private Date startTime;
    @EntityField(name = "结束时间", type = ApiParamType.LONG)
    private Date endTime;
    @EntityField(name = "触发方式", type = ApiParamType.ENUM, member = InputFrom.class)
    private String inputFrom;
    @EntityField(name = "触发方式名称", type = ApiParamType.STRING)
    private String inputFromText;
    @EntityField(name = "耗时（毫秒）", type = ApiParamType.LONG)
    private Long timeCost;
    @EntityField(name = "状态", type = ApiParamType.ENUM, member = SyncStatus.class)
    private String status;
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusText;
    @EntityField(name = "事务组id", type = ApiParamType.LONG)
    private Long transactionGroupId;
    @EntityField(name = "更新配置项数量", type = ApiParamType.INTEGER)
    private int transactionCount;
    @EntityField(name = "服务器id", type = ApiParamType.LONG)
    private Integer serverId;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "处理的数据量", type = ApiParamType.INTEGER)
    private int dataCount;
    @JSONField(serialize = false)
    private List<String> startTimeRange;
    @JSONField(serialize = false)
    private List<String> endTimeRange;
    @JSONField(serialize = false)
    private Boolean hasError;//查询条件，是否有异常
    @JSONField(serialize = false)
    private List<Long> idList;//id列表，精确查找用

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
    }

    public List<String> getStartTimeRange() {
        return startTimeRange;
    }

    public Long getTimeCost() {
        return timeCost;
    }

    public void setTimeCost(Long timeCost) {
        this.timeCost = timeCost;
    }

    public void setStartTimeRange(List<String> startTimeRange) {
        this.startTimeRange = startTimeRange;
    }

    public List<String> getEndTimeRange() {
        return endTimeRange;
    }

    public void setEndTimeRange(List<String> endTimeRange) {
        this.endTimeRange = endTimeRange;
    }

    public String getInputFromText() {
        if (StringUtils.isBlank(inputFromText) && StringUtils.isNotBlank(inputFrom)) {
            inputFromText = InputFrom.getText(inputFrom);
        }
        return inputFromText;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public String getStatusText() {
        if (StringUtils.isBlank(statusText) && StringUtils.isNotBlank(status)) {
            statusText = SyncStatus.getText(status);
        }
        return statusText;
    }


    public Boolean isHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public String getError() {
        if (StringUtils.isBlank(error) && !errorSet.isEmpty()) {
            error = "";
            for (String e : errorSet) {
                error += e + "\n";
            }
            error = error.substring(0, error.length() - 1);
        }
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private final Set<String> errorSet = new HashSet<>();

    public void appendError(String error) {
        if (StringUtils.isNotBlank(error)) {
            errorSet.add(error);
        }
       /* if (StringUtils.isBlank(this.error)) {
            this.error = error;
        } else {
            this.error += "\n" + error;
        }*/
    }

    public Long getCiCollectionId() {
        return ciCollectionId;
    }

    public void setCiCollectionId(Long ciCollectionId) {
        this.ciCollectionId = ciCollectionId;
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

    public String getInputFrom() {
        return inputFrom;
    }

    public void setInputFrom(String inputFrom) {
        this.inputFrom = inputFrom;
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
        if (serverId == null) {
            serverId = Config.SCHEDULE_SERVER_ID;
        }
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }
}
