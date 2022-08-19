package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.annotation.JSONField;

public class AccountProtocolVo extends BaseEditorVo {

    @EntityField(name = "协议id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "协议名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "协议端口", type = ApiParamType.INTEGER)
    private Integer port;

    @JSONField(serialize = false)
    private Integer excludeTagent = 0;// 查询时是否排除tagent

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

    public Integer getExcludeTagent() {
        return excludeTagent;
    }

    public void setExcludeTagent(Integer excludeTagent) {
        this.excludeTagent = excludeTagent;
    }
}
