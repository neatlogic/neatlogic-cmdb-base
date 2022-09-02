/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

public class CiCustomViewVo {

    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "关系方向", type = ApiParamType.ENUM, member = RelDirectionType.class)
    private String direction;
    @EntityField(name = "关系路径唯一标识，由关系路径上所有模型id组成的字符串做md5生成", type = ApiParamType.STRING)
    private String pathHash;

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(Long customViewId) {
        this.customViewId = customViewId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPathHash() {
        return pathHash;
    }

    public void setPathHash(String pathHash) {
        this.pathHash = pathHash;
    }
}
