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

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.sync.SyncCiCollectionVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class UniqueAttrNotCertifyException extends ApiRuntimeException {
    public UniqueAttrNotCertifyException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo) {
        super("请确保配置“{0}->{1}({2})”中所有唯一规则属性都已经配置映射关系，并且集合中对应的属性值不能为空", syncCiCollectionVo.getCollectionName(), ciVo.getLabel(), ciVo.getName());
    }
}
