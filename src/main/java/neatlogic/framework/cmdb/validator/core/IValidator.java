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
