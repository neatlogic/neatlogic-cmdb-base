/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.customview.CustomViewAttrVo;
import codedriver.framework.cmdb.dto.customview.CustomViewConstAttrVo;
import codedriver.framework.cmdb.dto.customview.CustomViewVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

public interface ICustomViewCrossoverService extends ICrossoverService {
    //List<CustomViewCiVo> getCustomViewCiByCustomViewId(Long viewId);

    List<CustomViewAttrVo> getCustomViewAttrByCustomViewId(CustomViewAttrVo customViewAttrVo);

    List<CustomViewConstAttrVo> getCustomViewConstAttrByCustomViewId(CustomViewConstAttrVo customViewConstAttrVo);

    List<CustomViewVo> searchCustomView(CustomViewVo customViewVo);

}
