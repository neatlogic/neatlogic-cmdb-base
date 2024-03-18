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

package neatlogic.framework.cmdb.exception.cientity;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.stream.Collectors;

public class AttrEntityDuplicateException extends ApiRuntimeException {
    private static final long serialVersionUID = 2014077344222321741L;

    public AttrEntityDuplicateException(CiVo ciVo, String label, JSONArray valueList) {
        super("模型“{0}({1})“属性“{2}”值等于“{3}”的配置项已存在", ciVo.getLabel(), ciVo.getName(), label, valueList.stream().map(Object::toString).collect(Collectors.joining("”,“")));
    }

    public AttrEntityDuplicateException(CiVo ciVo, String label, List<String> valueList) {
        super("模型“{0}({1})“属性“{2}”值等于“{3}”的配置项已存在", ciVo.getLabel(), ciVo.getName(), label, String.join("”,“", valueList));
    }

}
