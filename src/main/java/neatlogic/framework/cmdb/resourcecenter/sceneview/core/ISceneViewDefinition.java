/*
 * Copyright (C) 2025  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package neatlogic.framework.cmdb.resourcecenter.sceneview.core;

import java.util.List;

public interface ISceneViewDefinition {

    /**
     * 视图名称
     * @return
     */
    String getName();

    /**
     * 视图定义名称
     * @return
     */
    String getLabel();

    /**
     * 使用到该视图的功能列表
     * @return
     */
    List<String> getFunctionPathList();

    /**
     * 是否启用该视图，客户模块可以通过该字段禁用该视图
     * @return
     */
    default boolean isEnable() {
        return true;
    }

    /**
     * 优先级，默认是最低优先级，客户模块可以通过设置该字段值为最高优先级来重写该视图配置
     * @return
     */
    default Ordered getOrdered() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    List<SceneViewFieldVo> getFieldList();
}
