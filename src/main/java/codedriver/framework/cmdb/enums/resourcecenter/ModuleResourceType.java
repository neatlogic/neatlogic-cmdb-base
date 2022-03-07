/*
 * Copyright(c) 2022 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums.resourcecenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用清单中需要显示的模型
 * @author linbq
 * @since 2022/3/7 10:10
 **/
public enum ModuleResourceType {
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

    ModuleResourceType(String name, String action) {
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
        for (ModuleResourceType type : values()) {
            resultList.add(type.name);
        }
        return resultList;
    }

    public static String getAction(String name) {
        for (ModuleResourceType type : values()) {
            if (type.name.equals(name)) {
                return type.action;
            }
        }
        return null;
    }

}
