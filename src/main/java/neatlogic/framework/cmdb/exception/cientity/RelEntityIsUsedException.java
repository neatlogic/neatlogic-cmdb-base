/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

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
