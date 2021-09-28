/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.exception.core.ApiRuntimeException;

public class CiUniqueAttrDataEmptyException extends ApiRuntimeException {

    public CiUniqueAttrDataEmptyException(String ciName) {
        super("配置项模型“" + ciName + "”缺少唯一属性，请设置");
    }

    public CiUniqueAttrDataEmptyException(String collectionName, String id, String key) {
        super("集合“" + collectionName + "”数据“" + id + "”找不到键为“" + key + "”的属性");
    }
}