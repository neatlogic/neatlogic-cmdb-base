/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.cmdb.enums.resourcecenter;

import neatlogic.framework.util.$;
@Deprecated
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
        return $.t(text);
    }
}
