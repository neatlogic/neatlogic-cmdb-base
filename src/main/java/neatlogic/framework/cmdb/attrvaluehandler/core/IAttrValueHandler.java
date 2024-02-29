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

package neatlogic.framework.cmdb.attrvaluehandler.core;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.enums.SearchExpression;
import neatlogic.framework.cmdb.exception.attr.AttrValueIrregularException;
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
     * 是否允许导入
     *
     * @return boolean
     */
    boolean isCanImport();

    /**
     * 是否允许排序
     *
     * @return boolean
     */
    boolean isCanSort();


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
    default void transferValueListToSave(AttrVo attrVo, JSONArray valueList) {
    }

    /**
     * 将值转换成显示的形式
     *
     * @param valueList 数据库的数据
     * @return 用于显示数据
     */
    default void transferValueListToDisplay(AttrVo attrVo, JSONArray valueList) {
    }

    /**
     * 将值转换成导出形式
     *
     * @param attrVo    属性
     * @param valueList 数据库的数据
     * @return 用户导出的数据
     */
    default JSONArray transferValueListToExport(AttrVo attrVo, JSONArray valueList) {
        return valueList;
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
     * 验证值是否合法，只会根据当前组件类型来判断值是否合法
     *
     * @return 是否合法
     */
    default boolean valid(AttrVo attrVo, JSONArray valueList) throws AttrValueIrregularException {
        return true;
    }

    /**
     * 删除新属性后需要的自定义操作
     *
     * @param attrVo 属性配置
     */
    default void afterDelete(AttrVo attrVo) {

    }
}
