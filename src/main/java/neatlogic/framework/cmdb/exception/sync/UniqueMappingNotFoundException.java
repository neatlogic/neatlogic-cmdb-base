/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.sync;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class UniqueMappingNotFoundException extends ApiRuntimeException {
    public UniqueMappingNotFoundException(Long attrId) {
        super("配置项唯一属性：" + attrId + "没有配置同步映射规则");
    }
}

