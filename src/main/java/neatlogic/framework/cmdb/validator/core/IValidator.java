/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
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
