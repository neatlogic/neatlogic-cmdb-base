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

package neatlogic.framework.cmdb.exception.attr;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class AttrValueIrregularException extends ApiRuntimeException {

    public AttrValueIrregularException(AttrVo attrVo, String value) {
        super("nfcea.attrvalueirregularexception.attrvalueirregularexception_a", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName(), value, attrVo.getTypeText());
    }

    public AttrValueIrregularException(AttrVo attrVo, String value, String configurationPath, String actualPath) {
        super("nfcea.attrvalueirregularexception.attrvalueirregularexception_b", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName(), value, attrVo.getTypeText(), configurationPath, actualPath);
    }

    public AttrValueIrregularException(AttrVo attrVo, IllegalArgumentException error) {
        super("模型“{0}({1})”属性“{2}({3})”的值格式异常：{4}", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName(), error.getMessage());
    }

}
