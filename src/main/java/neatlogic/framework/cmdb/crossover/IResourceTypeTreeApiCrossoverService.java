package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.resourcecenter.ResourceTypeVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

public interface IResourceTypeTreeApiCrossoverService extends ICrossoverService {
    List<ResourceTypeVo> getResourceTypeList();
}
