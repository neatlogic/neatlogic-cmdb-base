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
    SCENCE_IPOBJECT_DETAIL("scence_ipobject_detail", "enum.cmdb.scenceview.scence_ipobject_detail"),
    SCENCE_IPOBJECT_ID("scence_ipobject_id", "enum.cmdb.scenceview.scence_ipobject_id"),
    SCENCE_IPOBJECT_IP_PORT("scence_ipobject_ip_port", "enum.cmdb.scenceview.scence_ipobject_ip_port"),
    SCENCE_SOFTWARESERVICE_IP_PORT("scence_softwareservice_ip_port", "enum.cmdb.scenceview.scence_softwareservice_ip_port"),
    SCENCE_IPOBJECT_ENV_APPMODULE("scence_ipobject_env_appmodule", "enum.cmdb.scenceview.scence_ipobject_env_appmodule.a"),
    SCENCE_DATABASE_ENV_APPMODULE("scence_database_ip_port_env_appmodule", "enum.cmdb.scenceview.scence_database_env_appmodule"),
    SCENCE_APPINSTANCE_IP_PORT_ENV_APPMODULE("scence_appinstance_ip_port_env_appmodule", "enum.cmdb.scenceview.scence_appinstance_ip_port_env_appmodule"),
    SCENCE_APPINSTANCE_DETAIL_CLUSTER("scence_appinstance_detail_cluster", "enum.cmdb.scenceview.scence_appinstance_detail_cluster"),
    SCENCE_DBINSTANCE_DETAIL_CLUSTER("scence_dbinstance_detail_cluster", "enum.cmdb.scenceview.scence_dbinstance_detail_cluster"),
    SCENCE_IPOBJECT_ENV_APPMODULE_APPSYSTEM("scence_ipobject_env_appmodule_appsystem", "enum.cmdb.scenceview.scence_ipobject_env_appmodule_appsystem"),
    SCENCE_APPINSTANCE_ENV_APPMODULE_APPSYSTEM("scence_appinstance_env_appmodule_appsystem", "enum.cmdb.scenceview.scence_appinstance_env_appmodule_appsystem"),
    SCENCE_APPSYSTEM_APPMODULE("scence_appsystem_appmodule", "enum.cmdb.scenceview.scence_appsystem_appmodule"),
    SCENCE_APPMODULE_APPSYSTEM("scence_appmodule_appsystem", "enum.cmdb.scenceview.scence_appmodule_appsystem"),
    SCENCE_APPSYSTEM_PRODUCTIONTIMEPERIOD("scence_appsystem_productiontimeperiod", "enum.cmdb.scenceview.scence_appsystem_productiontimeperiod"),
    SCENCE_APPSYSTEM("scence_appsystem", "enum.cmdb.scenceview.scence_appsystem.a"),
    SCENCE_APPMODULE("scence_appmodule", "enum.cmdb.scenceview.scence_appmodule.a"),
    SCENCE_STATE("scence_state", "enum.cmdb.scenceview.scence_state"),
    SCENCE_VENDOR("scence_vendor", "enum.cmdb.scenceview.scence_vendor"),
    SCENCE_ENV("scence_env", "enum.cmdb.scenceview.scence_env"),
    SCENCE_OS_DETAIL_CLUSTER("scence_os_detail_cluster", "enum.cmdb.scenceview.scence_os_detail_cluster"),
    SCENCE_OS_SOFTWARESERVICE_ENV_APPMODULE("scence_os_softwareservice_env_appmodule", "enum.cmdb.scenceview.scence_os_softwareservice_env_appmodule.a"),
    SCENCE_OS_SOFTWARESERVICE_ENV_APPMODULE_APPSYSTEM("scence_os_softwareservice_env_appmodule_appsystem", "enum.cmdb.scenceview.scence_os_softwareservice_env_appmodule_appsystem"),
    SCENCE_SOFTWARESERVICE_PORTS("scence_softwareservice_ports","enum.cmdb.scenceview.scence_softwareservice_ports"),
    SCENCE_SOFTWARESERVICE_OS("scence_softwareservice_os","enum.cmdb.scenceview.scence_softwareservice_os"),
    SCENCE_OSSERVICE_PORTS("scence_osservice_ports","enum.cmdb.scenceview.scence_osservice_ports");
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
