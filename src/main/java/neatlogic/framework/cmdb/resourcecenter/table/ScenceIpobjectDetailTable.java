package neatlogic.framework.cmdb.resourcecenter.table;

import neatlogic.framework.util.I18nUtils;
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
        APP_SYSTEM_ID("app_system_id", "enum.cmdb.fieldenum.app_system_id","appSystemId"),
        APP_MODULE_ID("app_module_id", "enum.cmdb.fieldenum.app_module_id","appModuleId"),
        ENV_ID("env_id","enum.cmdb.fieldenum.env_id","envId"),
        VENDOR_ID("vendor_id","enum.cmdb.fieldenum.vendor_id","vendorId"),
        STATE_ID("state_id","enum.cmdb.fieldenum.state_id","stateId"),
        TYPE_ID("type_id","enum.cmdb.fieldenum.type_id","typeId"),
        TYPE_NAME("type_name","enum.cmdb.fieldenum.type_name","typeName"),
        TYPE_LABEL("type_label","enum.cmdb.fieldenum.type_label","typeLabel"),
        ID("id","common.assetid","id"),
        INSPECT_STATUS("inspect_status","enum.cmdb.fieldenum.inspect_status","inspectStatus"),
        NAME("name","enum.cmdb.fieldenum.name","name"),
        IP("ip","enum.cmdb.fieldenum.ip","ip"),
        PORT("port","enum.cmdb.fieldenum.port","port"),
        DESCRIPTION("description","enum.cmdb.fieldenum.description","description"),
        NETWORK_AREA("network_area","enum.cmdb.fieldenum.network_area","networkArea"),
        MAINTENANCE_WINDOW("maintenance_window","enum.cmdb.fieldenum.maintenance_window","maintenanceWindow"),
        USER_UUID("user_uuid","enum.cmdb.fieldenum.user_uuid","userUuid"),
        BG_ID("bg_id","enum.cmdb.fieldenum.bg_id","bgId"),
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
            return I18nUtils.getMessage(text);
        }

        public String getProValue() {
            return proName;
        }

        public Boolean getPrimary() {
            return isPrimary;
        }

    }
}
