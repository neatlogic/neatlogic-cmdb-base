/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.dto.customview;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
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
