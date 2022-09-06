/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.ci;

import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.Objects;

/*
配置视图的关系路径数据，只会记录当前模型和关系的关键信息，由于只会沿着一个防线追溯，因此无需保存方向信息
 */
public class CiRelVo {
    private Long ciId;
    private String ciName;
    private String ciLabel;
    private Long relId;
    private String relName;
    private String relLabel;
    @EntityField(name = "关系方向", type = ApiParamType.ENUM, member = RelDirectionType.class)
    private String direction;

    public CiRelVo() {

    }


    public CiRelVo(Long _ciId) {
        ciId = _ciId;
    }

    public CiRelVo(Long _ciId, Long _relId) {
        ciId = _ciId;
        relId = _relId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CiRelVo ciRelVo = (CiRelVo) o;
        return ciId.equals(ciRelVo.ciId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciId);
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public String getCiLabel() {
        return ciLabel;
    }

    public void setCiLabel(String ciLabel) {
        this.ciLabel = ciLabel;
    }

    public String getRelLabel() {
        return relLabel;
    }

    public void setRelLabel(String relLabel) {
        this.relLabel = relLabel;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
