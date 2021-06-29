/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.customview;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.common.dto.BasePageVo;
import codedriver.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomViewDataGroupVo extends BasePageVo implements Serializable {
    @EntityField(name = "属性uuid", type = ApiParamType.STRING)
    private String attrUuid;
    @EntityField(name = "属性别名", type = ApiParamType.STRING)
    private String attrAlias;
    @EntityField(name = "属性值", type = ApiParamType.STRING)
    private String value;
    @EntityField(name = "属性值hash", type = ApiParamType.STRING)
    private String valueHash;
    @EntityField(name = "条目数量", type = ApiParamType.STRING)
    private int count;
    @EntityField(name = "值过滤列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewValueFilterVo> filterList;

    public void addValueFilter(CustomViewValueFilterVo filterVo) {
        if (CollectionUtils.isEmpty(filterList)) {
            filterList = new ArrayList<>();
        }
        filterList.add(filterVo);
    }

    public String getValueHash() {
        return valueHash;
    }

    public void setValueHash(String valueHash) {
        this.valueHash = valueHash;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getAttrUuid() {
        return attrUuid;
    }

    public void setAttrUuid(String attrUuid) {
        this.attrUuid = attrUuid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAttrAlias() {
        return attrAlias;
    }

    public void setAttrAlias(String attrAlias) {
        this.attrAlias = attrAlias;
    }

    public List<CustomViewValueFilterVo> getFilterList() {
        return filterList;
    }

    public void setFilterList(List<CustomViewValueFilterVo> filterList) {
        this.filterList = filterList;
    }
}
