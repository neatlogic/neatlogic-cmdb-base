/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.validator.core;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class ValidatorFactory extends ModuleInitializedListenerBase {

    private static final Map<String, IValidator> componentMap = new HashMap<>();

    public static IValidator getValidator(String handler) {
        return componentMap.get(handler);
    }


    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IValidator> myMap = context.getBeansOfType(IValidator.class);
        for (Map.Entry<String, IValidator> entry : myMap.entrySet()) {
            IValidator validator = entry.getValue();
            if (StringUtils.isNotBlank(validator.getClassName())) {
                componentMap.put(validator.getClassName(), validator);
            }
        }
    }

    @Override
    protected void myInit() {

    }
}
