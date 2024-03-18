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

import neatlogic.framework.exception.core.ApiRuntimeException;
import neatlogic.framework.cmdb.dto.ci.CiVo;

import java.util.List;
import java.util.stream.Collectors;

public class CiHasBeenExtendedException extends ApiRuntimeException {
    public CiHasBeenExtendedException(String ciLabel, List<CiVo> childCiList) {
        super("配置项模型：{0}已被以下模型继承：{1}", ciLabel, childCiList.stream().map(CiVo::getLabel).collect(Collectors.joining(",")));
    }
}
