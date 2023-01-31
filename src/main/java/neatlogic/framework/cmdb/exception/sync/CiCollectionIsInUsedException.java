/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.sync;

import neatlogic.framework.cmdb.dto.sync.SyncPolicyVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class CiCollectionIsInUsedException extends ApiRuntimeException {
    public CiCollectionIsInUsedException(List<SyncPolicyVo> policyList) {
        super("当前采集映射已被策略“" + policyList.stream().map(SyncPolicyVo::getName).collect(Collectors.joining("”,“")) + "”使用，请先删除");
    }
}
