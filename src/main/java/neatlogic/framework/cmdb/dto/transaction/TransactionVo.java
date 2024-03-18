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

package neatlogic.framework.cmdb.dto.transaction;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.enums.TransactionActionType;
import neatlogic.framework.cmdb.enums.TransactionStatus;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.constvalue.InputFrom;
import neatlogic.framework.common.constvalue.SystemUser;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TransactionVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "nmcac.exportcientityapi.input.param.desc.idlist", type = ApiParamType.JSONARRAY)
    private List<Long> idList;
    @EntityField(name = "事务分组id", type = ApiParamType.LONG)
    private Long transactionGroupId;
    @JSONField(serialize = false)
    private Long transactionId;//用于检索，避免自动生成id导致条件错误
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "模型唯一标识", type = ApiParamType.STRING)
    private String ciName;
    @EntityField(name = "模型名称", type = ApiParamType.STRING)
    private String ciLabel;
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "配置项名称", type = ApiParamType.STRING)
    private String ciEntityName;
    @EntityField(name = "状态", type = ApiParamType.STRING, member = TransactionStatus.class)
    private String status;
    @JSONField(serialize = false)
    private List<String> statusList;//搜索条件状态列表
    @EntityField(name = "状态文本", type = ApiParamType.STRING)
    private String statusText;
    @EntityField(name = "输入来源", type = ApiParamType.STRING, member = InputFrom.class)
    private String inputFrom;
    @EntityField(name = "输入来源文本", type = ApiParamType.STRING)
    private String inputFromText;
    @EntityField(name = "操作(删除、添加或修改)", type = ApiParamType.ENUM, member = TransactionActionType.class)
    private String action;
    @EntityField(name = "操作文本", type = ApiParamType.STRING)
    private String actionText;
    @EntityField(name = "更新来源？", type = ApiParamType.STRING)
    private String source;
    @EntityField(name = "创建用户", type = ApiParamType.STRING)
    private String createUser;
    @EntityField(name = "创建用户名", type = ApiParamType.STRING)
    private String createUserName;
    @EntityField(name = "提交用户", type = ApiParamType.STRING)
    private String commitUser;
    @EntityField(name = "提交用户名", type = ApiParamType.STRING)
    private String commitUserName;
    @EntityField(name = "恢复用户", type = ApiParamType.STRING)
    private String recoverUser;
    @EntityField(name = "提交用户名", type = ApiParamType.STRING)
    private String recoverUserName;
    @JSONField(serialize = false)
    private Date expireTime;
    @EntityField(name = "创建时间", type = ApiParamType.LONG)
    private Date createTime;
    @EntityField(name = "提交时间", type = ApiParamType.LONG)
    private Date commitTime;
    @EntityField(name = "提交时间", type = ApiParamType.LONG)
    private Date recoverTime;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private String error;
    @EntityField(name = "配置项事务信息", type = ApiParamType.JSONOBJECT)
    private CiEntityTransactionVo ciEntityTransactionVo;
    @EntityField(name = "当前用户权限情况", type = ApiParamType.JSONOBJECT)
    private Map<String, Boolean> authData;
    @JSONField(serialize = false)
    private Integer hasError;//是否有异常
    @JSONField(serialize = false)
    private List<String> createTimeRange;
    @JSONField(serialize = false)
    private List<String> commitTimeRange;
    @JSONField(serialize = false)
    private List<String> recoverTimeRange;
    @EntityField(name = "属于统一事务组的事务数量", type = ApiParamType.INTEGER)
    private int brotherTransactionCount;
    @EntityField(name = "说明", type = ApiParamType.STRING)
    private String description;

    public Long getTransactionGroupId() {
        return transactionGroupId;
    }

    public void setTransactionGroupId(Long transactionGroupId) {
        this.transactionGroupId = transactionGroupId;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public List<Long> getIdList() {
        return idList;
    }

    public void setIdList(List<Long> idList) {
        this.idList = idList;
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

    public List<String> getRecoverTimeRange() {
        return recoverTimeRange;
    }

    public void setRecoverTimeRange(List<String> recoverTimeRange) {
        this.recoverTimeRange = recoverTimeRange;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInputFrom() {
        return inputFrom;
    }

    public void setInputFrom(String inputFrom) {
        this.inputFrom = inputFrom;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(String commitUser) {
        this.commitUser = commitUser;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public CiEntityTransactionVo getCiEntityTransactionVo() {
        return ciEntityTransactionVo;
    }

    public void setCiEntityTransactionVo(CiEntityTransactionVo ciEntityTransactionVo) {
        this.ciEntityTransactionVo = ciEntityTransactionVo;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public String getStatusText() {
        if (StringUtils.isNotBlank(status) && StringUtils.isBlank(statusText)) {
            statusText = TransactionStatus.getText(status);
        }
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public List<String> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<String> statusList) {
        this.statusList = statusList;
    }

    public String getInputFromText() {
        if (StringUtils.isNotBlank(inputFrom) && StringUtils.isBlank(inputFromText)) {
            inputFromText = InputFrom.getText(inputFrom);
        }
        return inputFromText;
    }

    public void setInputFromText(String inputFromText) {
        this.inputFromText = inputFromText;
    }

    public String getCreateUserName() {
        if (SystemUser.SYSTEM.getUserId().equals(createUser)) {
            return SystemUser.SYSTEM.getUserName();
        }
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public String getCommitUserName() {
        return commitUserName;
    }

    public void setCommitUserName(String commitUserName) {
        this.commitUserName = commitUserName;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionText() {
        if (StringUtils.isNotBlank(action) && StringUtils.isBlank(actionText)) {
            actionText = TransactionActionType.getText(action);
        }
        return actionText;
    }

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }

    public Integer getHasError() {
        return hasError;
    }

    public void setHasError(Integer hasError) {
        this.hasError = hasError;
    }

    public List<String> getCreateTimeRange() {
        return createTimeRange;
    }

    public void setCreateTimeRange(List<String> createTimeRange) {
        this.createTimeRange = createTimeRange;
    }

    public Map<String, Boolean> getAuthData() {
        return authData;
    }

    public void setAuthData(Map<String, Boolean> authData) {
        this.authData = authData;
    }

    public String getCiEntityName() {
        return ciEntityName;
    }

    public void setCiEntityName(String ciEntityName) {
        this.ciEntityName = ciEntityName;
    }

    public List<String> getCommitTimeRange() {
        return commitTimeRange;
    }

    public void setCommitTimeRange(List<String> commitTimeRange) {
        this.commitTimeRange = commitTimeRange;
    }

    public int getBrotherTransactionCount() {
        return brotherTransactionCount;
    }

    public void setBrotherTransactionCount(int brotherTransactionCount) {
        this.brotherTransactionCount = brotherTransactionCount;
    }

    public String getRecoverUser() {
        return recoverUser;
    }

    public void setRecoverUser(String recoverUser) {
        this.recoverUser = recoverUser;
    }

    public String getRecoverUserName() {
        return recoverUserName;
    }

    public void setRecoverUserName(String recoverUserName) {
        this.recoverUserName = recoverUserName;
    }

    public Date getRecoverTime() {
        return recoverTime;
    }

    public void setRecoverTime(Date recoverTime) {
        this.recoverTime = recoverTime;
    }
}
