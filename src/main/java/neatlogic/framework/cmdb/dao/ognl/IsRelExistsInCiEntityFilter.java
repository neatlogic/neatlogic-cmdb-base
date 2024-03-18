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

package neatlogic.framework.cmdb.dao.ognl;

import neatlogic.framework.cmdb.dto.ci.RelVo;
import neatlogic.framework.cmdb.dto.cientity.RelCiEntityFilterVo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

/**
 * 用于判断rel是否存在relCiEntityFilterList中，如果存在才进行join，提升查询配置项SQL性能
 */
public class IsRelExistsInCiEntityFilter {
    public static boolean isExists(RelVo relVo, List<RelCiEntityFilterVo> relCiEntityFilterList) {
        if (relVo != null && CollectionUtils.isNotEmpty(relCiEntityFilterList)) {
            return relCiEntityFilterList.stream().anyMatch(d -> d != null && d.getRelId().equals(relVo.getId()) && d.getDirection().equals(relVo.getDirection()));
        }
        return false;
    }
}
