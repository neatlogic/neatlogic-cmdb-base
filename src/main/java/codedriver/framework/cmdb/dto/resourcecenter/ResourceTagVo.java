/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

/**
 * @author linbq
 * @since 2021/6/22 18:37
 **/
public class ResourceTagVo {
    private Long resourceId;
    private Long tagId;

    public ResourceTagVo() {

    }

    public ResourceTagVo(Long resourceId, Long tagId) {
        this.resourceId = resourceId;
        this.tagId = tagId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
