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

package neatlogic.framework.cmdb.validator.core;

import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.exception.validator.AttrInValidatedException;
import neatlogic.framework.cmdb.exception.validator.ValidatorNotFoundException;
import com.alibaba.fastjson.JSONArray;
import org.springframework.util.ClassUtils;

/**
 * 属性验证接口
 */
public interface IValidator {
    /**
     * 验证入口
     *
     * @param attrVo    属性信息
     * @param valueList 属性值
     * @return 是否通过验证
     * @throws AttrInValidatedException 验证异常
     */
    boolean valid(AttrVo attrVo, JSONArray valueList) throws AttrInValidatedException, ValidatorNotFoundException;

    default String getClassName() {
        return ClassUtils.getUserClass(this.getClass()).getName();
    }

    /**
     * 获取组件中文名称
     *
     * @return 组件名称
     */
    String getName();

    /**
     * 获取组件配置表单
     *
     * @return 表单
     */
    JSONArray getForm();
}
