package neatlogic.framework.cmdb.dto.resourcecenter;

/**
 * 资源管理-帐号管理列表的标签
 */
public class AccountTagVo {
    private Long accountId;
    private Long tagId;

    public AccountTagVo() {
    }

    public AccountTagVo(Long accountId, Long tagId) {
        this.accountId = accountId;
        this.tagId = tagId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
