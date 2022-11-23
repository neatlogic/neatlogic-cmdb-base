/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */
package codedriver.framework.cmdb.crossover;

import codedriver.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author longrf
 * @date 2022/11/21 15:07
 */

public interface ISyncCrossoverMapper extends ICrossoverService {

    List<String> getSyncCiCollectionNameListByCiNameListAndCollectMode(@Param("ciNameList") List<String> ciNameList, @Param("collectMode") String collectMode);

}
