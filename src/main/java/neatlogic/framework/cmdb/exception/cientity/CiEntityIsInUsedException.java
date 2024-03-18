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

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class CiEntityIsInUsedException extends ApiRuntimeException {
    private static final long serialVersionUID = 4514486027062482261L;

    public CiEntityIsInUsedException(List<AttrVo> attrList) {
        super("当前配置项已经被以下属性引用：{0}", attrList.stream().map(attr -> attr.getLabel() + "(" + attr.getCiLabel() + ")").collect(Collectors.joining(",")));
    }

    public CiEntityIsInUsedException(CiEntityVo ciEntityVo, List<AttrVo> attrList) {
        super("配置项“{0}”已被以下属性引用：{1}", ciEntityVo.getName(), attrList.stream().map(attr -> attr.getCiLabel() + "(" + attr.getCiName() + ")" + ":" + attr.getLabel() + "(" + attr.getName() + ")").collect(Collectors.joining(",")));
    }
}
