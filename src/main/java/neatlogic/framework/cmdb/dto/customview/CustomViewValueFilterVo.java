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

import java.io.Serializable;

public class CustomViewValueFilterVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
    private String uuid;
    private String value;

    public CustomViewValueFilterVo() {
    }

    public CustomViewValueFilterVo(String _uuid, String _value) {
        uuid = _uuid;
        value = _value;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
