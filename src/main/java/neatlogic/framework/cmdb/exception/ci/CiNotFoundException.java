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

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiNotFoundException extends ApiRuntimeException {
    public CiNotFoundException(Long ciId) {
        super("nfcec.cinotfoundexception.cinotfoundexception_a", ciId);
    }


    public CiNotFoundException(String ciName) {
        super("nfcec.cinotfoundexception.cinotfoundexception_a", ciName);
    }

    public CiNotFoundException(String ciName, String configurationPath, String actualPath) {
        super("nfcec.cinotfoundexception.cinotfoundexception_b", ciName, configurationPath, actualPath);
    }
}
