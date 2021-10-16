/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.sync;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.dto.sync.SyncCiCollectionVo;
import codedriver.framework.exception.core.ApiRuntimeException;

public class UniqueAttrNotCertifyException extends ApiRuntimeException {
    public UniqueAttrNotCertifyException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo) {
        super("请确保配置“" + syncCiCollectionVo.getCollectionName() + "->" + ciVo.getLabel() + "(" + ciVo.getName() + ")”中所有唯一规则属性都已经配置映射关系，并且集合中对应的属性值不能为空");
    }
}
