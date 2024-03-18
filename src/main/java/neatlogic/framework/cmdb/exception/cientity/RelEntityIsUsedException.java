/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.cmdb.dto.ci.RelVo;
import neatlogic.framework.cmdb.dto.cientity.RelEntityVo;
import neatlogic.framework.cmdb.enums.RelDirectionType;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class RelEntityIsUsedException extends ApiRuntimeException {
    private static final long serialVersionUID = -4949859498621326901L;

    public RelEntityIsUsedException(RelDirectionType direction, RelVo relVo, RelEntityVo relEntityVo) {
        super("关系“{0}”是唯一关系，它的值“{1}”已被其他配置项引用，请修改", (direction == RelDirectionType.FROM ? relVo.getToLabel() : relVo.getFromLabel()), (direction == RelDirectionType.FROM ? relEntityVo.getToCiEntityName() : relEntityVo.getFromCiEntityName()));
    }

    public RelEntityIsUsedException(RelDirectionType direction, RelVo relVo, Boolean other) {
        super("当前模型在关系“{0}”中是唯一引用，因此不能关联多个配置项，请修改", (direction == RelDirectionType.FROM ? relVo.getToLabel() : relVo.getFromLabel()));
    }
}
