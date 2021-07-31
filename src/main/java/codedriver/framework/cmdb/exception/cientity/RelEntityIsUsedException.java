/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.cientity;

import codedriver.framework.cmdb.dto.ci.RelVo;
import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.exception.core.ApiRuntimeException;

public class RelEntityIsUsedException extends ApiRuntimeException {
    public RelEntityIsUsedException(RelDirectionType direction, RelVo relVo) {
        super("关系“" + (direction == RelDirectionType.FROM ? relVo.getToLabel() : relVo.getFromLabel()) + "”是唯一关系，它的值已被其他配置项引用，请修改");
    }
}
