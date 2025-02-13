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

package neatlogic.framework.cmdb.resourcecenter.appmoduleresource.core;

import neatlogic.framework.cmdb.dto.resourcecenter.AppEnvVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceSearchVo;
import neatlogic.framework.cmdb.dto.resourcecenter.ResourceVo;
import neatlogic.framework.cmdb.resourcecenter.sceneview.core.Ordered;

import java.util.List;

public interface IAppModuleResource {

    /**
     * 资源模型类型
     * @return
     */
    String getName();

    /**
     * 是否启用该视图，客户模块可以通过该字段禁用该视图
     * @return
     */
    default boolean isEnable() {
        return true;
    }

    /**
     * 优先级，默认是最低优先级，客户模块可以通过设置该字段值为最高优先级来重写类型的取数逻辑
     * @return
     */
    default Ordered getOrdered() {
        return Ordered.LOWEST_PRECEDENCE;
    }

    List<ResourceVo> getResourceList(ResourceSearchVo searchVo);

    List<AppEnvVo> getAppEnvList(ResourceSearchVo searchVo);
}
