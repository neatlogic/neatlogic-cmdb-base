/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.crossover;

import codedriver.framework.cmdb.dto.resourcecenter.entity.AppEnvironmentVo;
import codedriver.framework.crossover.ICrossoverService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IAppSystemMapper extends ICrossoverService {
    List<AppEnvironmentVo> getAppEnvListByAppSystemIdAndModuleIdList(@Param("appResourceId") Long appResourceId, @Param("moduleResourceIdList") List<Long> moduleIdList, @Param("schemaName") String schemaName);
}
