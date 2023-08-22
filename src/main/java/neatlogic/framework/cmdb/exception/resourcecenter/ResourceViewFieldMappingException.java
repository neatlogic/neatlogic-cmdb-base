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
        super("资源视图{0}中主模型未设置", viewName);
    }

    public ResourceViewFieldMappingException(String viewName, List<String> fieldNameList) {
        super("资源视图{0}中字段列表{1}未设置映射", viewName, String.join(",", fieldNameList));
    }

    public ResourceViewFieldMappingException(String viewName, String mainCi) {
        super("资源视图{0}中主模型{1}不存在", viewName, mainCi);
    }

//    public ResourceViewFieldMappingException(String viewName, String field, String type) {
//        super("资源视图{0}中字段{1}映射类型{2}不存在", viewName, field, type);
//    }

    public ResourceViewFieldMappingException(String viewName, String field, String attrName, String attrValue) {
        super("资源视图{0}中字段{1}的映射{2}值为{3}，设置不正确", viewName, field, attrName, attrValue);
    }
}
