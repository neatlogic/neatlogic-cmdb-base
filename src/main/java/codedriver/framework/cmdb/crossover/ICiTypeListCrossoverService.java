package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.ci.CiVo;
import codedriver.framework.crossover.ICrossoverService;

import java.util.List;

public interface ICiTypeListCrossoverService  extends ICrossoverService {
    List<CiVo> getCiTypeList();
}
