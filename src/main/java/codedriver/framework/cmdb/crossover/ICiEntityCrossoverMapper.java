package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.cientity.CiEntityVo;
import codedriver.framework.crossover.ICrossoverService;

/**
 * @author longrf
 * @date 2022/5/30 2:49 下午
 */
public interface ICiEntityCrossoverMapper extends ICrossoverService {

    /**
     * 获取配置项基本信息
     *
     * @param ciEntityId 配置项id
     * @return CiEntityVo
     */
    CiEntityVo getCiEntityBaseInfoById(Long ciEntityId);
}
