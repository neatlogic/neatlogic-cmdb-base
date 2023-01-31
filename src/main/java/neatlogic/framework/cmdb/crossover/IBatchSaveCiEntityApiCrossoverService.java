/*
 * Copyright (c)  2022 TechSure Co.,Ltd.  All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.crossover;

import neatlogic.framework.crossover.ICrossoverService;
import com.alibaba.fastjson.JSONObject;

public interface IBatchSaveCiEntityApiCrossoverService extends ICrossoverService {

    Object myDoService(JSONObject jsonObj) throws Exception;

}
