/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.dto.ci;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.io.Serializable;

public class AttrTypeVo implements Serializable {

    @EntityField(name = "唯一标识", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "名称", type = ApiParamType.STRING)
    private String label;
    @EntityField(name = "图标", type = ApiParamType.STRING)
    private String icon;
    @EntityField(name = "是否需要关联目标模型", type = ApiParamType.BOOLEAN)
    private boolean needTargetCi;
    @EntityField(name = "是否需要配置页面", type = ApiParamType.BOOLEAN)
    private boolean needConfig;
    @EntityField(name = "是否需要一整行显示编辑组件", type = ApiParamType.BOOLEAN)
    private boolean needWholeRow;
    @EntityField(name = "排序", type = ApiParamType.INTEGER)
    private int sort;
    @EntityField(name = "支持搜索", type = ApiParamType.BOOLEAN)
    private boolean canSearch;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean getCanSearch() {
        return canSearch;
    }

    public void setCanSearch(boolean canSearch) {
        this.canSearch = canSearch;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean getNeedTargetCi() {
        return needTargetCi;
    }

    public void setNeedTargetCi(boolean needTargetCi) {
        this.needTargetCi = needTargetCi;
    }

    public boolean getNeedConfig() {
        return needConfig;
    }

    public void setNeedConfig(boolean needConfig) {
        this.needConfig = needConfig;
    }


    public boolean isNeedWholeRow() {
        return needWholeRow;
    }

    public void setNeedWholeRow(boolean needWholeRow) {
        this.needWholeRow = needWholeRow;
    }
}
