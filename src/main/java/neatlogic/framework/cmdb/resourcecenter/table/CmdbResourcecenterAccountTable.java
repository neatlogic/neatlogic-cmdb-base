package neatlogic.framework.cmdb.resourcecenter.table;

import neatlogic.framework.util.I18nUtils;
import org.springframework.stereotype.Component;

@Component
public class CmdbResourcecenterAccountTable implements ISqlTable {

    @Override
    public String getName() {
        return "cmdb_resourcecenter_account";
    }

    @Override
    public String getShortName() {
        return "cra";
    }

    public enum FieldEnum {
        PROTOCOL_ID("protocol_id", "协议id","protocolId"),
        ID("id", "帐号id","id")
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
