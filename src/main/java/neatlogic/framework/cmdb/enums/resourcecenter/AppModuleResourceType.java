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
