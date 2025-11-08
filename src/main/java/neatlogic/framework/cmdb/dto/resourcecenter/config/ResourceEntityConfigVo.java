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
