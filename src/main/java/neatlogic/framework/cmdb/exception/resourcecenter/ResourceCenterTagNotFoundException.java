/*Copyright (C) 2023  深圳极向量科技有限公司 All Rights Reserved.

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
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class ResourceCenterTagNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 3633279262424771861L;

    public ResourceCenterTagNotFoundException(Long id) {
        super("标签：“{0}”不存在", id);
    }

    public ResourceCenterTagNotFoundException(List<Long> idList) {
        super("标签：“{0}”不存在", String.join(",", CollectionUtils.collect(idList, String::valueOf)));
    }
}
