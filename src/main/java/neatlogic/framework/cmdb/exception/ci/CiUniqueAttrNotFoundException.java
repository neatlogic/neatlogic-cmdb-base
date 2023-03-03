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
        super("exception.cmdb.ciuniqueattrnotfoundexception.1", ciName);
    }

    public CiUniqueAttrNotFoundException(CiVo ciVo, AttrVo attrVo) {
        super("exception.cmdb.ciuniqueattrnotfoundexception.2", ciVo.getLabel(), ciVo.getName(), attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueAttrNotFoundException(AttrVo attrVo) {
        super("exception.cmdb.ciuniqueattrnotfoundexception.3", attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueAttrNotFoundException(Long ciId, Long attrId) {
        super("exception.cmdb.ciuniqueattrnotfoundexception.4", ciId, attrId);
    }

    public CiUniqueAttrNotFoundException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo, String key, JSONObject dataObj) {
        super("exception.cmdb.ciuniqueattrnotfoundexception.5", syncCiCollectionVo.getCollectionName(), ciVo.getLabel(), ciVo.getName(), key, dataObj.toString());
    }
}
