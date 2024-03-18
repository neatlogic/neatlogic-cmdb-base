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

package neatlogic.framework.cmdb.dto.sync;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionVo implements Serializable {
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
