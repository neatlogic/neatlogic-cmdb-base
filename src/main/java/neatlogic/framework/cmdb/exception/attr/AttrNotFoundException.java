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

package neatlogic.framework.cmdb.exception.attr;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class AttrNotFoundException extends ApiRuntimeException {

    public AttrNotFoundException(Long attrId) {
        super("配置项模型属性“{0}”不存在", attrId);
    }

    public AttrNotFoundException(String ciName, String attrName) {
        super("配置项模型“{0}”不存在属性“{1}”", ciName, attrName);
    }

    public AttrNotFoundException(String attrName) {
        super("配置项模型属性“{0}”不存在", attrName);
    }
}
