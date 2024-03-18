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

package neatlogic.framework.cmdb.dto.customview;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CustomViewDataVo implements Serializable {
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "视图名称", type = ApiParamType.STRING)
    private String customViewName;
    @EntityField(name = "属性列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewAttrVo> attrList;
    @JSONField(serialize = false)
    private List<Map<String, Object>> dataList;
    @EntityField(name = "值列表", type = ApiParamType.JSONARRAY)
    private List<Map<String, Object>> valueList;

    public Long getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(Long customViewId) {
        this.customViewId = customViewId;
    }

    public String getCustomViewName() {
        return customViewName;
    }

    public void setCustomViewName(String customViewName) {
        this.customViewName = customViewName;
    }

    public List<CustomViewAttrVo> getAttrList() {
        return attrList;
    }

    public void setAttrList(List<CustomViewAttrVo> attrList) {
        this.attrList = attrList;
    }


    public void setDataList(List<Map<String, Object>> dataList) {
        this.dataList = dataList;
    }


    public List<Map<String, Object>> getValueList() {
        /*if (CollectionUtils.isEmpty(valueList) && CollectionUtils.isNotEmpty(dataList) && CollectionUtils.isNotEmpty(attrList)) {
            valueList = new ArrayList<>();
            for (Map<String, Object> data : dataList) {
                Map<String, Object> value = new HashMap<>();
                value.put("id", data.get("id"));
                for (CustomViewAttrVo viewAttrVo : attrList) {
                    AttrVo attrVo = viewAttrVo.getAttrVo();
                    JSONArray actualValueList = AttrValueHandlerFactory.getHandler(attrVo.getType()).getActualValueList(attrVo, new JSONArray() {{
                        this.add(data.get(viewAttrVo.getUuid()));
                    }});
                    if (CollectionUtils.isNotEmpty(actualValueList)) {
                        value.put(viewAttrVo.getUuid(), actualValueList);
                    }
                }
                valueList.add(value);
            }
        }*/
        return dataList;
    }

}
