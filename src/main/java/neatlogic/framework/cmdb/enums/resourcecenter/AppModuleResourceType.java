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

import java.util.ArrayList;
import java.util.List;

/**
 * 应用清单中需要显示的模型
 * @author linbq
 * @since 2022/3/7 10:10
 **/
public enum AppModuleResourceType {
    OS("OS","OS"),
    APP_INSTANCE("APPIns","APPIns"),
    APP_INSTANCE_CLUSTER("APPInsCluster","ipObject"),
    DB_INSTANCE("DBIns","DBIns"),
    DB_CLUSTER("DBCluster","ipObject"),
    ACCESS_ENDPOINT("AccessEndPoint","ipObject"),
    DATABASE("Database","ipObject")
    ;
    private final String name;
    private final String action;

    AppModuleResourceType(String name, String action) {
        this.name = name;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getAction() {
        return action;
    }

    public static List<String> getNameList() {
        List<String> resultList = new ArrayList<>();
        for (AppModuleResourceType type : values()) {
            resultList.add(type.name);
        }
        return resultList;
    }

    public static String getAction(String name) {
        for (AppModuleResourceType type : values()) {
            if (type.name.equals(name)) {
                return type.action;
            }
        }
        return null;
    }

}
