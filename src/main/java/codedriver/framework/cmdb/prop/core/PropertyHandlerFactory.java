package codedriver.framework.cmdb.prop.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import codedriver.framework.common.RootComponent;

@RootComponent
public class PropertyHandlerFactory implements ApplicationListener<ContextRefreshedEvent> {

    private static final Map<String, IPropertyHandler> componentMap = new HashMap<>();

    public static IPropertyHandler getHandler(String handlerName) {
        return componentMap.get(handlerName);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        Map<String, IPropertyHandler> myMap = context.getBeansOfType(IPropertyHandler.class);
        for (Map.Entry<String, IPropertyHandler> entry : myMap.entrySet()) {
            IPropertyHandler handler = entry.getValue();
            if (StringUtils.isNotBlank(handler.getName())) {
                componentMap.put(handler.getName(), handler);
            }
        }
    }
}
