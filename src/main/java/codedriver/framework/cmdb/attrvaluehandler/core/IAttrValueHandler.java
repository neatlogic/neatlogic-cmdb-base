/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.attrvaluehandler.core;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import com.alibaba.fastjson.JSONArray;

public interface IAttrValueHandler {
    /**
     * 获取组件类型，通过组件类型找到实现类
     *
     * @return 组件类型
     */
    String getType();


    /**
     * 返回用于显示的值（批量转换）
     *
     * @param attrVo    Attr设置
     * @param valueList 值列表
     * @return 显示值列表
     */
    JSONArray getActualValueList(AttrVo attrVo, JSONArray valueList);
}
