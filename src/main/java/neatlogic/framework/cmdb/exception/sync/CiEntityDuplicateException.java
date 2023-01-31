/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.exception.sync;

import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.exception.core.ApiRuntimeException;
import com.alibaba.fastjson.JSONObject;

import java.util.stream.Collectors;

public class CiEntityDuplicateException extends ApiRuntimeException {
    public CiEntityDuplicateException() {
        super("找到多个配置项，无法更新或添加");
    }

    public CiEntityDuplicateException(CiEntityVo attrConditionVo, JSONObject dataObj) {
        super("唯一规则：" + attrConditionVo.getAttrFilterList().stream().map(d -> d.getLabel() + "(" + d.getName() + ") " + d.getExpressionName() + " " + String.join(",", d.getValueList()))
                .collect(Collectors.joining(" 且 ")) + "在模型" + attrConditionVo.getCiLabel() + "(" + attrConditionVo.getCiName() + ")" + "中找到多个配置项，无法更新或添加，原始数据：" + dataObj.toString());
    }

}
