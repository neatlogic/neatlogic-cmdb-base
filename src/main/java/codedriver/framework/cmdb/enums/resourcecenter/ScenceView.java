/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.resourcecenter;

public enum ScenceView {
    SCENCE_IPOBJECT_DETAIL("scence_ipobject_detail", "资产清单场景"),
    SCENCE_IPOBJECT_ID("scence_ipobject_id", "IP软硬件ID场景"),
    SCENCE_IPOBJECT_IP_PORT("scence_ipobject_ip_port", "IP软硬件IP和端口场景"),
    SCENCE_SOFTWARESERVICE_IP_PORT("scence_softwareservice_ip_port", "软件服务IP和端口场景"),
    SCENCE_IPOBJECT_ENV_APPMODULE("scence_ipobject_env_appmodule", "IP软硬件环境和模块场景"),
    SCENCE_DATABASE_ENV_APPMODULE("scence_database_env_appmodule", "DB库环境和模块场景"),
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
    SCENCE_ENV("scence_env", "环境基本信息场景");
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
        return text;
    }
}
