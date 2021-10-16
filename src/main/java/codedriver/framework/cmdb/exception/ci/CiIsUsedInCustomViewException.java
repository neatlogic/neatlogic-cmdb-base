/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.ci;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.cmdb.dto.customview.CustomViewVo;
import codedriver.framework.exception.core.ApiRuntimeException;

import java.util.List;
import java.util.stream.Collectors;

public class CiIsUsedInCustomViewException extends ApiRuntimeException {
    public CiIsUsedInCustomViewException(CiVo ciVo, List<CustomViewVo> viewList) {
        super("模型“" + ciVo.getLabel() + "(" + ciVo.getName() + ")”已被自定义视图“" + viewList.stream().map(CustomViewVo::getName).collect(Collectors.joining("”,“")) + "”引用，请先删除");
    }
}
