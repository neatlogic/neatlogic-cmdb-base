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

@ResourceType(name = "scence_appmodule_appsystem", label = "nfcdrcs.appmoduleappsystemvo.resourcetype.scenceappmoduleappsystem.label", moduleId= "cmdb")
public class AppModuleAppSystemVo {
    @EntityField(name = "ID", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;

    @EntityField(name = "common.name", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;

    @EntityField(name = "term.cmdb.abbrname", type = ApiParamType.STRING)
    @ResourceField(name = "abbr_name")
    private String abbrName;

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

    @EntityField(name = "nfcdrcs.common.entityfield.groupid.name", type = ApiParamType.LONG)
    @ResourceField(name = "bg_id")
    private Long bgId;
    @EntityField(name = "nfcdrcs.common.entityfield.groupname.name", type = ApiParamType.STRING)
    @ResourceField(name = "bg_name")
    private String bgName;

    @EntityField(name = "common.userid", type = ApiParamType.LONG)
    @ResourceField(name = "user_id")
    private Long userId;
    @EntityField(name = "common.useruuid", type = ApiParamType.STRING)
    @ResourceField(name = "user_uuid")
    private String uuid;
    @EntityField(name = "common.username", type = ApiParamType.STRING)
    @ResourceField(name = "user_name")
    private String userName;

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
