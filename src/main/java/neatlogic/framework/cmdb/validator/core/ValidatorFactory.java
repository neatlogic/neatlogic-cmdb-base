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
