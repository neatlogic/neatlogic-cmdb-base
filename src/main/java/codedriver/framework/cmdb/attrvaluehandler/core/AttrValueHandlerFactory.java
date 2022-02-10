/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.attrvaluehandler.core;

import codedriver.framework.applicationlistener.core.ModuleInitializedListenerBase;
import codedriver.framework.bootstrap.CodedriverWebApplicationContext;
import codedriver.framework.cmdb.dto.ci.AttrTypeVo;
import codedriver.framework.cmdb.exception.attrtype.AttrTypeNotFoundException;
import codedriver.framework.common.RootComponent;
import com.sun.istack.NotNull;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

@RootComponent
public class AttrValueHandlerFactory extends ModuleInitializedListenerBase {

    private static final Map<String, IAttrValueHandler> componentMap = new HashMap<>();
    private static final List<AttrTypeVo> attrTypeList = new ArrayList<>();

    /**
     * 返回属性类型列表
     *
     * @return 属性列表数组
     */
    public static List<AttrTypeVo> getAttrTypeList() {
        return attrTypeList;
    }

    /**
     * 返回处理器
     *
     * @param type 组件类型
     * @return 组件
     */
    public static IAttrValueHandler getHandler(@NotNull String type) {
        type = type.toLowerCase();
        if (componentMap.containsKey(type)) {
            return componentMap.get(type);
        } else {
            throw new AttrTypeNotFoundException(type);
        }
    }

    @Override
    public void onInitialized(CodedriverWebApplicationContext context) {
        Map<String, IAttrValueHandler> myMap = context.getBeansOfType(IAttrValueHandler.class);
        for (Map.Entry<String, IAttrValueHandler> entry : myMap.entrySet()) {
            IAttrValueHandler handler = entry.getValue();
            if (StringUtils.isNotBlank(handler.getType())) {
                componentMap.put(handler.getType(), handler);
                AttrTypeVo attrType = new AttrTypeVo();
                attrType.setName(handler.getType());
                attrType.setLabel(handler.getName());
                attrType.setIcon(handler.getIcon());
                attrType.setNeedConfig(handler.isNeedConfig());
                attrType.setNeedWholeRow(handler.isNeedWholeRow());
                attrType.setNeedTargetCi(handler.isNeedTargetCi());
                attrType.setSort(handler.getSort());
                attrTypeList.add(attrType);
            }
        }
        if (CollectionUtils.isNotEmpty(attrTypeList)) {
            attrTypeList.sort(Comparator.comparingInt(AttrTypeVo::getSort));
        }
    }

    @Override
    protected void myInit() {

    }
}
