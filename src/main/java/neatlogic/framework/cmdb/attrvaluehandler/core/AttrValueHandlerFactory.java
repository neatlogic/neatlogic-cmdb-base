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

package neatlogic.framework.cmdb.attrvaluehandler.core;

import com.sun.istack.NotNull;
import neatlogic.framework.applicationlistener.core.ModuleInitializedListenerBase;
import neatlogic.framework.bootstrap.NeatLogicWebApplicationContext;
import neatlogic.framework.cmdb.dto.ci.AttrTypeVo;
import neatlogic.framework.cmdb.exception.attrtype.AttrTypeNotFoundException;
import neatlogic.framework.common.RootComponent;
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
                attrType.setCanSearch(handler.isCanSearch());
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
