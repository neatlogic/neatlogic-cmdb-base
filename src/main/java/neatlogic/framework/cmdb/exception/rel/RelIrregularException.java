/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.cmdb.exception.rel;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class RelIrregularException extends ApiRuntimeException {
    public RelIrregularException(CiVo fromCiVo, CiVo toCiVo) {
        super("建立关系的上游模型需要是{0}或它的子模型，下游模型需要是{1}或它的子模型", fromCiVo.getLabel(), toCiVo.getLabel());
    }
}
