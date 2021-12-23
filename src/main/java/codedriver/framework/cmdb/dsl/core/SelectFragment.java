/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dsl.core;

import codedriver.framework.util.SnowflakeUtil;
import net.sf.jsqlparser.statement.select.Select;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class SelectFragment {
    //是否驱动模型，驱动模型代表需要在第一位进行搜索
    private boolean isDriven;
    //模型到达路径，用于记录类似a.b.c之类的参数是经过了哪些属性或参数，用于生成cmdb_attrentity或cmdb_relentity的join关系
    private String ciPath;
    private String alias;
    private Select select;
    private Set<Long> attrCheckSet = new HashSet<>();//检查属性是否已经配置在select里了，因为模型有继承，没有用到属性模型可以不Join，提升检索效率

    public SelectFragment(Select select) {
        this.select = select;
    }

    public String getAlias() {
        if (StringUtils.isBlank(alias)) {
            alias = "item_" + SnowflakeUtil.uniqueLong();
        }
        return alias;
    }


    public Select getSelect() {
        return select;
    }

    public void setSelect(Select select) {
        this.select = select;
    }

    public String getCiPath() {
        return ciPath;
    }

    public void setCiPath(String ciPath) {
        this.ciPath = ciPath;
    }

    public boolean isAttrExists(Long attrId) {
        return this.attrCheckSet.contains(attrId);
    }

    public void addAttrToCheckSet(Long attrId) {
        this.attrCheckSet.add(attrId);
    }

}
