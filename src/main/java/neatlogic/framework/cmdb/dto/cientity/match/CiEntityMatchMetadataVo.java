package neatlogic.framework.cmdb.dto.cientity.match;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import java.util.List;

/** 目标模型及本次校验的最新属性元数据。 */
public class CiEntityMatchMetadataVo {
    private Long ciId;
    private String ciName;
    private String ciLabel;
    private Integer isAbstract;
    private List<AttrVo> attrList;
    public Long getCiId() { return ciId; }
    public void setCiId(Long ciId) { this.ciId = ciId; }
    public String getCiName() { return ciName; }
    public void setCiName(String ciName) { this.ciName = ciName; }
    public String getCiLabel() { return ciLabel; }
    public void setCiLabel(String ciLabel) { this.ciLabel = ciLabel; }
    public Integer getIsAbstract() { return isAbstract; }
    public void setIsAbstract(Integer isAbstract) { this.isAbstract = isAbstract; }
    public List<AttrVo> getAttrList() { return attrList; }
    public void setAttrList(List<AttrVo> attrList) { this.attrList = attrList; }
}
