package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.cientity.match.CiEntityMatchCandidateVo;
import neatlogic.framework.cmdb.dto.cientity.match.CiEntityMatchConditionVo;
import neatlogic.framework.cmdb.dto.cientity.match.CiEntityMatchMetadataVo;
import neatlogic.framework.crossover.ICrossoverService;
import java.util.List;

/** 按模型属性严格查找配置项，不创建或修改配置项。 */
public interface ICiEntityMatchCrossoverService extends ICrossoverService {
    /** 用户态须有模型全量读取权限，权限不足抛出 CiEntityMatchReadPrivilegeException；模型失效按普通业务异常处理。 */
    void requireReadPrivilege(Long targetCiId);

    /** 校验全部属性仍属于目标模型并可直接匹配，返回最新元数据。 */
    CiEntityMatchMetadataVo validate(Long targetCiId, List<Long> attrIdList);

    /** 所有属性同时满足，属性的多个来源值任一相等；最多返回两个不同候选。 */
    List<CiEntityMatchCandidateVo> match(Long targetCiId, List<CiEntityMatchConditionVo> conditions);
}
