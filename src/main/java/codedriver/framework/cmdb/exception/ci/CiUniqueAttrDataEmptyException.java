/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.dto.sync.SyncCiCollectionVo;
import codedriver.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONObject;

public class CiUniqueAttrDataEmptyException extends ApiRuntimeException {

    public CiUniqueAttrDataEmptyException(String ciName) {
        super("配置项模型“" + ciName + "”缺少唯一属性，请设置");
    }

    public CiUniqueAttrDataEmptyException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo, String key, JSONObject dataObj) {
        super("配置“" + syncCiCollectionVo.getCollectionName() + "->" + ciVo.getLabel() + "(" + ciVo.getName() + ")”的唯一键映射属性“" + key + "”的值不存在，原始数据：" + dataObj.toString());
    }
}