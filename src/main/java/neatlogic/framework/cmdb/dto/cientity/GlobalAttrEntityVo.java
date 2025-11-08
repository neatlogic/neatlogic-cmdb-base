/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.dto.cientity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrItemVo;
import neatlogic.framework.cmdb.dto.transaction.GlobalAttrEntityTransactionVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GlobalAttrEntityVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
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
