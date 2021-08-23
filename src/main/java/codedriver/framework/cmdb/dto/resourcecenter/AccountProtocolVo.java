package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;

public class AccountProtocolVo extends BaseEditorVo {

    @EntityField(name = "协议id", type = ApiParamType.INTEGER)
    private Long id;
    @EntityField(name = "协议名称", type = ApiParamType.STRING)
    private String name;

    public Long getId() {
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
}
