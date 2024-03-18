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

package neatlogic.framework.cmdb.dto.graph;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

public class GraphRelVo {
    @EntityField(name = "上游视图id", type = ApiParamType.LONG)
    private Long fromGraphId;
    @EntityField(name = "下游视图id", type = ApiParamType.STRING)
    private Long toGraphId;

    public Long getFromGraphId() {
        return fromGraphId;
    }

    public void setFromGraphId(Long fromGraphId) {
        this.fromGraphId = fromGraphId;
    }

    public Long getToGraphId() {
        return toGraphId;
    }

    public void setToGraphId(Long toGraphId) {
        this.toGraphId = toGraphId;
    }
}
