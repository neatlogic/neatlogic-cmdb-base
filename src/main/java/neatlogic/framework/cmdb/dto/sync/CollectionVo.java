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

package neatlogic.framework.cmdb.dto.sync;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
    @EntityField(name = "集合名称", type = ApiParamType.STRING)
    private String collection;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String label;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "属性", type = ApiParamType.JSONARRAY)
    private JSONArray fields;
    @EntityField(name = "过滤条件", type = ApiParamType.JSONOBJECT)
    private JSONObject filter;
    @EntityField(name = "根节点，用于显示数据时从该节点开始截取数据", type = ApiParamType.STRING)
    private String docroot;
    @EntityField(name = "集合显示名", type = ApiParamType.STRING)
    private String collection_label;
    @EntityField(name = "数据量", type = ApiParamType.INTEGER)
    private long dataCount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionVo that = (CollectionVo) o;
        return name.equals(that.name);
    }

    @JSONField(serialize = false)
    public Criteria getFilterCriteria() {
        Criteria c = new Criteria();
        List<Criteria> filterCriteriaList = new ArrayList<>();
        if (MapUtils.isNotEmpty(this.getFilter())) {
            for (String key : this.getFilter().keySet()) {
                filterCriteriaList.add(Criteria.where((StringUtils.isNotBlank(this.getDocroot()) ? this.getDocroot() + "." : "") + key).is(this.getFilter().getString(key)));
            }
            c.andOperator(filterCriteriaList);
        }
        return c;
    }

    public long getDataCount() {
        return dataCount;
    }

    public void setDataCount(long dataCount) {
        this.dataCount = dataCount;
    }

    public String getCollection_label() {
        return collection_label;
    }

    public void setCollection_label(String collection_label) {
        this.collection_label = collection_label;
    }

    public String getDocroot() {
        return docroot;
    }

    public void setDocroot(String docroot) {
        this.docroot = docroot;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public JSONArray getFields() {
        return fields;
    }

    public void setFields(JSONArray fields) {
        this.fields = fields;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getFilter() {
        return filter;
    }

    public void setFilter(JSONObject filter) {
        this.filter = filter;
    }
}
