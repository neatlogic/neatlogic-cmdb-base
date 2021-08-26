/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.cientity;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.cmdb.dto.cientity.CiEntityVo;
import codedriver.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class CiEntityIsInUsedException extends ApiRuntimeException {
    public CiEntityIsInUsedException(List<AttrVo> attrList) {
        super("当前配置项已经被以下属性引用：" + attrList.stream().map(attr -> attr.getLabel() + "(" + attr.getCiLabel() + ")").collect(Collectors.joining(",")));
    }

    public CiEntityIsInUsedException(CiEntityVo ciEntityVo, List<AttrVo> attrList) {
        super("配置项“" + ciEntityVo.getName() + "”已被以下属性引用：" + attrList.stream().map(attr -> attr.getLabel() + "(" + attr.getCiLabel() + ")").collect(Collectors.joining(",")));
    }
}
