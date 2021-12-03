/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ICiCrossoverMapper extends ICrossoverService {
    List<CiVo> searchCi(CiVo ciVo);

    CiVo getCiByName(String ciName);

    List<CiVo> getDownwardCiListByLR(@Param("lft") Integer lft, @Param("rht") Integer rht);

    CiVo getCiById(Long ciId);
}
