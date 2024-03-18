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

package neatlogic.framework.cmdb.dto.transaction;

import neatlogic.framework.cmdb.dto.cientity.GlobalAttrEntityVo;
import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrItemVo;
import neatlogic.framework.cmdb.enums.SaveModeType;
import neatlogic.framework.cmdb.enums.TransactionActionType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalAttrEntityTransactionVo implements Serializable {
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "属性id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "属性名称", type = ApiParamType.STRING)
    private String attrName;
    @EntityField(name = "属性标签", type = ApiParamType.STRING)
    private String attrLabel;
    @EntityField(name = "事务id", type = ApiParamType.LONG)
    private Long transactionId;
    @EntityField(name = "值数据列表", type = ApiParamType.JSONARRAY)
    private List<GlobalAttrItemVo> valueList;
    @EntityField(name = "保存模式", type = ApiParamType.ENUM, member = SaveModeType.class)
    private String saveMode = SaveModeType.REPLACE.getValue();
    @EntityField(name = "操作", type = ApiParamType.ENUM, member = TransactionActionType.class)
    private String action;

    public GlobalAttrEntityTransactionVo() {

    }

    public GlobalAttrEntityTransactionVo(GlobalAttrEntityVo attrEntityVo) {
        ciEntityId = attrEntityVo.getCiEntityId();
        attrId = attrEntityVo.getAttrId();
        attrName = attrEntityVo.getAttrName();
        valueList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(attrEntityVo.getValueList())) {
            valueList.addAll(attrEntityVo.getValueList());
        }
        transactionId = attrEntityVo.getTransactionId();
    }

    @Override
    public int hashCode() {
        String key = "";
        if (getAttrId() != null) {
            key += getAttrId() + "_";
        }
        if (CollectionUtils.isNotEmpty(getValueList())) {
            key += getValueList().size() + "_";
            // 根据内容排序生成新数组
            List<String> sortedList = getValueList().stream().map(Object::toString).sorted().collect(Collectors.toList());
            key += String.join(",", sortedList);
        }
        return key.hashCode();
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof GlobalAttrEntityTransactionVo)) {
            return false;
        }
        final GlobalAttrEntityTransactionVo attr = (GlobalAttrEntityTransactionVo) other;
        try {
            if (getAttrId().equals(attr.getAttrId())) {
                if (CollectionUtils.isNotEmpty(getValueList()) && CollectionUtils.isNotEmpty(attr.getValueList())) {
                    if (this.getValueList().size() == attr.getValueList().size()) {
                        for (int i = 0; i < this.getValueList().size(); i++) {
                            boolean isExists = false;
                            GlobalAttrItemVo v = this.getValueList().get(i);
                            for (int j = 0; j < attr.getValueList().size(); j++) {
                                GlobalAttrItemVo v2 = attr.getValueList().get(j);
                                if (v.equals(v2)) {
                                    isExists = true;
                                    break;
                                }
                            }
                            if (!isExists) {
                                return false;
                            }
                        }
                        return true;
                    } else {
                        return false;
                    }
                } else return CollectionUtils.isEmpty(this.getValueList())
                        && CollectionUtils.isEmpty(attr.getValueList());
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public Long getCiEntityId() {
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }


    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getSaveMode() {
        if (StringUtils.isBlank(saveMode)) {
            return SaveModeType.REPLACE.getValue();
        }
        return saveMode;
    }

    public void setSaveMode(String saveMode) {
        this.saveMode = saveMode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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


}
