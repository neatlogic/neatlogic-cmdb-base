package codedriver.framework.cmdb.dto.cientity;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.Date;

/**
 * @author longrf
 * @date 2022/2/22 5:07 下午
 */
public class CiEntityInspectVo extends BasePageVo {

    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "作业id", type = ApiParamType.LONG)
    private Long jobId;
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "巡检时间", type = ApiParamType.LONG)
    private Date inspectTime;
    @EntityField(name = "巡检状态", type = ApiParamType.STRING)
    private String inspectStatus;

    public CiEntityInspectVo() {

    }

    public CiEntityInspectVo(JSONObject paramObj) {
        this.jobId = paramObj.getLong("jobId");
        this.ciEntityId = paramObj.getLong("ciEntityId");
        this.inspectTime = new Date(paramObj.getLong("inspectTime"));
        this.inspectStatus = paramObj.getString("inspectStatus");
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public Date getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(Date inspectTime) {
        this.inspectTime = inspectTime;
    }

    public String getInspectStatus() {
        return inspectStatus;
    }

    public void setInspectStatus(String inspectStatus) {
        this.inspectStatus = inspectStatus;
    }
}
