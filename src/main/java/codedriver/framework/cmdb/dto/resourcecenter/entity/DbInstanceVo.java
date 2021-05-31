/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.entity;

import codedriver.framework.cmdb.annotation.ResourceField;
import codedriver.framework.cmdb.annotation.ResourceType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;

import java.util.List;

@ResourceType(name = "resource_dbinstance", label = "DB实例")
public class DbInstanceVo extends ResourceEntityBaseVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;
    @EntityField(name = "所属部门列表", type = ApiParamType.JSONARRAY)
    private List<DbInstanceBgVo> bgList;
    @EntityField(name = "状态id", type = ApiParamType.LONG)
    private Long status;
    @EntityField(name = "状态名称", type = ApiParamType.STRING)
    private String statusName;
    @EntityField(name = "所有者列表", type = ApiParamType.JSONARRAY)
    private List<DbInstanceOwnerVo> ownerList;
    @EntityField(name = "维护窗口", type = ApiParamType.STRING)
    @ResourceField(name = "maintenance_window")
    private String maintenanceWindow;
    @EntityField(name = "描述", type = ApiParamType.STRING)
    @ResourceField(name = "description")
    private String description;
    @EntityField(name = "网络区域列表", type = ApiParamType.JSONARRAY)
    private List<DbInstanceNetAreaVo> netAreaList;
    @EntityField(name = "ip", type = ApiParamType.JSONOBJECT)
    private DbInstanceIpVo dbInstanceIpVo;
    @EntityField(name = "port", type = ApiParamType.INTEGER)
    @ResourceField(name = "port")
    private Integer port;
}
