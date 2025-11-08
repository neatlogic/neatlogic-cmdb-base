/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import java.io.Serializable;

public class ResourceEntityLeftJoinVo implements Serializable {

    private String fromCi;

    private String fromCiAlias;

    private Long fromCiId;

    private String toCi;

    private String toCiAlias;

    private Long toCiId;

    private String direction;

    public String getFromCi() {
        return fromCi;
    }

    public void setFromCi(String fromCi) {
        this.fromCi = fromCi;
    }

    public String getToCi() {
        return toCi;
    }

    public void setToCi(String toCi) {
        this.toCi = toCi;
    }

    public Long getFromCiId() {
        return fromCiId;
    }

    public void setFromCiId(Long fromCiId) {
        this.fromCiId = fromCiId;
    }

    public Long getToCiId() {
        return toCiId;
    }

    public void setToCiId(Long toCiId) {
        this.toCiId = toCiId;
    }

    public String getFromCiAlias() {
        return fromCiAlias;
    }

    public void setFromCiAlias(String fromCiAlias) {
        this.fromCiAlias = fromCiAlias;
    }

    public String getToCiAlias() {
        return toCiAlias;
    }

    public void setToCiAlias(String toCiAlias) {
        this.toCiAlias = toCiAlias;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
