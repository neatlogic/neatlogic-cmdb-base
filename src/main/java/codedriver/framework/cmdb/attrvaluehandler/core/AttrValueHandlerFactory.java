/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.attrvaluehandler.core;

import codedriver.framework.common.RootComponent;
import com.sun.istack.NotNull;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.HashMap;
import java.util.Map;

@RootComponent
public class AttrValueHandlerFactory implements ApplicationListener<ContextRefreshedEvent> {

    private static final Map<String, IAttrValueHandler> componentMap = new HashMap<>();

    /**
     * 返回处理器
     *
     * @param type 组件类型
     * @return 如果找不到组件类型，返回default组件
     */
    public static IAttrValueHandler getHandler(@NotNull String type) {
        type = type.toLowerCase();
        if (componentMap.containsKey(type)) {
            return componentMap.get(type);
        } else {
            return componentMap.get("default");
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext context = event.getApplicationContext();
        Map<String, IAttrValueHandler> myMap = context.getBeansOfType(IAttrValueHandler.class);
        for (Map.Entry<String, IAttrValueHandler> entry : myMap.entrySet()) {
            IAttrValueHandler handler = entry.getValue();
            if (StringUtils.isNotBlank(handler.getType())) {
                componentMap.put(handler.getType(), handler);
            }
        }
    }
}
