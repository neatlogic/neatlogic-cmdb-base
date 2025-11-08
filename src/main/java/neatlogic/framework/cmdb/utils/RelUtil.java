/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.utils;

import neatlogic.framework.cmdb.dto.ci.CiViewVo;
import neatlogic.framework.cmdb.dto.ci.RelVo;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RelUtil {
    /**
     * 如果出现子模型引用父模型的情况，会由于继承关系出现两条关系，所以需要去除
     *
     * @param relList 关系列表
     * @return 关系列表
     */
    public static List<RelVo> ClearRepeatRel(List<RelVo> relList) {
        List<RelVo> originalRelList = relList.stream().filter(rel -> rel.getIsExtended().equals(0)).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(originalRelList)) {
            relList.removeIf(rel -> rel.getIsExtended().equals(1) && originalRelList.stream().anyMatch(er -> er.getFromCiId().equals(rel.getFromCiId()) && er.getToCiId().equals(rel.getToCiId())));
        }
        return relList;
    }

    public static List<CiViewVo> ClearCiViewRepeatRel(List<CiViewVo> ciViewList, Long ciId) {
        List<CiViewVo> originalRelList = ciViewList.stream().filter(view -> view.getIsExtended().equals(0) && view.getType().startsWith("rel")).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(originalRelList)) {
            //去掉和继承重复的关系
            ciViewList.removeIf(view -> view.getIsExtended().equals(1) && view.getType().startsWith("rel") && originalRelList.stream().anyMatch(er -> er.getUniqueKey().equals(view.getUniqueKey())));
        }
        if (ciId != null) {
            //去掉由于继承导致的循环关系（A关联B，同时A继承了B，导致最后变成A关联A的关系）
            ciViewList.removeIf(view -> view.getIsExtended().equals(1) &&
                    (
                            (
                                    view.getType().startsWith("relto")
                                            && StringUtils.isNotBlank(view.getUniqueKey())
                                            && Objects.equals(ciId, Long.parseLong(view.getUniqueKey().split("-")[0]))
                            ) || (
                                    view.getType().startsWith("relfrom")
                                            && StringUtils.isNotBlank(view.getUniqueKey())
                                            && Objects.equals(ciId, Long.parseLong(view.getUniqueKey().split("-")[1]))
                            )
                    )
            );
        }
        return ciViewList;
    }

    /*public static List<CiViewVo> ClearCiViewRepeatRel(List<CiViewVo> ciViewList) {
        return ClearCiViewRepeatRel(ciViewList, null);
    }*/
}
