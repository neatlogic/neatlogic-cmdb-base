/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.cmdb.dto.resourcecenter.config;

public class ResourceEntityRelLinkVo {
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
