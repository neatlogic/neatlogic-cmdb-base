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

import neatlogic.framework.cmdb.dto.ci.AttrVo;

import java.util.List;

/**
 * 用于判断attr是否存在attrIdList中，如果存在才显示，提升查询配置项SQL性能
 */
public class IsAttrInAttrIdList {
    public static boolean isExists(AttrVo attrVo, List<Long> attrIdList) {
        if (attrVo != null && attrIdList != null) {
            return attrIdList.stream().anyMatch(d -> d != null && d.equals(attrVo.getId()));
        }
        return true;
    }
}
