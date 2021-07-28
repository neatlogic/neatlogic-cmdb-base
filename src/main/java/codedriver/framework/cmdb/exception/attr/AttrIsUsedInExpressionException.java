/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.attr;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class AttrIsUsedInExpressionException extends ApiRuntimeException {
    public AttrIsUsedInExpressionException(AttrVo attrVo) {
        super("当前属性已被表达式属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")" + "”引用，请先删除。");
    }

    public AttrIsUsedInExpressionException(CiVo ciVo, AttrVo attrVo) {
        super("当前属性已被模型“" + ciVo.getLabel() + "(" + ciVo.getName() + ")" + "”的表达式属性“" + attrVo.getLabel() + "(" + attrVo.getName() + ")" + "”引用，请先删除。");
    }

    public AttrIsUsedInExpressionException(List<AttrVo> attrList) {
        super("表达式属性“" + attrList.stream().map(a -> a.getLabel() + "(" + a.getName() + ")").collect(Collectors.joining("”,“")) + "”引用了父模型属性，请先删除。");
    }

}
