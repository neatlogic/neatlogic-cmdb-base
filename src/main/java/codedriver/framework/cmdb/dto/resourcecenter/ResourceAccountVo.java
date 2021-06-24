/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter;

/**
 * @author linbq
 * @since 2021/6/22 18:37
 **/
public class ResourceAccountVo {
    private Long resourceId;
    private Long accountId;

    public ResourceAccountVo() {

    }

    public ResourceAccountVo(Long resourceId, Long accountId) {
        this.resourceId = resourceId;
        this.accountId = accountId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
