/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

public class ResourceCenterConfigIrregularException extends ApiRuntimeException {
    public ResourceCenterConfigIrregularException(Exception ex) {
        super("资源中心配置文件内容不合法：" + ex.getMessage());
    }

    public ResourceCenterConfigIrregularException(String resourceEntityName, String nodeName, String attrName) {
        super("资源节点：" + resourceEntityName + "缺少field为：" + attrName + "的" + nodeName + "节点");
    }

    public ResourceCenterConfigIrregularException(String resourceEntityName, String nodeName, String fieldName, String attrName) {
        super("资源节点：" + resourceEntityName + "中field为：" + fieldName + "的" + nodeName + "节点缺少属性：" + attrName);
    }

    public ResourceCenterConfigIrregularException(String nodeName, String attrName) {
        super("资源节点：" + nodeName + "缺少属性：" + attrName);
    }

    public ResourceCenterConfigIrregularException(String resourceEntityName) {
        super("资源中心配置文件缺少：" + resourceEntityName + "的定义");
    }
}
