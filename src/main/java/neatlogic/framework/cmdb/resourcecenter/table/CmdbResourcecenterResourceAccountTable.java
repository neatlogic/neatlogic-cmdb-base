package neatlogic.framework.cmdb.resourcecenter.table;

import neatlogic.framework.util.$;
import org.springframework.stereotype.Component;

@Component
public class CmdbResourcecenterResourceAccountTable implements ISqlTable {

    @Override
    public String getName() {
        return "cmdb_resourcecenter_resource_account";
    }

    @Override
    public String getShortName() {
        return "crra";
    }

    public enum FieldEnum {
        RESOURCE_ID("resource_id", "资产id","resourceId"),
        ACCOUNT_ID("account_id", "帐号id","accountId")
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
            return $.t(text);
        }

        public String getProValue() {
            return proName;
        }

        public Boolean getPrimary() {
            return isPrimary;
        }

    }
}
