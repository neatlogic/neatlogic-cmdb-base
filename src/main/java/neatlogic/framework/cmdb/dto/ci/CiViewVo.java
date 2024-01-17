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

package neatlogic.framework.cmdb.dto.ci;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.cmdb.enums.ShowType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.$;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CiViewVo implements Serializable {
    @EntityField(name = "term.cmdb.ciid", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "term.ciview.itemid", type = ApiParamType.LONG)
    private Long itemId;
    @EntityField(name = "term.ciview.name", type = ApiParamType.STRING)
    private String itemName;
    @EntityField(name = "term.ciview.label", type = ApiParamType.STRING)
    private String itemLabel;
    @EntityField(name = "term.ciview.alias", type = ApiParamType.STRING)
    private String alias;
    @EntityField(name = "term.ciview.type", type = ApiParamType.STRING)
    private String type;
    @EntityField(name = "common.typename", type = ApiParamType.STRING)
    private String typeText;
    @EntityField(name = "common.sort", type = ApiParamType.INTEGER)
    private Integer sort;
    @EntityField(name = "term.ciview.showtypedesc", type = ApiParamType.STRING)
    private String showType = ShowType.ALL.getValue();
    @EntityField(name = "term.ciview.alleditdesc", type = ApiParamType.INTEGER)
    private Integer allowEdit = 1;
    @EntityField(name = "term.ciview.showtypetext", type = ApiParamType.STRING)
    private String showTypeText;
    @JSONField(serialize = false)
    private List<String> showTypeList;
    @JSONField(serialize = false)
    private Integer isExtended;//是否继承
    @JSONField(serialize = false)
    private String uniqueKey;//用于去掉继承的关系，具体参考RelUtil

    public CiViewVo() {

    }

    public CiViewVo(Long ciId, String type) {
        this.ciId = ciId;
        this.type = type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Integer allowEdit) {
        this.allowEdit = allowEdit;
    }

    public String getUniqueKey() {
        return uniqueKey;
    }

    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey;
    }

    public Integer getIsExtended() {
        return isExtended;
    }

    public void setIsExtended(Integer isExtended) {
        this.isExtended = isExtended;
    }

    public void addShowType(String showType) {
        if (showTypeList == null) {
            showTypeList = new ArrayList<>();
        }
        if (!showTypeList.contains(showType)) {
            showTypeList.add(showType);
        }
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getTypeText() {
        if (StringUtils.isBlank(typeText) && StringUtils.isNotBlank(type)) {
            switch (type) {
                case "attr":
                    typeText = $.t("term.cmdb.attr");
                    break;
                case "const":
                    typeText = $.t("nfre.systemattrtype");
                    break;
                case "global":
                    typeText = $.t("term.cmdb.globalattr");
                    break;
                default:
                    typeText = $.t("term.cmdb.rel");
                    break;
            }
        }
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getShowTypeText() {
        if (StringUtils.isBlank(showTypeText) && StringUtils.isNotBlank(showType)) {
            showTypeText = ShowType.getText(showType);
        }
        return showTypeText;
    }

    public void setShowTypeText(String showTypeText) {
        this.showTypeText = showTypeText;
    }

    public List<String> getShowTypeList() {
        return showTypeList;
    }

    public void setShowTypeList(List<String> showTypeList) {
        this.showTypeList = showTypeList;
    }

    public String getItemLabel() {
        return itemLabel;
    }

    public String getAliasOrLabel() {
        if (StringUtils.isNotBlank(alias)) {
            return alias;
        } else {
            return itemLabel;
        }
    }

    public void setItemLabel(String itemLabel) {
        this.itemLabel = itemLabel;
    }

}
