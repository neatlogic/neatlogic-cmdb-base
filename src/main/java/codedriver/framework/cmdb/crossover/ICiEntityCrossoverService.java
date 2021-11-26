/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.cientity.CiEntityVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

public interface ICiEntityCrossoverService extends ICrossoverService {
    CiEntityVo getCiEntityById(Long ciId, Long ciEntityId);

    CiEntityVo getCiEntityById(CiEntityVo ciEntityVo);

    List<CiEntityVo> getCiEntityByIdList(CiEntityVo ciEntityVo);


    List<CiEntityVo> searchCiEntity(CiEntityVo ciEntityVo);

    List<Long> getCiEntityIdByCiId(CiEntityVo ciEntityVo);
}
