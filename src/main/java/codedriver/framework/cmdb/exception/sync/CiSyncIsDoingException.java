/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.sync;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.exception.core.ApiRuntimeException;

public class CiSyncIsDoingException extends ApiRuntimeException {
    public CiSyncIsDoingException(CiVo ciVo) {
        super("模型" + ciVo.getLabel() + "(" + ciVo.getName() + ")" + "正在同步，请等待同步结束再发起新的同步作业。");
    }

}
