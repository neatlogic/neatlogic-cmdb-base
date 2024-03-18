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

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.stream.Collectors;

public class CiEntityDuplicateException extends ApiRuntimeException {
    private static final long serialVersionUID = -5366776714628472298L;

    public CiEntityDuplicateException() {
        super("找到多个配置项，无法更新或添加");
    }

    public CiEntityDuplicateException(CiEntityVo attrConditionVo, JSONObject dataObj) {
        super("唯一规则：{0} 在模型{1}({2})中找到多个配置项，无法更新或添加，原始数据：{3}",
                attrConditionVo.getAttrFilterList().stream().map(d -> d.getLabel() + "(" + d.getName() + ") " + d.getExpressionName() + " " + String.join(",", d.getValueList()))
                .collect(Collectors.joining(" and ")), attrConditionVo.getCiLabel(), attrConditionVo.getCiName(), dataObj.toString());
    }

}
