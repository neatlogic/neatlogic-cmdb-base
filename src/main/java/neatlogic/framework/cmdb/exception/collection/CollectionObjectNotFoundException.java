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

package neatlogic.framework.cmdb.exception.collection;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CollectionObjectNotFoundException extends ApiRuntimeException {
    public CollectionObjectNotFoundException(String category, String type) {
        super("找不到大类为{0}，分类为{1}所对应的配置项模型", category, type);
    }

}
