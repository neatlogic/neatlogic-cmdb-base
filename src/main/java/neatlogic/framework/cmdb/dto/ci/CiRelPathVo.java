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
