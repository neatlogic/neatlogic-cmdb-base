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

package neatlogic.framework.cmdb.enums;

import neatlogic.framework.dependency.core.IFromType;
import neatlogic.framework.util.$;

/**
 * @author longrf
 * @date 2022/3/10 5:14 下午
 */
public enum CmdbFromType implements IFromType {
    CMDBCI("cmdbci", "cmdb模型"),
    CMDBCIATTR("cmdbciattr", "cmdb模型属性"),
    CMDBCUSTOMVIEW("cmdbcustomview", "cmdb自定义视图"),
    RESOURCE_ACCOUNT("resourceaccount", "资产账号");

    private final String value;
    private final String text;

    CmdbFromType(String value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 被调用者类型值
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * 被调用者类型名
     */
    @Override
    public String getText() {
        return $.t(text);
    }
}
