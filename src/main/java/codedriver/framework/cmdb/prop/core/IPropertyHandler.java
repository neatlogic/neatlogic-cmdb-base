/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.prop.core;

import codedriver.framework.cmdb.enums.SearchExpression;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author:chenqiwei
 * @Time:Aug 27, 2020
 * @ClassName: IPropertyHandler
 * @Description: 模型属性定义处理器
 */
@Deprecated
public interface IPropertyHandler {
    public String getName();

    /**
     * @param @return
     * @return Boolean
     * @Author: chenqiwei
     * @Time: Aug 27, 2020
     * @Description: 是否支持作为搜索条件
     */
    public Boolean canSearch();

    /**
     * @param @return
     * @return SearchExpression[]
     * @Author: chenqiwei
     * @Time: Aug 27, 2020
     * @Description: 支持的搜索表达式
     */
    public SearchExpression[] getSupportExpression();

    /**
     * @param @param  valueList
     * @param @return
     * @return List<String>
     * @Author: chenqiwei
     * @Time: Sep 17, 2020
     * @Description: 将数据库中的值转换成页面显示的值
     */
    public default List<String> getDisplayValueList(List<String> dataList) {
        if (CollectionUtils.isNotEmpty(dataList)) {
            return dataList.stream().collect(Collectors.toList());
        } else {
            return null;
        }
    }

    /*
     * @Description: 返回真实value值的hash值，用于精确匹配检索，例如select的原始值是{value:'v',text:'t'}，真实值就是v
     * @Author: chenqiwei
     * @Date: 2021/3/17 6:47 下午
     * @Params: [value]
     * @Returns: java.lang.String
     **/
    public default String getValueHash(String value) {
        if (StringUtils.isNotBlank(value)) {
            return DigestUtils.md5DigestAsHex(value.toLowerCase().getBytes());
        } else {
            return null;
        }
    }

    /**
     * 将Excel中读取的值转换成数据库中的值
     *
     * @param values
     * @param config
     * @return
     */
    public Object getActualValue(List<String> values, JSONObject config) throws Exception;

}
