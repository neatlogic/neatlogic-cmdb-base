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
 * @author linbq
 * @since 2021/6/17 10:34
 **/
public class AppEnvNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = -5353639287406720093L;

    public AppEnvNotFoundException(String name) {
        super("环境：“{0}”不存在", name);
    }

    public AppEnvNotFoundException(Long id) {
        super("环境：“{0}”不存在", id);
    }
}
