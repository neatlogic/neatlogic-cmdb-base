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

package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.cmdb.dto.sync.SyncCiCollectionVo;
import neatlogic.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONObject;

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

    public CiUniqueAttrNotFoundException(AttrVo attrVo, String configurationPath, String actualPath) {
        super("nfcec.ciuniqueattrnotfoundexception.ciuniqueattrnotfoundexception_f", attrVo.getCiLabel(), attrVo.getCiName(), attrVo.getLabel(), attrVo.getName(), configurationPath, actualPath);
    }

    public CiUniqueAttrNotFoundException(Long ciId, Long attrId) {
        super("nfcec.ciuniqueattrnotfoundexception.ciuniqueattrnotfoundexception_d", ciId, attrId);
    }

    public CiUniqueAttrNotFoundException(SyncCiCollectionVo syncCiCollectionVo, CiVo ciVo, String key, JSONObject dataObj) {
        super("nfcec.ciuniqueattrnotfoundexception.ciuniqueattrnotfoundexception_e", syncCiCollectionVo.getCollectionName(), ciVo.getLabel(), ciVo.getName(), key, dataObj.toString());
    }
}
