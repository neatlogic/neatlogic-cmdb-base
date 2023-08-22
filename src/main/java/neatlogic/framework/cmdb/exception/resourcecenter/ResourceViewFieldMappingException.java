/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
