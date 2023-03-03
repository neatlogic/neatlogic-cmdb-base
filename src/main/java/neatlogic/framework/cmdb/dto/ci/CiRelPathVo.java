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

package neatlogic.framework.cmdb.dto.ci;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.Md5Util;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CiRelPathVo {
    @EntityField(name = "路径唯一标识", type = ApiParamType.STRING)
    private String hash;
    @EntityField(name = "路径关系列表", type = ApiParamType.JSONARRAY)
    private List<CiRelVo> ciRelList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiRelPathVo that = (CiRelPathVo) o;
        return this.getHash().equals(that.getHash());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getHash());
    }

    public String getHash() {
        if (StringUtils.isBlank(hash)) {
            if (CollectionUtils.isNotEmpty(ciRelList)) {
                hash = Md5Util.encryptMD5(ciRelList.stream().map(d -> d.getCiId().toString()).collect(Collectors.joining(",")));
            }
        }
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public List<CiRelVo> getCiRelList() {
        return ciRelList;
    }

    public void setCiRelList(List<CiRelVo> ciRelList) {
        this.ciRelList = ciRelList;
    }
}
