/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.sync;

import codedriver.framework.exception.core.ApiRuntimeException;

public class InitiativeSyncCiCollectionNotFoundException extends ApiRuntimeException {
    public InitiativeSyncCiCollectionNotFoundException(String collectName) {
        super("集合“" + collectName + "”还没有主动采集模式的映射配置，请先配置");
    }
}
