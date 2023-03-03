/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package neatlogic.framework.cmdb.dao.ognl;

import neatlogic.framework.cmdb.dto.ci.RelVo;

import java.util.List;

/**
 * 用于判断rel是否存在relIdList中，如果存在才显示，提升查询配置项SQL性能
 */
public class IsRelInRelIdList {
    public static boolean isExists(RelVo relVo, List<Long> relIdList) {
        if (relVo != null && relIdList != null) {
            return relIdList.stream().anyMatch(d -> d != null && d.equals(relVo.getId()));
        }
        return true;
    }
}
