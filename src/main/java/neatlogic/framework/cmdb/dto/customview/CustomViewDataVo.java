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

package neatlogic.framework.cmdb.dto.customview;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class CustomViewDataVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
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
