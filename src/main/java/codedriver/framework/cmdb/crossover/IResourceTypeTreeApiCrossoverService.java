package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.ResourceTypeVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

public interface IResourceTypeTreeApiCrossoverService extends ICrossoverService {
    List<ResourceTypeVo> getResourceTypeList();
}
