/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.exception.core.ApiRuntimeException;

public class CiUniqueAttrNotFoundException extends ApiRuntimeException {

    public CiUniqueAttrNotFoundException(String ciName) {
        super("配置项模型“" + ciName + "”缺少唯一属性，请设置");
    }

    public CiUniqueAttrNotFoundException(AttrVo attrVo, boolean isForSync) {
        super("唯一规则属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")" + "”没有配置映射关系，请先设置");
    }

    public CiUniqueAttrNotFoundException(AttrVo attrVo) {
        super("唯一规则属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")" + "”的值为空");
    }

    public CiUniqueAttrNotFoundException(Long ciId, Long attrId) {
        super("获取模型“" + ciId + "”的配置项事务hash失败，唯一属性“" + attrId + "”没有值");
    }
}
