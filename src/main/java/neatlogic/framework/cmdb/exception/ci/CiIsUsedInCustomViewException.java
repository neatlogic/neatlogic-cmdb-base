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

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.customview.CustomViewVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class CiIsUsedInCustomViewException extends ApiRuntimeException {
    public CiIsUsedInCustomViewException(CiVo ciVo, List<CustomViewVo> viewList) {
        super("模型“{0}({1})”已被自定义视图“{2}”引用，请先删除", ciVo.getLabel(), ciVo.getName(), viewList.stream().map(CustomViewVo::getName).collect(Collectors.joining("”,“")));
    }
}
