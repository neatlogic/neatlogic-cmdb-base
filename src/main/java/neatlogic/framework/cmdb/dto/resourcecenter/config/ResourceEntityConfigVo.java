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

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.ci.CiVo;

import java.io.Serializable;
import java.util.List;

public class ResourceEntityConfigVo implements Serializable {

    private String mainCi;
    @JSONField(serialize = false)
    private CiVo mainCiVo;

    private ResourceEntityRelNodeVo relNode;

    private List<ResourceEntityRelLinkVo> relLinkList;

    List<ResourceEntityLeftJoinVo> leftJoinList;

    private List<ResourceEntityFieldMappingVo> fieldMappingList;

    private String sceneTemplateName;

    List<String> selectItemFieldNameList;

    List<String> filterItemFieldNameList;

    public String getMainCi() {
        return mainCi;
    }

    public void setMainCi(String mainCi) {
        this.mainCi = mainCi;
    }

    public CiVo getMainCiVo() {
        return mainCiVo;
    }

    public void setMainCiVo(CiVo mainCiVo) {
        this.mainCiVo = mainCiVo;
    }

    public ResourceEntityRelNodeVo getRelNode() {
        return relNode;
    }

    public void setRelNode(ResourceEntityRelNodeVo relNode) {
        this.relNode = relNode;
    }

    public List<ResourceEntityRelLinkVo> getRelLinkList() {
        return relLinkList;
    }

    public void setRelLinkList(List<ResourceEntityRelLinkVo> relLinkList) {
        this.relLinkList = relLinkList;
    }

    public List<ResourceEntityLeftJoinVo> getLeftJoinList() {
        return leftJoinList;
    }

    public void setLeftJoinList(List<ResourceEntityLeftJoinVo> leftJoinList) {
        this.leftJoinList = leftJoinList;
    }

    public List<ResourceEntityFieldMappingVo> getFieldMappingList() {
        return fieldMappingList;
    }

    public void setFieldMappingList(List<ResourceEntityFieldMappingVo> fieldMappingList) {
        this.fieldMappingList = fieldMappingList;
    }

    public String getSceneTemplateName() {
        return sceneTemplateName;
    }

    public void setSceneTemplateName(String sceneTemplateName) {
        this.sceneTemplateName = sceneTemplateName;
    }

    public List<String> getSelectItemFieldNameList() {
        return selectItemFieldNameList;
    }

    public void setSelectItemFieldNameList(List<String> selectItemFieldNameList) {
        this.selectItemFieldNameList = selectItemFieldNameList;
    }

    public List<String> getFilterItemFieldNameList() {
        return filterItemFieldNameList;
    }

    public void setFilterItemFieldNameList(List<String> filterItemFieldNameList) {
        this.filterItemFieldNameList = filterItemFieldNameList;
    }
}
