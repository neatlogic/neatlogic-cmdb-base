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

import neatlogic.framework.cmdb.attrvaluehandler.core.AttrValueHandlerFactory;
import neatlogic.framework.cmdb.attrvaluehandler.core.IAttrValueHandler;
import neatlogic.framework.cmdb.dto.cientity.AttrEntityVo;
import neatlogic.framework.cmdb.enums.SaveModeType;
import neatlogic.framework.cmdb.enums.TransactionActionType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.HtmlUtil;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class AttrEntityTransactionVo implements Serializable {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;// 由于需要在SQL批量写入，所以这里使用数据库自增id
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "属性id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "属性名称", type = ApiParamType.STRING)
    private String attrName;
    @EntityField(name = "属性标签", type = ApiParamType.STRING)
    private String attrLabel;
    @EntityField(name = "属性类型", type = ApiParamType.STRING)
    private String attrType;
    @EntityField(name = "事务id", type = ApiParamType.LONG)
    private Long transactionId;
    @EntityField(name = "值数据列表", type = ApiParamType.JSONARRAY)
    private JSONArray valueList;
    @EntityField(name = "值hash列表", type = ApiParamType.JSONARRAY)
    private List<String> valueHashList;
    @EntityField(name = "保存模式", type = ApiParamType.ENUM, member = SaveModeType.class)
    private String saveMode = SaveModeType.REPLACE.getValue();
    @EntityField(name = "操作", type = ApiParamType.ENUM, member = TransactionActionType.class)
    private String action;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "目标模型id", type = ApiParamType.LONG)
    private Long targetCiId;

    public AttrEntityTransactionVo() {

    }

    public AttrEntityTransactionVo(AttrEntityVo attrEntityVo) {
        ciEntityId = attrEntityVo.getCiEntityId();
        attrId = attrEntityVo.getAttrId();
        attrType = attrEntityVo.getAttrType();
        attrName = attrEntityVo.getAttrName();
        //复制值列表，避免修改时覆盖
        valueList = new JSONArray();
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


    public String getAttrType() {
        return attrType;
    }

    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof AttrEntityTransactionVo)) {
            return false;
        }
        final AttrEntityTransactionVo attr = (AttrEntityTransactionVo) other;
        try {
            if (getAttrId().equals(attr.getAttrId())) {
                if (CollectionUtils.isNotEmpty(getValueList()) && CollectionUtils.isNotEmpty(attr.getValueList())) {
                    if (this.getValueList().size() == attr.getValueList().size()) {
                        for (int i = 0; i < this.getValueList().size(); i++) {
                            boolean isExists = false;
                            String v = this.getValueList().getString(i);
                            LEVEL2:
                            for (int j = 0; j < attr.getValueList().size(); j++) {
                                String v2 = attr.getValueList().getString(j);
                                switch (this.getAttrType()) {
                                    case "number":
                                        try {
                                            if (Double.parseDouble(v) == Double.parseDouble(v2)) {
                                                isExists = true;
                                                break;
                                            }
                                        } catch (Exception ignored) {

                                        }
                                        break;
                                    case "date": {
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                        try {
                                            if (sdf.parse(v).equals(sdf.parse(v2))) {
                                                isExists = true;
                                                break;
                                            }
                                        } catch (Exception ignored) {

                                        }
                                        break;
                                    }
                                    case "datetime": {
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                        try {
                                            if (sdf.parse(v).equals(sdf.parse(v2))) {
                                                isExists = true;
                                                break;
                                            }
                                        } catch (Exception ignored) {

                                        }
                                        break;
                                    }
                                    case "time": {
                                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                                        try {
                                            if (sdf.parse(v).equals(sdf.parse(v2))) {
                                                isExists = true;
                                                break;
                                            }
                                        } catch (Exception ignored) {

                                        }
                                        break;
                                    }
                                    default:
                                        if (v.equalsIgnoreCase(v2)) {
                                            isExists = true;
                                            break LEVEL2;
                                        } else if (HtmlUtil.encodeHtml(v).equalsIgnoreCase(v2)) {
                                            isExists = true;
                                            break LEVEL2;
                                        }
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
                } else return CollectionUtils.isEmpty(this.getValueList(true))
                        && CollectionUtils.isEmpty(attr.getValueList(true));
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }

    public void addValue(String v) {
        if (valueList == null) {
            valueList = new JSONArray();
        }
        if (!valueList.contains(v)) {
            valueList.add(v);
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public JSONArray getValueList() {
        return valueList;
    }

    public JSONArray getValueList(boolean clearBlank) {
        if (CollectionUtils.isNotEmpty(valueList)) {
            JSONArray newValueList = new JSONArray();
            for (int i = 0; i < valueList.size(); i++) {
                if (StringUtils.isNotBlank(valueList.getString(i))) {
                    newValueList.add(valueList.get(i));
                }
            }
            return newValueList;
        }
        return valueList;

    }

    public String getValue() {
        if (CollectionUtils.isNotEmpty(valueList)) {
            if (valueList.size() == 1) {
                return valueList.getString(0);
            } else {
                return valueList.toString();
            }
        }
        return null;
    }

    public void setValueList(JSONArray _valueList) {
        this.valueList = _valueList;
    }

    public List<String> getValueHashList() {
        return valueHashList;
    }

    public void setValueHashList(List<String> valueHashList) {
        this.valueHashList = valueHashList;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getTargetCiId() {
        return targetCiId;
    }

    public void setTargetCiId(Long targetCiId) {
        this.targetCiId = targetCiId;
    }

    public Boolean isNeedTargetCi() {
        if (StringUtils.isNotBlank(this.attrType)) {
            IAttrValueHandler handler = AttrValueHandlerFactory.getHandler(this.attrType);
            return handler.isNeedTargetCi();
        }
        return null;
    }
}
