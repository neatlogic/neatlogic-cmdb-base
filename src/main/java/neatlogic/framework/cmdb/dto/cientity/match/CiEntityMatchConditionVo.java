package neatlogic.framework.cmdb.dto.cientity.match;

import com.alibaba.fastjson.JSONArray;

/** 属性条件仅携带属性编号和原始来源值，不接收表名或查询表达式。 */
public class CiEntityMatchConditionVo {
    private Long attrId;
    private JSONArray valueList;
    private String expectedType;
    public Long getAttrId() { return attrId; }
    public void setAttrId(Long attrId) { this.attrId = attrId; }
    public JSONArray getValueList() { return valueList; }
    public void setValueList(JSONArray valueList) { this.valueList = valueList; }
    public String getExpectedType() { return expectedType; }
    public void setExpectedType(String expectedType) { this.expectedType = expectedType; }
}
