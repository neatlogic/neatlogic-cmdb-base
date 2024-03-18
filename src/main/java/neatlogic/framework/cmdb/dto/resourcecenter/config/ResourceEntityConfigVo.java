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
