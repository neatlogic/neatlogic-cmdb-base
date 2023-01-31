/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.sync.SyncCiCollectionVo;
import neatlogic.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONObject;

public class CiUniqueAttrNotFoundException extends ApiRuntimeException {

    public CiUniqueAttrNotFoundException(String ciName) {
        super("配置项模型“" + ciName + "”缺少唯一属性，请设置");
    }

    public CiUniqueAttrNotFoundException(CiVo ciVo, AttrVo attrVo) {
        super("模型“" + ciVo.getLabel() + "(" + ciVo.getName() + ")" + "”的唯一规则属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")" + "”没有配置匹配字段，请先配置");
    }

    public CiUniqueAttrNotFoundException(AttrVo attrVo) {
        super("唯一规则属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")" + "”的值为空");
    }

    public CiUniqueAttrNotFoundException(Long ciId, Long attrId) {
        super("获取模型“" + ciId + "”的配置项事务hash失败，唯一属性“" + attrId + "”没有值");
    }

    public CiUniqueAttrNotFoundException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo, String key, JSONObject dataObj) {
        super("配置“" + syncCiCollectionVo.getCollectionName() + "->" + ciVo.getLabel() + "(" + ciVo.getName() + ")”的唯一键映射属性“" + key + "”的值不存在，原始数据：" + dataObj.toString());
    }
}
