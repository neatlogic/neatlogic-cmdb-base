/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.cmdb.dto.ci.RelVo;
import neatlogic.framework.cmdb.dto.cientity.RelEntityVo;
import neatlogic.framework.cmdb.enums.RelDirectionType;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class RelEntityIsUsedException extends ApiRuntimeException {
    public RelEntityIsUsedException(RelDirectionType direction, RelVo relVo, RelEntityVo relEntityVo) {
        super("关系“" + (direction == RelDirectionType.FROM ? relVo.getToLabel() : relVo.getFromLabel()) + "”是唯一关系，它的值“" + (direction == RelDirectionType.FROM ? relEntityVo.getToCiEntityName() : relEntityVo.getFromCiEntityName()) + "”已被其他配置项引用，请修改");
    }

    public RelEntityIsUsedException(RelDirectionType direction, RelVo relVo, Boolean other) {
        super("当前模型在关系“" + (direction == RelDirectionType.FROM ? relVo.getToLabel() : relVo.getFromLabel()) + "”中是唯一引用，因此不能关联多个配置项，请修改");
    }
}
