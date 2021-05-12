/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.exception.core.ApiRuntimeException;

public class CiViewSettingFileIrregularException extends ApiRuntimeException {
    public CiViewSettingFileIrregularException(Exception ex) {
        super("虚拟模型配置文件内容不合法：" + ex.getMessage());
    }

    public CiViewSettingFileIrregularException(String nodeName) {
        super("虚拟模型配置文件缺少节点：" + nodeName);
    }

    public CiViewSettingFileIrregularException(String nodeName, String attrName) {
        super("虚拟模型配置文件" + nodeName + "节点缺少属性" + attrName);
    }
}
