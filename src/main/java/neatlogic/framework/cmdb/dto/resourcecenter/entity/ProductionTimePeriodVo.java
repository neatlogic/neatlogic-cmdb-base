/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.cmdb.dto.resourcecenter.entity;

import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import javax.annotation.Resource;

/**
 * @author linbq
 * @since 2021/11/16 17:28
 **/
@ResourceType(name = "resource_appsystem_productiontimeperiod", label = "应用系统投产时段")
public class ProductionTimePeriodVo {
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;
    @EntityField(name = "投产时段id", type = ApiParamType.LONG)
    @ResourceField(name = "productiontimeperiod_id")
    private Long productionTimePeriodId;
    @EntityField(name = "投产时段编码", type = ApiParamType.LONG)
    @ResourceField(name = "productiontimeperiod_code")
    private String productionTimePeriodCode;
    @EntityField(name = "投产时段名称", type = ApiParamType.LONG)
    @ResourceField(name = "productiontimeperiod_label")
    private String productionTimePeriodLabel;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getProductionTimePeriodId() {
        return productionTimePeriodId;
    }

    public void setProductionTimePeriodId(Long productionTimePeriodId) {
        this.productionTimePeriodId = productionTimePeriodId;
    }

    public String getProductionTimePeriodCode() {
        return productionTimePeriodCode;
    }

    public void setProductionTimePeriodCode(String productionTimePeriodCode) {
        this.productionTimePeriodCode = productionTimePeriodCode;
    }

    public String getProductionTimePeriodLabel() {
        return productionTimePeriodLabel;
    }

    public void setProductionTimePeriodLabel(String productionTimePeriodLabel) {
        this.productionTimePeriodLabel = productionTimePeriodLabel;
    }
}
