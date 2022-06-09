/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.discovery;

public class DiscoverConfCombopVo {
    private String confId;
    private Long combopId;

    public DiscoverConfCombopVo() {
    }

    public DiscoverConfCombopVo(String _confId, Long _combopId) {
        this.confId = _confId;
        this.combopId = _combopId;
    }

    public String getConfId() {
        return confId;
    }

    public void setConfId(String confId) {
        this.confId = confId;
    }

    public Long getCombopId() {
        return combopId;
    }

    public void setCombopId(Long combopId) {
        this.combopId = combopId;
    }
}
