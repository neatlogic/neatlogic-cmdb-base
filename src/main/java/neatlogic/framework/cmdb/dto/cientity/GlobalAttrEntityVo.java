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

package neatlogic.framework.cmdb.dto.cientity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrItemVo;
import neatlogic.framework.cmdb.dto.transaction.GlobalAttrEntityTransactionVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class GlobalAttrEntityVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "common.uniquename", type = ApiParamType.STRING)
    private String attrName;
    @EntityField(name = "common.name", type = ApiParamType.STRING)
    private String attrLabel;
    @EntityField(name = "term.cmdb.transactionid", type = ApiParamType.LONG)
    private Long transactionId;

    @EntityField(name = "nfcdc.globalattrentityvo.entityfield.valuelist", type = ApiParamType.JSONARRAY)
    private List<GlobalAttrItemVo> valueList;
    @JSONField(serialize = false)
    private JSONArray valueObjList;

    public GlobalAttrEntityVo() {

    }

    public GlobalAttrEntityVo(GlobalAttrEntityTransactionVo globalAttrTransactionVo) {
        this.ciEntityId = globalAttrTransactionVo.getCiEntityId();
        this.attrId = globalAttrTransactionVo.getAttrId();
        this.attrName = globalAttrTransactionVo.getAttrName();
        this.attrLabel = globalAttrTransactionVo.getAttrLabel();
        //复制值，以免修改覆盖了原来对象
        this.valueList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(globalAttrTransactionVo.getValueList())) {
            this.valueList.addAll(globalAttrTransactionVo.getValueList());
        }
        this.transactionId = globalAttrTransactionVo.getTransactionId();
    }

    public JSONObject toJSONObject() {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("ciEntityId", this.ciEntityId);
        jsonObj.put("attrId", this.attrId);
        jsonObj.put("attrName", this.attrName);
        jsonObj.put("attrLabel", this.attrLabel);
        jsonObj.put("valueList", this.valueList);
        return jsonObj;
    }

    @JSONField(serialize = false)
    public JSONArray getValueObjList() {
        if (CollectionUtils.isEmpty(valueObjList) && CollectionUtils.isNotEmpty(valueList)) {
            valueObjList = new JSONArray();
            for (GlobalAttrItemVo item : valueList) {
                valueObjList.add(new JSONObject() {{
                    this.put("id", item.getId());
                    this.put("value", item.getValue());
                }});
            }
        }
        return valueObjList;
    }

    public void setValueObjList(JSONArray valueObjList) {
        this.valueObjList = valueObjList;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrLabel() {
        return attrLabel;
    }

    public void setAttrLabel(String attrLabel) {
        this.attrLabel = attrLabel;
    }

    public List<GlobalAttrItemVo> getValueList() {
        return valueList;
    }

    public void setValueList(List<GlobalAttrItemVo> valueList) {
        this.valueList = valueList;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
