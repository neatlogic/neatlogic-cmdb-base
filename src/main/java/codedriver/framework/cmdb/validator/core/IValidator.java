package codedriver.framework.cmdb.validator.core;

import java.util.List;

import org.springframework.util.ClassUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import codedriver.framework.cmdb.exception.validator.AttrInValidatedException;

/**
 * @Author:chenqiwei
 * @Time:Aug 20, 2020
 * @ClassName: IValidator
 * @Description: 属性验证接口
 */
public interface IValidator {
    /**
     * 
     * @Author: chenqiwei
     * @Time:Aug 20, 2020
     * @Description: 验证入口
     * @param @param
     *            value
     * @param @param
     *            validatorId
     * @param @return
     * @param @throws
     *            AttrInValidatedException
     * @return boolean
     */
    public boolean valid(String attrLabel, List<String> valueList, Long validatorId) throws AttrInValidatedException;

    public default String getClassName() {
        return ClassUtils.getUserClass(this.getClass()).getName();
    }

    /**
     * 
     * @Author: chenqiwei
     * @Time:Aug 20, 2020
     * @Description: 获取组件中文名称
     * @param @return
     * @return String
     */
    public String getName();

    /**
     * 
     * @Author: chenqiwei
     * @Time:Aug 20, 2020
     * @Description: 获取额外配置表单项
     * @param @return
     * @return String
     */
    public JSONArray getForm();
}
