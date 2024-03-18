/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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

package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

/**
 * @author lvzk
 * @since 2021/7/27 10:34
 **/
public class ResourceCenterResourceHasRepeatAccountException extends ApiRuntimeException {

    private static final long serialVersionUID = 6934793951984585148L;

    public ResourceCenterResourceHasRepeatAccountException(String resourceId, String account, String protocol) {
        super("资源“{0}”存在多个 协议为“{2}”用户名为“{1}”的账号,请联系管理员", resourceId, protocol, account);
    }
}
