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

package neatlogic.framework.cmdb.exception.ci;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.sync.SyncCiCollectionVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiUniqueAttrNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 6853526342242823864L;

    public CiUniqueAttrNotFoundException(String ciName) {
        super("nfcec.ciuniqueattrnotfoundexception.ciuniqueattrnotfoundexception_a", ciName);
    }

    public CiUniqueAttrNotFoundException(CiVo ciVo, AttrVo attrVo) {
        super("nfcec.ciuniqueattrnotfoundexception.ciuniqueattrnotfoundexception_b", ciVo.getLabel(), ciVo.getName(), attrVo.getLabel(), attrVo.getName());
    }


    public CiUniqueAttrNotFoundException(AttrVo attrVo) {
        super("nfcec.ciuniqueattrnotfoundexception.ciuniqueattrnotfoundexception_c", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName());
    }

    public CiUniqueAttrNotFoundException(Long ciId, Long attrId) {
        super("nfcec.ciuniqueattrnotfoundexception.ciuniqueattrnotfoundexception_d", ciId, attrId);
    }

    public CiUniqueAttrNotFoundException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo, String key, JSONObject dataObj) {
        super("nfcec.ciuniqueattrnotfoundexception.ciuniqueattrnotfoundexception_e", syncCiCollectionVo.getCollectionName(), ciVo.getLabel(), ciVo.getName(), key, dataObj.toString());
    }
}
