/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.utils;

import neatlogic.framework.cmdb.dto.ci.CiViewVo;
import neatlogic.framework.cmdb.dto.ci.RelVo;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
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

    public static List<CiViewVo> ClearCiViewRepeatRel(List<CiViewVo> ciViewList) {
        List<CiViewVo> originalRelList = ciViewList.stream().filter(view -> view.getIsExtended().equals(0) && view.getType().startsWith("rel")).collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(originalRelList)) {
            ciViewList.removeIf(view -> view.getIsExtended().equals(1) && view.getType().startsWith("rel") && originalRelList.stream().anyMatch(er -> er.getUniqueKey().equals(view.getUniqueKey())));
        }
        return ciViewList;
    }
}
