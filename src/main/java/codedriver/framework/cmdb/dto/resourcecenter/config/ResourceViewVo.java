/*
 * Copyright(c) 2022 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.resourcecenter.config;

/**
 * @author linbq
 * @since 2022/1/25 14:19
 **/
public class ResourceViewVo {
    private String name;
    private String label;
    private String sql;

    public ResourceViewVo() {

    }
    public ResourceViewVo(String name, String label, String sql) {
        this.name = name;
        this.label = label;
        this.sql = sql;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
