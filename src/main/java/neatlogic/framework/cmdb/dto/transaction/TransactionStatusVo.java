/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.transaction;

import neatlogic.framework.cmdb.enums.TransactionStatus;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;

public class TransactionStatusVo extends BasePageVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "状态", type = ApiParamType.STRING, member = TransactionStatus.class)
    private String status = TransactionStatus.UNCOMMIT.getValue();
    @EntityField(name = "状态文本", type = ApiParamType.STRING)
    private String statusText;
    @EntityField(name = "异常", type = ApiParamType.STRING)
    private String error;

    public TransactionStatusVo(Long id, TransactionStatus status, String error) {
        this.id = id;
        this.status = status.getValue();
        this.error = error;
    }

    public TransactionStatusVo(Long id, TransactionStatus status) {
        this.id = id;
        this.status = status.getValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusText() {
        return statusText;
    }

    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
