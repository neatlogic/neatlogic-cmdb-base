/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.sync.SyncCiCollectionVo;
import neatlogic.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONObject;

public class CiUniqueAttrNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 6853526342242823864L;

    public CiUniqueAttrNotFoundException(String ciName) {
        super("配置项模型“{0}”缺少唯一属性，请设置", ciName);
    }

    public CiUniqueAttrNotFoundException(CiVo ciVo, AttrVo attrVo) {
        super("模型“{0}({1})”的唯一规则属性“{2}({3})”没有配置匹配字段，请先配置", ciVo.getLabel(), ciVo.getName(), attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueAttrNotFoundException(AttrVo attrVo) {
        super("唯一规则属性“{0}({1})”的值为空", attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueAttrNotFoundException(Long ciId, Long attrId) {
        super("获取模型“{0}”的配置项事务hash失败，唯一属性“{1}”没有值", ciId, attrId);
    }

    public CiUniqueAttrNotFoundException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo, String key, JSONObject dataObj) {
        super("配置“{0}->{1}({2})”的唯一键映射属性“{3}”的值不存在，原始数据：{4}", syncCiCollectionVo.getCollectionName(), ciVo.getLabel(), ciVo.getName(), key, dataObj.toString());
    }
}
