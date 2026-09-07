package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.cmdb.dto.cientity.AttrEntityVo;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 根据配置项名称获取配置项
     *
     * @param ciEntityVo 配置项名称
     * @return 配置项列表
     */
    List<CiEntityVo> getCiEntityBaseInfoByName(CiEntityVo ciEntityVo);

    /**
     * 返回来源配置项引用的所有目标属性
     *
     * @param attrId         属性id
     * @param fromCiEntityId 来源配置项id
     * @param limit          限制数量
     * @return 属性列表
     */
    List<AttrEntityVo> getAttrEntityByAttrIdAndFromCiEntityId(@Param("fromCiEntityId") Long fromCiEntityId, @Param("attrId") Long attrId, @Param("limit") Long limit);

    /**
     * 根据id列表返回多个配置项基本信息
     *
     * @param ciEntityIdList 配置项id列表
     * @return 多个CiEntityVo
     */
    List<CiEntityVo> getCiEntityBaseInfoByIdList(@Param("ciEntityIdList") List<Long> ciEntityIdList);


    /**
     * 根据模型名称查询配置项个数
     *
     * @param ciName
     * @return
     */
    int getCiEntityIdListCountByCiName(@Param("ciName") String ciName);

    /**
     * 根据模型名称和配置项名称查询配置项ID
     *
     * @param ciName
     * @param ciEntityName
     * @return
     */
    Long getCiEntityIdByCiNameAndCiEntityName(@Param("ciName") String ciName, @Param("ciEntityName") String ciEntityName);

    /**
     * 根据配置项名称获取虚拟模型配置项
     *
     * @param ciEntityVo 条件
     * @return 配置项列表
     */
    List<CiEntityVo> getVirtualCiEntityBaseInfoByName(CiEntityVo ciEntityVo);

    List<CiEntityVo> getCiEntityListByCiIdListAndName(CiEntityVo ciEntityVo);
}
