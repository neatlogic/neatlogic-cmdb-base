package neatlogic.framework.cmdb.dto.resourcecenter;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BaseEditorVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;

public class AccountProtocolVo extends BaseEditorVo {

    @EntityField(name = "协议id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "协议名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "协议端口", type = ApiParamType.INTEGER)
    private Integer port;

    @JSONField(serialize = false)
    private Integer isExcludeTagent = 0;// 查询时是否排除tagent

    public AccountProtocolVo() {

    }

    public AccountProtocolVo(String name) {
        this.name = name;
    }

    public AccountProtocolVo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public synchronized Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getIsExcludeTagent() {
        return isExcludeTagent;
    }

    public void setIsExcludeTagent(Integer isExcludeTagent) {
        this.isExcludeTagent = isExcludeTagent;
    }
}
