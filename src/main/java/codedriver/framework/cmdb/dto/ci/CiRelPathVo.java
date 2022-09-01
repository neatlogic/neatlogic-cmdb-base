/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.ci;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.Md5Util;
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
