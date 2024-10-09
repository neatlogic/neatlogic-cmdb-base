package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrItemVo;
import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrVo;
import neatlogic.framework.crossover.ICrossoverService;

import java.util.List;

public interface IGlobalAttrCrossoverMapper extends ICrossoverService {

    List<GlobalAttrVo> searchGlobalAttr(GlobalAttrVo globalAttrVo);

    List<GlobalAttrItemVo> searchGlobalAttrItem(GlobalAttrItemVo globalAttrItemVo);

    GlobalAttrItemVo getGlobalAttrItemById(Long id);
}
