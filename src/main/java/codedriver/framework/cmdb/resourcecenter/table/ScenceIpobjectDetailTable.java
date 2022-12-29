package codedriver.framework.cmdb.resourcecenter.table;

import org.springframework.stereotype.Component;

@Component
public class ScenceIpobjectDetailTable implements ISqlTable {

    @Override
    public String getName() {
        return "scence_ipobject_detail";
    }

    @Override
    public String getShortName() {
        return "sid";
    }

    public enum FieldEnum {
        APP_SYSTEM_ID("app_system_id", "应用系统id","appSystemId"),
        APP_MODULE_ID("app_module_id", "应用模块id","appModuleId"),
        ENV_ID("env_id","环境id","envId"),
        VENDOR_ID("vendor_id","厂商id","vendorId"),
        STATE_ID("state_id","资产状态id","stateId"),
        TYPE_ID("type_id","资产类型id","typeId"),
        ID("id","资产id","id"),
        INSPECT_STATUS("inspect_status","巡检状态","inspectStatus"),
        NAME("name","资产名","name"),
        IP("ip","资产ip","ip"),
        PORT("port","端口","port"),
        DESCRIPTION("description","描述","description"),
        NETWORK_AREA("network_area","网络区域","networkArea"),
        MAINTENANCE_WINDOW("maintenance_window","网络区域","maintenanceWindow"),
        USER_UUID("user_uuid","所有者","userUuid"),
        BG_ID("bg_id","所属部门","bgId"),
        ;
        private final String name;
        private final String text;
        private final String proName;
        private final Boolean isPrimary;

        FieldEnum(String _value, String _text, String _proName) {
            this.name = _value;
            this.text = _text;
            this.proName = _proName;
            this.isPrimary = false;
        }

        public String getValue() {
            return name;
        }

        public String getText() {
            return text;
        }

        public String getProValue() {
            return proName;
        }

        public Boolean getPrimary() {
            return isPrimary;
        }

    }
}
