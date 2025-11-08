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
        return "b";
    }

    public enum FieldEnum {
        RESOURCE_ID("resource_id", "资产id","resourceId"),
        ACCOUNT_ID("account_id", "账号id", "accountId")
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
