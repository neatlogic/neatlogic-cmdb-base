/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
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
