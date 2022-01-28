/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.sync;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
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
