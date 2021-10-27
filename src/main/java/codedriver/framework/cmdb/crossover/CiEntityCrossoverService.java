/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.cientity.CiEntityVo;
import codedriver.framework.crossover.ICrossoverService;

public interface CiEntityCrossoverService extends ICrossoverService {
    CiEntityVo getCiEntityById(Long ciId, Long ciEntityId);
}
