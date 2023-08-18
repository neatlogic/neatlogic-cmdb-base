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

package neatlogic.framework.cmdb.dto.resourcecenter.sceneviewfielddeclare;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityConfigVo;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityFieldMappingVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ResourceType(name = "scence_ipobject_detail", label = "资产清单视图")
public class IpObjectDetailVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;

    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;

    @EntityField(name = "IP地址", type = ApiParamType.STRING)
    @ResourceField(name = "ip")
    private String ip;

    @EntityField(name = "类型id", type = ApiParamType.LONG)
    @ResourceField(name = "type_id")
    private Long typeId;
    @EntityField(name = "类型名称", type = ApiParamType.STRING)
    @ResourceField(name = "type_name")
    private String typeName;
    @EntityField(name = "类型label", type = ApiParamType.STRING)
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

    @EntityField(name = "分组id", type = ApiParamType.LONG)
    @ResourceField(name = "bg_id")
    private Long bgId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "bg_name")
    private String bgName;

    @EntityField(name = "ip的id", type = ApiParamType.LONG)
    @ResourceField(name = "allip_id")
    private Long allIpId;
    @EntityField(name = "ip", type = ApiParamType.STRING)
    @ResourceField(name = "allip_ip")
    private String allIpIp;
    @EntityField(name = "ip描述", type = ApiParamType.STRING)
    @ResourceField(name = "allip_label")
    private String allIpLabel;

    @EntityField(name = "用户uuid", type = ApiParamType.STRING)
    @ResourceField(name = "user_uuid")
    private String uuid;
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "user_id")
    private Long userId;
    @EntityField(name = "用户名", type = ApiParamType.STRING)
    @ResourceField(name = "user_name")
    private String userName;

    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "state_id")
    private Long stateId;
    @EntityField(name = "状态名", type = ApiParamType.STRING)
    @ResourceField(name = "state_name")
    private String stateName;
    @EntityField(name = "状态描述", type = ApiParamType.STRING)
    @ResourceField(name = "state_label")
    private String stateLabel;

    @EntityField(name = "厂商id", type = ApiParamType.LONG)
    @ResourceField(name = "vendor_id")
    private Long vendorId;
    @EntityField(name = "厂商名称", type = ApiParamType.STRING)
    @ResourceField(name = "vendor_name")
    private String vendorName;
    @EntityField(name = "厂商描述", type = ApiParamType.STRING)
    @ResourceField(name = "vendor_label")
    private String vendorLabel;

    @EntityField(name = "数据中心id", type = ApiParamType.LONG)
    @ResourceField(name = "datacenter_id")
    private Long dataCenterId;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "datacenter_name")
    private String dataCenterName;

    @EntityField(name = "环境id", type = ApiParamType.LONG)
    @ResourceField(name = "env_id")
    private Long envId;
    @EntityField(name = "环境名称", type = ApiParamType.STRING)
    @ResourceField(name = "env_name")
    private String envName;
    @EntityField(name = "序号", type = ApiParamType.INTEGER)
    @ResourceField(name = "env_seq_no")
    private Integer envSeqNo;

    @EntityField(name = "模块id", type = ApiParamType.LONG)
    @ResourceField(name = "app_module_id")
    private Long appModuleId;
    @EntityField(name = "模块名", type = ApiParamType.STRING)
    @ResourceField(name = "app_module_name")
    private String appModuleName;
    @EntityField(name = "模块简称", type = ApiParamType.STRING)
    @ResourceField(name = "app_module_abbr_name")
    private String appModuleAbbrName;

    @EntityField(name = "应用id", type = ApiParamType.LONG)
    @ResourceField(name = "app_system_id")
    private Long appSystemId;
    @EntityField(name = "应用名", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_name")
    private String appSystemName;
    @EntityField(name = "应用简称", type = ApiParamType.STRING)
    @ResourceField(name = "app_system_abbr_name")
    private String appSystemAbbrName;

    public ResourceEntityConfigVo getConfig() {
        ResourceEntityConfigVo config = new ResourceEntityConfigVo();
        config.setMainCi("IPObject");
        List<ResourceEntityFieldMappingVo> list = new ArrayList<>();
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("id");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("name");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_name");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("type_id");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_typeId");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("type_name");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_typeName");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("type_label");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_typeLabel");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("fcu");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("fcu");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("fcd");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("fcd");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("lcu");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("lcu");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("lcd");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("lcd");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("inspect_status");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_inspectStatus");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("inspect_time");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_inspectTime");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("monitor_status");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_monitorStatus");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("monitor_time");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("_monitorTime");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("ip");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("ip");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("maintenance_window");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("maintenance_window");
            fieldMappingVo.setToCi("");
            fieldMappingVo.setToAttr("");
            fieldMappingVo.setDirection("");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("description");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("description");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("network_area");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("network_area");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("port");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("SoftwareService");
            fieldMappingVo.setFromAttr("port");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("bg_id");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("business_group");
            fieldMappingVo.setToCi("BusinessGroup");
            fieldMappingVo.setToAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("bg_name");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("business_group");
            fieldMappingVo.setToCi("BusinessGroup");
            fieldMappingVo.setToAttr("_name");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("allip_id");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("all_ip");
            fieldMappingVo.setToCi("IPList");
            fieldMappingVo.setToAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("allip_ip");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("all_ip");
            fieldMappingVo.setToCi("IPList");
            fieldMappingVo.setToAttr("IP");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("allip_label");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("all_ip");
            fieldMappingVo.setToCi("IPList");
            fieldMappingVo.setToAttr("label");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("user_id");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("owner");
            fieldMappingVo.setToCi("User");
            fieldMappingVo.setToAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("user_name");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("owner");
            fieldMappingVo.setToCi("User");
            fieldMappingVo.setToAttr("user_name");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("user_uuid");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("owner");
            fieldMappingVo.setToCi("User");
            fieldMappingVo.setToAttr("_uuid");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("state_id");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("state");
            fieldMappingVo.setToCi("CIState");
            fieldMappingVo.setToAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("state_name");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("state");
            fieldMappingVo.setToCi("CIState");
            fieldMappingVo.setToAttr("name");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("state_label");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("state");
            fieldMappingVo.setToCi("CIState");
            fieldMappingVo.setToAttr("label");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("vendor_id");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("vendor");
            fieldMappingVo.setToCi("vendor");
            fieldMappingVo.setToAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("vendor_name");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("vendor");
            fieldMappingVo.setToCi("vendor");
            fieldMappingVo.setToAttr("name");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("vendor_label");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("vendor");
            fieldMappingVo.setToCi("vendor");
            fieldMappingVo.setToAttr("label");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("datacenter_id");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("data_center");
            fieldMappingVo.setToCi("DataCenter");
            fieldMappingVo.setToAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("datacenter_name");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("IPObject");
            fieldMappingVo.setFromAttr("data_center");
            fieldMappingVo.setToCi("DataCenter");
            fieldMappingVo.setToAttr("name");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("env_id");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("SoftwareService");
            fieldMappingVo.setFromAttr("app_environment");
            fieldMappingVo.setToCi("APPEnv");
            fieldMappingVo.setToAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("env_name");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("SoftwareService");
            fieldMappingVo.setFromAttr("app_environment");
            fieldMappingVo.setToCi("APPEnv");
            fieldMappingVo.setToAttr("name");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("env_seq_no");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("SoftwareService");
            fieldMappingVo.setFromAttr("app_environment");
            fieldMappingVo.setToCi("APPEnv");
            fieldMappingVo.setToAttr("seq_no");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("app_module_id");
            fieldMappingVo.setType("rel");
            fieldMappingVo.setFromCi("APPComponent");
            fieldMappingVo.setFromAttr("_id");
            fieldMappingVo.setToCi("IPObject");
            fieldMappingVo.setDirection("to");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("app_module_name");
            fieldMappingVo.setType("rel");
            fieldMappingVo.setFromCi("APPComponent");
            fieldMappingVo.setFromAttr("name");
            fieldMappingVo.setToCi("IPObject");
            fieldMappingVo.setDirection("to");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("app_module_abbr_name");
            fieldMappingVo.setType("rel");
            fieldMappingVo.setFromCi("APPComponent");
            fieldMappingVo.setFromAttr("abbrName");
            fieldMappingVo.setToCi("IPObject");
            fieldMappingVo.setDirection("to");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("app_system_id");
            fieldMappingVo.setType("rel");
            fieldMappingVo.setFromCi("APP");
            fieldMappingVo.setFromAttr("_id");
            fieldMappingVo.setToCi("APPComponent");
            fieldMappingVo.setDirection("to");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("app_system_name");
            fieldMappingVo.setType("rel");
            fieldMappingVo.setFromCi("APP");
            fieldMappingVo.setFromAttr("name");
            fieldMappingVo.setToCi("APPComponent");
            fieldMappingVo.setToAttr("");
            fieldMappingVo.setDirection("to");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("app_system_abbr_name");
            fieldMappingVo.setType("rel");
            fieldMappingVo.setFromCi("APP");
            fieldMappingVo.setFromAttr("abbrName");
            fieldMappingVo.setToCi("APPComponent");
            fieldMappingVo.setDirection("to");
            list.add(fieldMappingVo);
        }
        config.setFieldMappingList(list);
        return config;
    }

    public static void main(String[] args) {
        IpObjectDetailVo ipObjectDetailVo = new IpObjectDetailVo();
        System.out.println(JSONObject.toJSONString(ipObjectDetailVo.getConfig()));
    }
}
