/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.cientity;

public class RelCiEntityFilterVo {
    private Long relId;
    private String direction;
    private Long ciEntityId;


    public RelCiEntityFilterVo(Long relId, Long ciEntityId, String direction) {
        this.relId = relId;
        this.ciEntityId = ciEntityId;
        this.direction = direction;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }
}
