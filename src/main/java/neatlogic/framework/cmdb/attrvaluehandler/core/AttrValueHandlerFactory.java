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

package neatlogic.framework.cmdb.attrvaluehandler.core;

import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.cmdb.dto.ci.AttrTypeVo;
import neatlogic.framework.cmdb.exception.attrtype.AttrTypeNotFoundException;
import neatlogic.framework.common.RootComponent;
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
    public void onInitialized(NeatLogicWebApplicationContext context) {
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
