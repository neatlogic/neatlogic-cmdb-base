package codedriver.framework.cmdb.validator.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import codedriver.framework.common.RootComponent;

@RootComponent
public class ValidatorFactory implements ApplicationListener<ContextRefreshedEvent> {

    private static final Map<String, IValidator> componentMap = new HashMap<>();

    public static IValidator getValidator(String handler) {
        return componentMap.get(handler);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        Map<String, IValidator> myMap = context.getBeansOfType(IValidator.class);
        for (Map.Entry<String, IValidator> entry : myMap.entrySet()) {
            IValidator validator = entry.getValue();
            if (StringUtils.isNotBlank(validator.getClassName())) {
                componentMap.put(validator.getClassName(), validator);
            }
        }
    }
}
