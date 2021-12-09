package codedriver.framework.cmdb.dto.resourcecenter;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BaseEditorVo;
import codedriver.framework.restful.annotation.EntityField;

public class ResourceScriptVo extends BaseEditorVo {

    @EntityField(name = "脚本id", type = ApiParamType.LONG)
    private Long scriptId;
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    private Long resourceId;
    @EntityField(name = "url序列", type = ApiParamType.STRING)
    private String urlSequence;

    public ResourceScriptVo(Long scriptId) {
        this.scriptId = scriptId;
    }

    public Long getScriptId() {
        return scriptId;
    }

    public void setScriptId(Long scriptId) {
        this.scriptId = scriptId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public String getUrlSequence() {
        return urlSequence;
    }

    public void setUrlSequence(String urlSequence) {
        this.urlSequence = urlSequence;
    }
}
