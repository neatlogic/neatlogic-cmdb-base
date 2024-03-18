/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

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
