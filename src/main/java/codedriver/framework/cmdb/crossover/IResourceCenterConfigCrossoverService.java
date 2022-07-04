package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.config.ResourceEntityVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

/**
 * @author longrf
 * @date 2022/7/4 3:22 下午
 */
public interface IResourceCenterConfigCrossoverService extends ICrossoverService {

     List<ResourceEntityVo> getResourceCenterConfig();

}
