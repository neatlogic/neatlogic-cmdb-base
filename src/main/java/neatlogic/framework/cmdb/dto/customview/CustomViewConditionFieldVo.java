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

package neatlogic.framework.cmdb.dto.customview;

import java.io.Serial;
import java.io.Serializable;

public class CustomViewConditionFieldVo implements Serializable {
    //为了兼容导出数据时忽略版本
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private String alias;

    public CustomViewConditionFieldVo(String _name, String _type) {
        name = _name;
        type = _type;
    }

    public CustomViewConditionFieldVo(String _name, String _type, String _alias) {
        name = _name;
        type = _type;
        alias = _alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
