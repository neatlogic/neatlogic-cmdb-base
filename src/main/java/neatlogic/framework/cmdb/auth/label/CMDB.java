/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.auth.label;

import neatlogic.framework.auth.core.AuthBase;

public class CMDB extends AuthBase {

    @Override
    public String getAuthDisplayName() {
        return "资源中心数据消费权限";
    }

    @Override
    public String getAuthIntroduction() {
        return "查询配置管理资产清单、应用清单相关数据";
    }

    @Override
    public String getAuthGroup() {
        return "cmdb";
    }

    @Override
    public Integer getSort() {
        return 13;
    }
}
