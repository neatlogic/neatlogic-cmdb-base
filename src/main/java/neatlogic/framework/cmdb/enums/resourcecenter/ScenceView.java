/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

package neatlogic.framework.cmdb.enums.resourcecenter;

import neatlogic.framework.util.I18nUtils;

public enum ScenceView {
    SCENCE_IPOBJECT_DETAIL("scence_ipobject_detail", "资产清单场景"),
    SCENCE_IPOBJECT_ID("scence_ipobject_id", "IP软硬件ID场景"),
    SCENCE_IPOBJECT_IP_PORT("scence_ipobject_ip_port", "IP软硬件IP和端口场景"),
    SCENCE_SOFTWARESERVICE_IP_PORT("scence_softwareservice_ip_port", "软件服务IP和端口场景"),
    SCENCE_IPOBJECT_ENV_APPMODULE("scence_ipobject_env_appmodule", "IP软硬件环境和模块场景"),
    SCENCE_DATABASE_ENV_APPMODULE("scence_database_ip_port_env_appmodule", "DB库IP端口环境和模块场景"),
    SCENCE_APPINSTANCE_IP_PORT_ENV_APPMODULE("scence_appinstance_ip_port_env_appmodule", "应用实例IP端口环境和模块场景"),
    SCENCE_APPINSTANCE_DETAIL_CLUSTER("scence_appinstance_detail_cluster", "应用实例详情及集群场景"),
    SCENCE_DBINSTANCE_DETAIL_CLUSTER("scence_dbinstance_detail_cluster", "DB实例详情及集群场景"),
    SCENCE_IPOBJECT_ENV_APPMODULE_APPSYSTEM("scence_ipobject_env_appmodule_appsystem", "IP软硬件环境和模块及应用场景"),
    SCENCE_APPINSTANCE_ENV_APPMODULE_APPSYSTEM("scence_appinstance_env_appmodule_appsystem", "应用实例环境和模块及应用场景"),
    SCENCE_APPSYSTEM_APPMODULE("scence_appsystem_appmodule", "应用和模块场景"),
    SCENCE_APPMODULE_APPSYSTEM("scence_appmodule_appsystem", "模块和应用场景"),
    SCENCE_APPSYSTEM_PRODUCTIONTIMEPERIOD("scence_appsystem_productiontimeperiod", "应用系统投产时段场景"),
    SCENCE_APPSYSTEM("scence_appsystem", "应用基本信息场景"),
    SCENCE_APPMODULE("scence_appmodule", "模块基本信息场景"),
    SCENCE_STATE("scence_state", "资产状态基本信息场景"),
    SCENCE_VENDOR("scence_vendor", "厂商基本信息场景"),
    SCENCE_ENV("scence_env", "环境基本信息场景"),
    SCENCE_OS_DETAIL_CLUSTER("scence_os_detail_cluster", "操作系统详情及集群场景"),
    SCENCE_OS_SOFTWARESERVICE_ENV_APPMODULE("scence_os_softwareservice_env_appmodule", "操作系统与软件服务、环境、模块场景"),
    SCENCE_OS_SOFTWARESERVICE_ENV_APPMODULE_APPSYSTEM("scence_os_softwareservice_env_appmodule_appsystem", "操作系统与软件服务、环境、模块及应用场景"),
    SCENCE_SOFTWARESERVICE_PORTS("scence_softwareservice_ports","软件服务服务端口场景"),
    SCENCE_SOFTWARESERVICE_OS("scence_softwareservice_os","软件服务与操作系统场景"),
    SCENCE_OSSERVICE_PORTS("scence_osservice_ports","操作系统服务端口场景");
    private final String value;
    private final String text;

    ScenceView(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return I18nUtils.getMessage(text);
    }
}
