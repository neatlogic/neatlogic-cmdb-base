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

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class CustomViewCiVo implements Serializable {
    @EntityField(name = "uuid", type = ApiParamType.STRING)
    private String uuid;
    @EntityField(name = "视图id", type = ApiParamType.LONG)
    private Long customViewId;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "是否隐藏", type = ApiParamType.INTEGER)
    private Integer isHidden = 0;
    @EntityField(name = "是否起始模型", type = ApiParamType.INTEGER)
    private Integer isStart = 0;
    @EntityField(name = "属性列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewAttrVo> attrList;
    @EntityField(name = "关系属性列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewRelVo> relList;
    @EntityField(name = "内部属性列表", type = ApiParamType.JSONARRAY)
    private List<CustomViewConstAttrVo> constAttrList;
    @JSONField(serialize = false)
    private CiVo ciVo;
    @EntityField(name = "配置项列表", type = ApiParamType.JSONARRAY)
    private List<JSONObject> ciEntityList;
    @EntityField(name = "别名", type = ApiParamType.STRING)
    private String alias;
    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String name;

    public CustomViewCiVo() {

    }

    public CustomViewCiVo(JSONObject jsonObj) {
        JSONObject conf = jsonObj.getJSONObject("config");
        if (MapUtils.isNotEmpty(conf)) {
            this.ciId = conf.getLong("ciId");
            this.sort = conf.getInteger("index");
            this.isHidden = conf.getIntValue("isHidden");
            this.alias = conf.getString("alias");
            this.name = conf.getString("name");
            this.isStart = conf.getIntValue("isStart");
        }
        this.uuid = jsonObj.getString("uuid");
    }

    public List<JSONObject> getCiEntityList() {
        return ciEntityList;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public void addCiEntity(Long ciEntityId, String ciEntityName) {
        if (ciEntityId != null) {
            if (this.ciEntityList == null) {
                this.ciEntityList = new ArrayList<>();
            }
            if (this.ciEntityList.stream().noneMatch(cientity -> cientity.getLong("id").equals(ciEntityId))) {
                this.ciEntityList.add(new JSONObject() {{
                    this.put("id", ciEntityId);
                    this.put("name", ciEntityName);
                }});
            }
        }
    }

    public CustomViewAttrVo getAttrByUuid(String uuid) {
        if (CollectionUtils.isNotEmpty(attrList)) {
            Optional<CustomViewAttrVo> op = attrList.stream().filter(attr -> attr.getUuid().equalsIgnoreCase(uuid)).findFirst();
            if (op.isPresent()) {
                return op.get();
            }
        }
        return null;
    }

    public CustomViewRelVo getRelByUuid(String uuid) {
        if (CollectionUtils.isNotEmpty(relList)) {
            Optional<CustomViewRelVo> op = relList.stream().filter(rel -> rel.getUuid().equalsIgnoreCase(uuid)).findFirst();
            if (op.isPresent()) {
                return op.get();
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getCustomViewId() {
        return customViewId;
    }

    public void setCustomViewId(Long customViewId) {
        this.customViewId = customViewId;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

    public List<CustomViewAttrVo> getAttrList() {
        if (CollectionUtils.isNotEmpty(attrList)) {
            attrList.sort(Comparator.comparing(CustomViewAttrVo::getSort));
        }
        return attrList;
    }

    public void setAttrList(List<CustomViewAttrVo> attrList) {
        this.attrList = attrList;
    }

    public List<CustomViewConstAttrVo> getConstAttrList() {
        return constAttrList;
    }

    public void setConstAttrList(List<CustomViewConstAttrVo> constAttrList) {
        this.constAttrList = constAttrList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public CiVo getCiVo() {
        return ciVo;
    }

    public void setCiVo(CiVo ciVo) {
        this.ciVo = ciVo;
    }

    public List<CustomViewRelVo> getRelList() {
        return relList;
    }

    public void setRelList(List<CustomViewRelVo> relList) {
        this.relList = relList;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
