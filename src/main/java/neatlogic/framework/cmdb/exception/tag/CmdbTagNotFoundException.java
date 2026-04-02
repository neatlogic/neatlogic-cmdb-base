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

package neatlogic.framework.cmdb.exception.tag;

import neatlogic.framework.exception.core.ApiRuntimeException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

public class CmdbTagNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 3786989853074993108L;

    public CmdbTagNotFoundException(Long id) {
        super("标签：“{0}”不存在", id);
    }

    public CmdbTagNotFoundException(List<Long> idList) {
        super("标签：“{0}”不存在", String.join(",", CollectionUtils.collect(idList, String::valueOf)));
    }
}
