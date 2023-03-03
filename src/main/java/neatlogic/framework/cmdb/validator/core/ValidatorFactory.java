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

package neatlogic.framework.cmdb.validator.core;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.common.RootComponent;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RootComponent
public class ValidatorFactory extends ModuleInitializedListenerBase {

    private static final Map<String, IValidator> componentMap = new HashMap<>();
    private static final List<IValidator> componentList = new ArrayList<>();

    public static IValidator getValidator(String handler) {
        return componentMap.get(handler);
    }

    public static List<IValidator> getValidatorHandlerList() {
        return componentList;
    }


    @Override
    protected void onInitialized(NeatLogicWebApplicationContext context) {
        Map<String, IValidator> myMap = context.getBeansOfType(IValidator.class);
        for (Map.Entry<String, IValidator> entry : myMap.entrySet()) {
            IValidator validator = entry.getValue();
            if (StringUtils.isNotBlank(validator.getClassName())) {
                componentMap.put(validator.getClassName(), validator);
                componentList.add(validator);
            }
        }
    }

    @Override
    protected void myInit() {

    }
}
