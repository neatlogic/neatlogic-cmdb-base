/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.customview;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.common.RootComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author linbq
 * @since 2022/2/9 14:25
 **/
@RootComponent
public class ResourceCustomViewFactory extends ModuleInitializedListenerBase {
    private static Logger logger = LoggerFactory.getLogger(ResourceCustomViewFactory.class);
    private static List<ICustomView> resultList = new ArrayList<>();

//    static {
//        Reflections reflections = new Reflections("codedriver.framework.cmdb.dto.resourcecenter.customview");
//        Set<Class<? extends ICustomView>> classSet = reflections.getSubTypesOf(ICustomView.class);
//        for (Class<? extends ICustomView> c : classSet) {
//            try {
//                resultList.add(c.newInstance());
//            } catch (Exception ex) {
//                logger.error(ex.getMessage(), ex);
//            }
//        }
//    }

    public static List<ICustomView> getCustomViewList() {
        return resultList;
    }

    @Override
    protected void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, ICustomView> myMap = context.getBeansOfType(ICustomView.class);
        for (Map.Entry<String, ICustomView> entry : myMap.entrySet()) {
            resultList.add(entry.getValue());
        }
    }

    @Override
    protected void myInit() {

    }
}
