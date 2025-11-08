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

public class ResourceEntityRelLinkVo implements Serializable {
    private String leftCi;

    private String rightCi;

    private String leftCiAlias;

    private String rightCiAlias;

    private String direction;

    private String rightUuid;

    public String getLeftCi() {
        return leftCi;
    }

    public void setLeftCi(String leftCi) {
        this.leftCi = leftCi;
    }

    public String getRightCi() {
        return rightCi;
    }

    public void setRightCi(String rightCi) {
        this.rightCi = rightCi;
    }

    public String getLeftCiAlias() {
        return leftCiAlias;
    }

    public void setLeftCiAlias(String leftCiAlias) {
        this.leftCiAlias = leftCiAlias;
    }

    public String getRightCiAlias() {
        return rightCiAlias;
    }

    public void setRightCiAlias(String rightCiAlias) {
        this.rightCiAlias = rightCiAlias;
    }

    public String getRightUuid() {
        return rightUuid;
    }

    public void setRightUuid(String rightUuid) {
        this.rightUuid = rightUuid;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
