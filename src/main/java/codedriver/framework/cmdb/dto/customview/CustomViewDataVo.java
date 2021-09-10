/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
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
