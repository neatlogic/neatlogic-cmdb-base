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

package neatlogic.framework.cmdb.attrvaluehandler.core;

import com.alibaba.fastjson.JSONArray;
import neatlogic.framework.cmdb.dto.ci.AttrVo;
import neatlogic.framework.cmdb.dto.cientity.AttrInvokeVo;
import neatlogic.framework.cmdb.enums.SearchExpression;
import neatlogic.framework.cmdb.exception.attr.AttrValueIrregularException;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

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
     * 属性值数据是否保存到cmdb_attr_invoke表。
     *
     * @return 默认不使用引用表存储
     */
    default boolean isInvokeAttr() {
        return false;
    }


    /**
     * 是否需要额外配置（模型配置的时候有额外配置，前端需要有对应vue组件）
     *
     * @return boolean
     */
    boolean isNeedConfig();

    /**
     * 是否允许成为名称属性
     *
     * @return boolean
     */
    boolean isNameAttr();

    /**
     * 是否允许成为唯一规则
     *
     * @return boolean
     */
    boolean isUniqueAttr();

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
     * 返回用于写入DB的值（批量转换）
     *
     * @param valueList 值列表
     * @return 显示值列表
     */
    default String getValue(JSONArray valueList) {
        if (CollectionUtils.isNotEmpty(valueList)) {
            if (valueList.size() == 1) {
                return valueList.getString(0);
            } else {
                return valueList.toString();
            }
        }
        return null;
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
     * 将值转换成存储形式，并提供当前配置项ID供外部存储属性稳定其引用ID。
     */
    default void transferValueListToSave(AttrVo attrVo, Long ciEntityId, JSONArray valueList) {
        transferValueListToSave(attrVo, valueList);
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
     * 将值转换成前端控件需要的格式
     *
     * @param attrVo
     * @param value
     */
    default Object transferValueListToInput(AttrVo attrVo, Object value) {
        return value;
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

    /**
     * 将属性值转换为独立引用索引。
     *
     * @param attrVo     属性定义
     * @param ciEntityId 配置项ID
     * @param valueList  属性值
     * @return 引用索引列表
     */
    default List<AttrInvokeVo> convertValueListToAttrInvokeList(AttrVo attrVo, Long ciEntityId, JSONArray valueList) {
        return Collections.emptyList();
    }

    /**
     * 将独立引用索引还原为属性值。
     *
     * @param attrVo        属性定义
     * @param attrInvokeList 引用索引列表
     * @return 属性值
     */
    default JSONArray convertAttrInvokeListToValueList(AttrVo attrVo, List<AttrInvokeVo> attrInvokeList) {
        return new JSONArray();
    }

    /**
     * 保存配置项后，在配置项事务内执行的自定义操作。
     */
    default void afterSaveCiEntity(AttrVo attrVo, JSONArray newValueList, JSONArray oldValueList) {
    }

    /**
     * 保存配置项后，在配置项事务内执行的自定义操作。
     */
    default void afterSaveCiEntity(AttrVo attrVo, Long ciEntityId, JSONArray newValueList, JSONArray oldValueList) {
        afterSaveCiEntity(attrVo, newValueList, oldValueList);
    }

    /**
     * 删除配置项后，在配置项事务内执行的自定义操作。
     */
    default void afterDeleteCiEntity(AttrVo attrVo, JSONArray valueList) {
    }

    /**
     * 删除配置项后，在配置项事务内执行的自定义操作。
     */
    default void afterDeleteCiEntity(AttrVo attrVo, Long ciEntityId, JSONArray valueList) {
        afterDeleteCiEntity(attrVo, valueList);
    }
}
