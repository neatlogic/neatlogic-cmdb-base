/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.cientityevent;

import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;

public interface ICiEntityEventHandler {

    /**
     * 获取处理器排序值，数值越小越早执行。
     */
    default int getSort() {
        return 0;
    }

    /**
     * 配置项创建后执行，默认空实现方便模块按需覆盖。
     */
    default void afterCreate(CiEntityVo ciEntityVo) {
    }

    /**
     * 配置项编辑后执行，默认空实现方便模块按需覆盖。
     */
    default void afterUpdate(CiEntityVo ciEntityVo) {
    }

    /**
     * 配置项删除后执行，默认空实现方便模块按需覆盖。
     */
    default void afterDelete(CiEntityVo ciEntityVo) {
    }

    /**
     * 配置项恢复后执行，默认空实现方便模块按需覆盖。
     */
    default void afterRecover(CiEntityVo ciEntityVo) {
    }
}
