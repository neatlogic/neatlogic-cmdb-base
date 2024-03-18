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

package neatlogic.framework.cmdb.dto.resourcecenter.sceneviewfielddeclare;

import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Date;

@ResourceType(name = "scence_ipobject_detail", label = "资产清单视图", functionPathList = {"配置管理/资产清单"})
public class IpObjectDetailVo {
    @EntityField(name = "ID", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;

    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;

    @EntityField(name = "IP地址", type = ApiParamType.STRING)
    @ResourceField(name = "ip")
    private String ip;

    @EntityField(name = "类型ID", type = ApiParamType.LONG)
    @ResourceField(name = "type_id")
    private Long typeId;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    @ResourceField(name = "type_name")
    private String typeName;
    @EntityField(name = "类型Label", type = ApiParamType.STRING)
    @ResourceField(name = "type_label")
    private String typeLabel;

    @EntityField(name = "创建者", type = ApiParamType.STRING)
    @ResourceField(name = "fcu")
    private String fcu;
    @EntityField(name = "创建日期", type = ApiParamType.LONG)
    @ResourceField(name = "fcd")
    private Date fcd;
    @EntityField(name = "修改者", type = ApiParamType.STRING)
    @ResourceField(name = "lcu")
    private String lcu;
    @EntityField(name = "修改日期", type = ApiParamType.LONG)
    @ResourceField(name = "lcd")
    private Date lcd;

    @EntityField(name = "维护窗口", type = ApiParamType.STRING)
    @ResourceField(name = "maintenance_window")
    private String maintenanceWindow;

    @EntityField(name = "描述", type = ApiParamType.STRING)
    @ResourceField(name = "description")
    private String description;
    @EntityField(name = "网络区域", type = ApiParamType.STRING)
    @ResourceField(name = "network_area")
    private String networkArea;

    @EntityField(name = "巡检状态", type = ApiParamType.STRING)
    @ResourceField(name = "inspect_status")
    private String inspectStatus;
    @EntityField(name = "巡检时间", type = ApiParamType.LONG)
    @ResourceField(name = "inspect_time")
    private Date inspectTime;
    @EntityField(name = "监控状态", type = ApiParamType.STRING)
    @ResourceField(name = "monitor_status")
    private String monitorStatus;
    @EntityField(name = "监控时间", type = ApiParamType.LONG)
    @ResourceField(name = "monitor_time")
    private Date monitorTime;

    @EntityField(name = "端口", type = ApiParamType.INTEGER)
    @ResourceField(name = "port")
    private Integer port;

    @EntityField(name = "分组ID", type = ApiParamType.LONG)
    @ResourceField(name = "bg_id")
    private Long bgId;
    @EntityField(name = "分组名称", type = ApiParamType.STRING)
    @ResourceField(name = "bg_name")
    private String bgName;

    @EntityField(name = "IP列表的ID", type = ApiParamType.LONG)
    @ResourceField(name = "allip_id")
    private Long allIpId;
    @EntityField(name = "IP列表的IP地址", type = ApiParamType.STRING)
    @ResourceField(name = "allip_ip")
    private String allIpIp;
    @EntityField(name = "IP列表的描述", type = ApiParamType.STRING)
    @ResourceField(name = "allip_label")
    private String allIpLabel;

    @EntityField(name = "用户ID", type = ApiParamType.LONG)
    @ResourceField(name = "user_id")
    private Long userId;
    @EntityField(name = "用户UUID", type = ApiParamType.STRING)
    @ResourceField(name = "user_uuid")
    private String uuid;
    @EntityField(name = "用户名", type = ApiParamType.STRING)
    @ResourceField(name = "user_name")
    private String userName;

    @EntityField(name = "状态ID", type = ApiParamType.LONG)
    @ResourceField(name = "state_id")
    private Long stateId;
    @EntityField(name = "状态名", type = ApiParamType.STRING)
    @ResourceField(name = "state_name")
    private String stateName;
    @EntityField(name = "状态描述", type = ApiParamType.STRING)
    @ResourceField(name = "state_label")
    private String stateLabel;

    @EntityField(name = "厂商ID", type = ApiParamType.LONG)
    @ResourceField(name = "vendor_id")
    private Long vendorId;
    @EntityField(name = "厂商名称", type = ApiParamType.STRING)
    @ResourceField(name = "vendor_name")
    private String vendorName;
    @EntityField(name = "厂商描述", type = ApiParamType.STRING)
    @ResourceField(name = "vendor_label")
    private String vendorLabel;

    @EntityField(name = "数据中心ID", type = ApiParamType.LONG)
    @ResourceField(name = "datacenter_id")
    private Long dataCenterId;
    @EntityField(name = "数据中心名称", type = ApiParamType.STRING)
    @ResourceField(name = "datacenter_name")
    private String dataCenterName;

    @EntityField(name = "环境ID", type = ApiParamType.LONG)
    @ResourceField(name = "env_id")
    private Long envId;
    @EntityField(name = "环境名称", type = ApiParamType.STRING)
    @ResourceField(name = "env_name")
    private String envName;
    @EntityField(name = "环境序号", type = ApiParamType.INTEGER)
    @ResourceField(name = "env_seq_no")
    private Integer envSeqNo;

    @EntityField(name = "应用模块ID", type = ApiParamType.LONG)
    @ResourceField(name = "app_module_id")
    private Long appModuleId;
    @EntityField(name = "应用模块名", type = ApiParamType.STRING)
    @ResourceField(name = "app_module_name")
    private String appModuleName;
    @EntityField(name = "应用模块简称", type = ApiParamType.STRING)
    @ResourceField(name = "app_module_abbr_name")
    private String appModuleAbbrName;

    @EntityField(name = "应用系统ID", type = ApiParamType.LONG)
    @ResourceField(name = "app_system_id")
    private Long appSystemId;
    @EntityField(name = "应用系统名", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_name")
    private String appSystemName;
    @EntityField(name = "应用系统简称", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_abbr_name")
    private String appSystemAbbrName;
}
