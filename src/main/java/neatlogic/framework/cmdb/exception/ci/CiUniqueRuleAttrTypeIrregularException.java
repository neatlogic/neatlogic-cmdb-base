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

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiUniqueRuleAttrTypeIrregularException extends ApiRuntimeException {
    public CiUniqueRuleAttrTypeIrregularException(CiVo ciVo, AttrVo attrVo) {
        super("nfcec.ciuniqueruleattrtypeirregularexception.ciuniqueruleattrtypeirregularexception_a", ciVo.getLabel(), ciVo.getName(), attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueRuleAttrTypeIrregularException(AttrVo attrVo) {
        super("nfcec.ciuniqueruleattrtypeirregularexception.ciuniqueruleattrtypeirregularexception_b", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueRuleAttrTypeIrregularException(AttrVo attrVo, String configurationPath, String actualPath) {
        super("nfcec.ciuniqueruleattrtypeirregularexception.ciuniqueruleattrtypeirregularexception_c", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName(), configurationPath, actualPath);
    }
}
