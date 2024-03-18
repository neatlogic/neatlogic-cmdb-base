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

package neatlogic.framework.cmdb.exception.sync;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class InitiativeSyncCiCollectionNotFoundException extends ApiRuntimeException {
    public InitiativeSyncCiCollectionNotFoundException(String collectName) {
        super("集合“{0}”还没有主动采集模式的映射配置，请先配置", collectName);
    }
}
