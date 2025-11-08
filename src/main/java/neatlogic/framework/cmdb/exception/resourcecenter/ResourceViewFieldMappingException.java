/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
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
