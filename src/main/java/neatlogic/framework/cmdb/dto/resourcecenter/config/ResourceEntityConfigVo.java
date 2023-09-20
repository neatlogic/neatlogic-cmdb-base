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

package neatlogic.framework.cmdb.dto.resourcecenter.config;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.dto.ci.CiVo;

import java.util.List;

public class ResourceEntityConfigVo {

    private String mainCi;
    @JSONField(serialize = false)
    private CiVo mainCiVo;

    private List<ResourceEntityFieldMappingVo> fieldMappingList;

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

    public List<ResourceEntityFieldMappingVo> getFieldMappingList() {
        return fieldMappingList;
    }

    public void setFieldMappingList(List<ResourceEntityFieldMappingVo> fieldMappingList) {
        this.fieldMappingList = fieldMappingList;
    }
}