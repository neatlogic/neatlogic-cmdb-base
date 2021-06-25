/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.attrexpression;

import codedriver.framework.asynchronization.threadlocal.TenantContext;
import codedriver.framework.asynchronization.threadlocal.UserContext;
import codedriver.framework.cmdb.dto.cientity.AttrEntityVo;
import codedriver.framework.cmdb.dto.cientity.CiEntityVo;
import codedriver.framework.common.config.Config;
import codedriver.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RebuildAuditVo {
    private Long id;
    private Long ciId;
    private Long ciEntityId;
    private Long ciEntityIdStart;
    private String attrIds;
    private CiEntityVo ciEntityVo;
    private Integer serverId;
    protected UserContext userContext;
    protected TenantContext tenantContext;

    public CiEntityVo getCiEntityVo() {
        return ciEntityVo;
    }

    public void setCiEntityVo(CiEntityVo ciEntityVo) {
        this.ciEntityVo = ciEntityVo;
    }

    public RebuildAuditVo() {
        userContext = UserContext.get();
        tenantContext = TenantContext.get();
    }

    public RebuildAuditVo(CiEntityVo _ciEntityVo) {
        this.ciId = _ciEntityVo.getCiId();
        this.ciEntityId = _ciEntityVo.getId();
        this.ciEntityVo = _ciEntityVo;
        List<AttrEntityVo> attrList = _ciEntityVo.getAttrEntityList();
        if (CollectionUtils.isNotEmpty(attrList)) {
            this.attrIds = attrList.stream().map(attr -> attr.getAttrId().toString()).collect(Collectors.joining(","));
        }
        userContext = UserContext.get();
        tenantContext = TenantContext.get();
    }

    public UserContext getUserContext() {
        return userContext;
    }

    public TenantContext getTenantContext() {
        return tenantContext;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
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

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getCiEntityIdStart() {
        return ciEntityIdStart;
    }

    public void setCiEntityIdStart(Long ciEntityIdStart) {
        this.ciEntityIdStart = ciEntityIdStart;
    }

    public String getAttrIds() {
        return attrIds;
    }

    public void setAttrIds(String attrIds) {
        this.attrIds = attrIds;
    }

    public Integer getServerId() {
        return Config.SCHEDULE_SERVER_ID;
    }

}
