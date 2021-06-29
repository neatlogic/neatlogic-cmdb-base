/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.attrvaluehandler.core;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.cmdb.enums.SearchExpression;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.collections4.CollectionUtils;

public interface IAttrValueHandler {
    /**
     * 获取组件类型，通过组件类型找到实现类
     *
     * @return 组件类型
     */
    String getType();

    /**
     * 获取名称
     *
     * @return 名称
     */
    String getName();

    /**
     * 获取图标
     *
     * @return 图标
     */
    String getIcon();

    /**
     * 是否允许搜索
     *
     * @return boolean
     */
    boolean isCanSearch();

    /**
     * 是否允许输入
     *
     * @return boolean
     */
    boolean isCanInput();


    /**
     * 是否简单属性（例如文本，表格属性就是复杂属性）,简单属性才能作为下拉框的显示值字段
     *
     * @return boolean
     */
    boolean isSimple();

    /**
     * 是否需要一整行显示
     *
     * @return boolean
     */
    boolean isNeedWholeRow();

    /**
     * 是否需要关联目标模型
     *
     * @return boolean
     */
    boolean isNeedTargetCi();


    /**
     * 是否需要额外配置（模型配置的时候有额外配置，前端需要有对应vue组件）
     *
     * @return boolean
     */
    boolean isNeedConfig();

    /**
     * 返回用于显示的值（批量转换）
     *
     * @param attrVo    Attr设置
     * @param valueList 值列表
     * @return 显示值列表
     */
    default JSONArray getActualValueList(AttrVo attrVo, JSONArray valueList) {
        JSONArray returnValueList = new JSONArray();
        if (CollectionUtils.isNotEmpty(valueList)) {
            returnValueList.addAll(valueList);
        }
        return returnValueList;
    }

    /**
     * 获取搜索表达式
     *
     * @return 表达式数组
     */
    SearchExpression[] getSupportExpression();

    /**
     * 排序
     *
     * @return 序号
     */
    int getSort();

    /**
     * 将值转换成存储到数据库的形式
     *
     * @param valueList 显示数据
     * @return 用于保存的数据
     */
    default void transferValueListToSave(JSONArray valueList) {
    }

    /**
     * 将值转换成显示的形式
     *
     * @param valueList 数据库的数据
     * @return 用于显示数据
     */
    default void transferValueListToDisplay(JSONArray valueList) {
    }

    /**
     * 保存新属性后需要的自定义操作
     *
     * @param attrVo 属性配置
     */
    default void afterInsert(AttrVo attrVo) {
    }

    /**
     * 保存新属性后需要的自定义操作
     *
     * @param attrVo 属性配置
     */
    default void afterUpdate(AttrVo attrVo) {
    }

    /**
     * 删除新属性后需要的自定义操作
     *
     * @param attrVo 属性配置
     */
    default void afterDelete(AttrVo attrVo) {

    }
}
