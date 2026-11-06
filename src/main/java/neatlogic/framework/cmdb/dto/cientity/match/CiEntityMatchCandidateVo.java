package neatlogic.framework.cmdb.dto.cientity.match;

/** 轻量候选中的模型编号始终为配置项实际所属模型。 */
public class CiEntityMatchCandidateVo {
    private Long id;
    private Long ciId;
    private String name;
    private String ciName;
    private String ciLabel;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCiId() { return ciId; }
    public void setCiId(Long ciId) { this.ciId = ciId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCiName() { return ciName; }
    public void setCiName(String ciName) { this.ciName = ciName; }
    public String getCiLabel() { return ciLabel; }
    public void setCiLabel(String ciLabel) { this.ciLabel = ciLabel; }
}
