/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.collection;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CollectionDataIrregularException extends ApiRuntimeException {
    public CollectionDataIrregularException(String param, String dataType) {
        super("参数“" + param + "”不是合法的" + dataType + "类型");
    }
}
