/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.prop.core;

import codedriver.framework.cmdb.exception.property.PropertyHandlerNotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class PropertyHandlerFactory implements ApplicationListener<ContextRefreshedEvent> {

    private static final Map<String, IPropertyHandler> componentMap = new HashMap<>();

    public static IPropertyHandler getHandler(String handlerName) {
        IPropertyHandler handler = componentMap.get(handlerName);
        if (handler == null) {
            throw new PropertyHandlerNotFoundException(handlerName);
        } else {
            return handler;
        }
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
