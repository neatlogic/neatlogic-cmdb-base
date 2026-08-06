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

package neatlogic.framework.cmdb.dto.resourcecenter.sceneviewfielddeclare;

import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.Date;

@ResourceType(name = "scence_ipobject_detail", label = "nfcdrcs.ipobjectdetailvo.resourcetype.scenceipobjectdetail.label", moduleId= "cmdb", functionPathList = {"nfcdrcs.functionpath.assetlist"})
public class IpObjectDetailVo {
    @EntityField(name = "ID", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;

    @EntityField(name = "common.name", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;

    @EntityField(name = "term.cmdb.ip", type = ApiParamType.STRING)
    @ResourceField(name = "ip")
    private String ip;

    @EntityField(name = "common.typeid", type = ApiParamType.LONG)
    @ResourceField(name = "type_id")
    private Long typeId;
    @EntityField(name = "common.typename", type = ApiParamType.STRING)
    @ResourceField(name = "type_name")
    private String typeName;
    @EntityField(name = "nfcdrcs.common.entityfield.typelabel.name", type = ApiParamType.STRING)
    @ResourceField(name = "type_label")
    private String typeLabel;

    @EntityField(name = "common.createuser", type = ApiParamType.STRING)
    @ResourceField(name = "fcu")
    private String fcu;
    @EntityField(name = "common.createdate", type = ApiParamType.LONG)
    @ResourceField(name = "fcd")
    private Date fcd;
    @EntityField(name = "common.editor", type = ApiParamType.STRING)
    @ResourceField(name = "lcu")
    private String lcu;
    @EntityField(name = "common.editdate", type = ApiParamType.LONG)
    @ResourceField(name = "lcd")
    private Date lcd;

    @EntityField(name = "term.cmdb.maintenancewindow", type = ApiParamType.STRING)
    @ResourceField(name = "maintenance_window")
    private String maintenanceWindow;

    @EntityField(name = "common.description", type = ApiParamType.STRING)
    @ResourceField(name = "description")
    private String description;
    @EntityField(name = "common.networkarea", type = ApiParamType.STRING)
    @ResourceField(name = "network_area")
    private String networkArea;

    @EntityField(name = "term.cmdb.inspectstatus", type = ApiParamType.STRING)
    @ResourceField(name = "inspect_status")
    private String inspectStatus;
    @EntityField(name = "nfcdrcs.common.entityfield.inspecttime.name", type = ApiParamType.LONG)
    @ResourceField(name = "inspect_time")
    private Date inspectTime;
    @EntityField(name = "term.cmdb.monitorstatus", type = ApiParamType.STRING)
    @ResourceField(name = "monitor_status")
    private String monitorStatus;
    @EntityField(name = "nfcdrcs.common.entityfield.monitortime.name", type = ApiParamType.LONG)
    @ResourceField(name = "monitor_time")
    private Date monitorTime;

    @EntityField(name = "nfcdrcs.common.entityfield.port.name", type = ApiParamType.INTEGER)
    @ResourceField(name = "port")
    private Integer port;

    @EntityField(name = "nfcdrcs.common.entityfield.groupid.name", type = ApiParamType.LONG)
    @ResourceField(name = "bg_id")
    private Long bgId;
    @EntityField(name = "nfcdrcs.common.entityfield.groupname.name", type = ApiParamType.STRING)
    @ResourceField(name = "bg_name")
    private String bgName;

    @EntityField(name = "nfcdrcs.common.entityfield.allipid.name", type = ApiParamType.LONG)
    @ResourceField(name = "allip_id")
    private Long allIpId;
    @EntityField(name = "nfcdrcs.common.entityfield.allipip.name", type = ApiParamType.STRING)
    @ResourceField(name = "allip_ip")
    private String allIpIp;
    @EntityField(name = "nfcdrcs.common.entityfield.allipdescription.name", type = ApiParamType.STRING)
    @ResourceField(name = "allip_label")
    private String allIpLabel;

    @EntityField(name = "common.userid", type = ApiParamType.LONG)
    @ResourceField(name = "user_id")
    private Long userId;
    @EntityField(name = "common.useruuid", type = ApiParamType.STRING)
    @ResourceField(name = "user_uuid")
    private String userUuid;
    @EntityField(name = "common.username", type = ApiParamType.STRING)
    @ResourceField(name = "user_name")
    private String userName;

    @EntityField(name = "common.statusid", type = ApiParamType.LONG)
    @ResourceField(name = "state_id")
    private Long stateId;
    @EntityField(name = "common.statusname", type = ApiParamType.STRING)
    @ResourceField(name = "state_name")
    private String stateName;
    @EntityField(name = "common.statusdescription", type = ApiParamType.STRING)
    @ResourceField(name = "state_label")
    private String stateLabel;

    @EntityField(name = "nfcdrcs.common.entityfield.vendorid.name", type = ApiParamType.LONG)
    @ResourceField(name = "vendor_id")
    private Long vendorId;
    @EntityField(name = "nfcdrcs.common.entityfield.vendorname.name", type = ApiParamType.STRING)
    @ResourceField(name = "vendor_name")
    private String vendorName;
    @EntityField(name = "nfcdrcs.common.entityfield.vendordescription.name", type = ApiParamType.STRING)
    @ResourceField(name = "vendor_label")
    private String vendorLabel;

    @EntityField(name = "nfcdrcs.common.entityfield.datacenterid.name", type = ApiParamType.LONG)
    @ResourceField(name = "datacenter_id")
    private Long dataCenterId;
    @EntityField(name = "nfcdrcs.common.entityfield.datacentername.name", type = ApiParamType.STRING)
    @ResourceField(name = "datacenter_name")
    private String dataCenterName;

    @EntityField(name = "nfcdrcs.common.entityfield.osid.name", type = ApiParamType.LONG)
    @ResourceField(name = "os_id")
    private Long osId;
    @EntityField(name = "nfcdrcs.common.entityfield.osname.name", type = ApiParamType.STRING)
    @ResourceField(name = "os_name")
    private String osName;

    @EntityField(name = "nfcdrcs.common.entityfield.ostypeid.name", type = ApiParamType.LONG)
    @ResourceField(name = "os_type_id")
    private Long osTypeId;

    @EntityField(name = "nfcdrcs.common.entityfield.osipaddress.name", type = ApiParamType.STRING)
    @ResourceField(name = "os_ip")
    private String osIp;

    @EntityField(name = "term.cmdb.envid", type = ApiParamType.LONG)
    @ResourceField(name = "env_id")
    private Long envId;
    @EntityField(name = "term.cmdb.envname", type = ApiParamType.STRING)
    @ResourceField(name = "env_name")
    private String envName;
    @EntityField(name = "nfcdrcs.common.entityfield.envsequencenumber.name", type = ApiParamType.INTEGER)
    @ResourceField(name = "env_seq_no")
    private Integer envSeqNo;

    @EntityField(name = "term.cmdb.appmoduleid", type = ApiParamType.LONG)
    @ResourceField(name = "app_module_id")
    private Long appModuleId;
    @EntityField(name = "term.cmdb.appmodulename", type = ApiParamType.STRING)
    @ResourceField(name = "app_module_name")
    private String appModuleName;
    @EntityField(name = "term.cmdb.appmoduleabbrname", type = ApiParamType.STRING)
    @ResourceField(name = "app_module_abbr_name")
    private String appModuleAbbrName;

    @EntityField(name = "term.cmdb.appsystemid", type = ApiParamType.LONG)
    @ResourceField(name = "app_system_id")
    private Long appSystemId;
    @EntityField(name = "term.cmdb.appsystemname", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_name")
    private String appSystemName;
    @EntityField(name = "term.cmdb.appsystemabbrname", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_abbr_name")
    private String appSystemAbbrName;
}
