/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.dto.attrexpression;

import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.asynchronization.threadlocal.UserContext;
import neatlogic.framework.cmdb.dto.cientity.AttrEntityVo;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.common.config.Config;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RebuildAuditVo {
    public enum Type {
        INVOKE("invoke"),
        INVOKED("invoked");

        private final String status;

        Type(String _status) {
            this.status = _status;
        }

        public String getValue() {
            return status;
        }
    }

    private Long id;
    private Long ciId;
    private Long ciEntityId;
    private String type;
    private Long ciEntityIdStart;
    private String attrIds;
    private List<Long> attrIdList;
    private Integer serverId;
    protected UserContext userContext;
    protected TenantContext tenantContext;


    public RebuildAuditVo() {
        userContext = UserContext.get();
        tenantContext = TenantContext.get();
    }

    public RebuildAuditVo(CiEntityVo _ciEntityVo, Type type) {
        this.ciId = _ciEntityVo.getCiId();
        this.ciEntityId = _ciEntityVo.getId();
        List<AttrEntityVo> attrList = _ciEntityVo.getAttrEntityList();
        if (CollectionUtils.isNotEmpty(attrList)) {
            this.attrIdList = attrList.stream().map(AttrEntityVo::getAttrId).collect(Collectors.toList());
            this.attrIds = this.attrIdList.stream().map(Object::toString).collect(Collectors.joining(","));
        }
        this.type = type.getValue();
        userContext = UserContext.get();
        tenantContext = TenantContext.get();
    }

    public List<Long> getAttrIdList() {
        return attrIdList;
    }

    public void setAttrIdList(List<Long> attrIdList) {
        this.attrIdList = attrIdList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
