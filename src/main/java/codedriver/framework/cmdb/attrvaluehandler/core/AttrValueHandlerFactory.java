package codedriver.framework.cmdb.attrvaluehandler.core;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import codedriver.framework.common.RootComponent;

@RootComponent
public class AttrValueHandlerFactory implements ApplicationListener<ContextRefreshedEvent> {

    private static final Map<String, IAttrValueHandler> componentMap = new HashMap<>();

    public static IAttrValueHandler getHandler(String protocol) {
        return componentMap.get(protocol);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        Map<String, IAttrValueHandler> myMap = context.getBeansOfType(IAttrValueHandler.class);
        for (Map.Entry<String, IAttrValueHandler> entry : myMap.entrySet()) {
            IAttrValueHandler validator = entry.getValue();
            if (StringUtils.isNotBlank(validator.getProtocol())) {
                componentMap.put(validator.getProtocol(), validator);
            }
        }
    }
}
