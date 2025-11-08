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

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiViewSettingFileIrregularException extends ApiRuntimeException {
    private static final long serialVersionUID = 6974123602685866857L;

    public CiViewSettingFileIrregularException(Exception ex) {
        super("虚拟模型配置文件内容不合法：{0}", ex.getMessage());
    }

    public CiViewSettingFileIrregularException(String nodeName) {
        super("虚拟模型配置文件缺少节点：{0}", nodeName);
    }

    public CiViewSettingFileIrregularException(String nodeName, String attrName) {
        super("虚拟模型配置文件{0}节点缺少属性{1}", nodeName, attrName);
    }
}
