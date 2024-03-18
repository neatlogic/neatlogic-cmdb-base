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

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;
import neatlogic.framework.util.$;

public class CiIsAbstractedException extends ApiRuntimeException {

    public enum Type {
        DATA, UPDATEABSTRACT, UPDATEPARENT
    }

    public CiIsAbstractedException(Type type, String ciName) {
        super(getMessage(type, ciName));
    }

    public CiIsAbstractedException(CiVo ciVo, String configurationPath, String actualPath) {
        super("nfcec.ciisabstractedexception.ciisabstractedexception_a", ciVo.getLabel(), ciVo.getName(), configurationPath, actualPath);
    }

    private static String getMessage(Type type, String ciName) {
        if (type == Type.DATA) {
            return $.t("nfcec.ciisabstractedexception.data", ciName);
        } else if (type == Type.UPDATEABSTRACT) {
            return $.t("nfcec.ciisabstractedexception.updateabstract", ciName);
        } else {
            return $.t("nfcec.ciisabstractedexception.updateparent", ciName);
        }
    }

}
