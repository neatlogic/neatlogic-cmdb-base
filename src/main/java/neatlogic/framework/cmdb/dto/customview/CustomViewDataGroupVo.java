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

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CustomViewDataGroupVo extends BasePageVo {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
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
