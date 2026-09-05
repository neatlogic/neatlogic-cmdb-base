/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x - 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.dto.cientity;

import neatlogic.framework.util.SnowflakeUtil;

import java.io.Serializable;

public class AttrInvokeVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long ciEntityId;
    private Long attrId;
    private String type;
    private Long invokeId;

    public AttrInvokeVo() {
    }

    public AttrInvokeVo(Long ciEntityId, Long attrId, String type, Long invokeId) {
        this.id = SnowflakeUtil.uniqueLong();
        this.ciEntityId = ciEntityId;
        this.attrId = attrId;
        this.type = type;
        this.invokeId = invokeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(Long invokeId) {
        this.invokeId = invokeId;
    }
}
