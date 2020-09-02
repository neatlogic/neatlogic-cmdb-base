package codedriver.framework.cmdb.prop.core;

import java.util.List;

import codedriver.framework.cmdb.constvalue.SearchExpression;

/**
 * @Author:chenqiwei
 * @Time:Aug 27, 2020
 * @ClassName: IPropertyHandler
 * @Description: 模型属性定义处理器
 */
public interface IPropertyHandler {
    public String getName();

    /**
     * @Author: chenqiwei
     * @Time:Aug 27, 2020
     * @Description: 是否支持作为搜索条件
     * @param @return
     * @return Boolean
     */
    public Boolean canSearch();

    /**
     * @Author: chenqiwei
     * @Time:Aug 27, 2020
     * @Description: 支持的搜索表达式
     * @param @return
     * @return SearchExpression[]
     */
    public SearchExpression[] getSupportExpression();

    /**
     * @Author: chenqiwei
     * @Time:Sep 2, 2020
     * @Description: 转换value到valueList里
     * @param @param
     *            value
     * @param @return
     * @return List<String>
     */
    public List<String> transferValue(Object value);
}
