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

package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.cmdb.enums.resourcecenter.JoinType;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class ResourceCenterConfigIrregularException extends ApiRuntimeException {
    private static final long serialVersionUID = 7793373552474922744L;

    public ResourceCenterConfigIrregularException(Exception ex) {
        super("资源中心配置文件内容不合法：{0}", ex.getMessage());
    }

    public ResourceCenterConfigIrregularException(String resourceEntityName, String nodeName, String attrName) {
        super("资源节点：{0}缺少field为：{2}的{1}节点", resourceEntityName, nodeName, attrName);
    }

    public ResourceCenterConfigIrregularException(String resourceEntityName, JoinType joinType, String attrName) {
        super("资源节点：{0}的{1}节点缺少：{2}属性", resourceEntityName, joinType.getValue(), attrName);
    }

    public ResourceCenterConfigIrregularException(String resourceEntityName, String nodeName, String fieldName, String attrName) {
        super("资源节点：{0}中field为：{2}的{1}节点缺少属性：{3}", resourceEntityName, nodeName, fieldName, attrName);
    }

    public ResourceCenterConfigIrregularException(String nodeName, String attrName) {
        super("资源节点：{0}缺少属性：{1}", nodeName, attrName);
    }
}
