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

package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;

import java.util.List;

public class ResourceViewFieldMappingException extends ApiRuntimeException {

    private static final long serialVersionUID = 7793373552475922744L;

    public ResourceViewFieldMappingException(String viewName) {
        super("nfcer.resourceviewfieldmappingexception.resourceviewfieldmappingexception_a", viewName);
    }

    public ResourceViewFieldMappingException(String viewName, List<String> fieldNameList) {
        super("nfcer.resourceviewfieldmappingexception.resourceviewfieldmappingexception_b", viewName, String.join(",", fieldNameList));
    }

    public ResourceViewFieldMappingException(String viewName, String mainCi) {
        super("nfcer.resourceviewfieldmappingexception.resourceviewfieldmappingexception_c", viewName, mainCi);
    }

    public ResourceViewFieldMappingException(String viewName, String field, String attrName, String attrValue) {
        super("nfcer.resourceviewfieldmappingexception.resourceviewfieldmappingexception_d", viewName, field, attrName, attrValue);
    }
}
