/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.enums.RelDirectionType;
import neatlogic.framework.cmdb.enums.resourcecenter.JoinType;
import com.alibaba.fastjson.annotation.JSONField;

import java.util.Objects;

public class ResourceEntityJoinVo {
    private final JoinType joinType;
    private String field;
    private String ciName;
    private String direction = RelDirectionType.FROM.getValue();
    @JSONField(serialize = false)
    private CiVo ci;
    private String joinAttrName;
    public ResourceEntityJoinVo(JoinType _joinType) {
        joinType = _joinType;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceEntityJoinVo that = (ResourceEntityJoinVo) o;
        return joinType == that.joinType && Objects.equals(ciName, that.ciName) && direction.equals(that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(joinType, ciName, direction);
    }

    public JoinType getJoinType() {
        return joinType;
    }


    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public CiVo getCi() {
        return ci;
    }

    public void setCi(CiVo ci) {
        this.ci = ci;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getJoinAttrName() {
        return joinAttrName;
    }

    public void setJoinAttrName(String joinAttrName) {
        this.joinAttrName = joinAttrName;
    }
}
