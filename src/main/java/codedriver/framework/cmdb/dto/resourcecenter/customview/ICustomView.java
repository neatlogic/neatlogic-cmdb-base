/*
 * Copyright(c) 2022 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.customview;

import net.sf.jsqlparser.statement.select.PlainSelect;

/**
 * @author linbq
 * @since 2022/2/8 17:02
 **/
public interface ICustomView {
    /**
     * 视图名
     * @return
     */
    String getName();

    /**
     * 注释
     * @return
     */
    String getComment();

    /**
     * 组成视图的select部分
     * @return
     */
    PlainSelect getSql();
}
