/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAttrCrossoverMapper extends ICrossoverService {
    List<AttrVo> getAttrByCiId(Long ciId);

    AttrVo getAttrByCiIdAndName(@Param("ciId") Long ciId, @Param("attrName") String attrName);

}
