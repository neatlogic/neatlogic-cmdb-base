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

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.nacos.client.naming.utils.CollectionUtils;
import neatlogic.framework.asynchronization.threadlocal.TenantContext;
import neatlogic.framework.cmdb.dto.cientity.CiEntityVo;
import neatlogic.framework.cmdb.enums.InputType;
import neatlogic.framework.cmdb.enums.RelRuleType;
import neatlogic.framework.cmdb.enums.SearchExpression;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.common.dto.ValueTextVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RelVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "关系类型", type = ApiParamType.LONG)
    private Long typeId;
    @EntityField(name = "关系类型名称", type = ApiParamType.STRING)
    private String typeText;
    @EntityField(name = "当前模型位置，from|to", type = ApiParamType.STRING)
    private String direction;
    @EntityField(name = "数据录入方式", type = ApiParamType.STRING)
    private String inputType = InputType.MT.getValue();
    @EntityField(name = "上游端模型id", type = ApiParamType.LONG)
    private Long fromCiId;
    @EntityField(name = "上游端模型图标", type = ApiParamType.STRING)
    private String fromCiIcon;
    @EntityField(name = "上游端模型唯一标识", type = ApiParamType.STRING)
    private String fromCiName;
    @EntityField(name = "上游端模型名称", type = ApiParamType.STRING)
    private String fromCiLabel;
    @EntityField(name = "上游端名称", type = ApiParamType.STRING)
    private String fromName;
    @EntityField(name = "上游端标签", type = ApiParamType.STRING)
    private String fromLabel;
    @EntityField(name = "别名", type = ApiParamType.STRING)
    private String alias;
    @EntityField(name = "上游端类型id", type = ApiParamType.LONG)
    private Long fromTypeId;
    @EntityField(name = "上游端规则", type = ApiParamType.STRING)
    private String fromRule;
    @EntityField(name = "上游端规则名称", type = ApiParamType.STRING)
    private String fromRuleText;
    @EntityField(name = "上游端分组id", type = ApiParamType.LONG)
    private Long fromGroupId;
    @EntityField(name = "上游端分组名称", type = ApiParamType.STRING)
    private String fromGroupName;
    @EntityField(name = "上游端是否唯一", type = ApiParamType.INTEGER)
    private Integer fromIsUnique;
    @EntityField(name = "上游端是否必填", type = ApiParamType.INTEGER)
    private Integer fromIsRequired;
    @EntityField(name = "上游端是否级联删除", type = ApiParamType.INTEGER)
    private Integer fromIsCascadeDelete;
    @EntityField(name = "上游端是否允许添加新配置项", type = ApiParamType.BOOLEAN)
    private Boolean fromAllowInsert;
    @EntityField(name = "上游端是否虚拟模型", type = ApiParamType.INTEGER)
    private Integer fromIsVirtual;
    @EntityField(name = "下游端模型id", type = ApiParamType.LONG)
    private Long toCiId;
    @EntityField(name = "下游端模型图标", type = ApiParamType.STRING)
    private String toCiIcon;
    @EntityField(name = "上游端模型唯一标识", type = ApiParamType.STRING)
    private String toCiName;
    @EntityField(name = "上游端模型名称", type = ApiParamType.STRING)
    private String toCiLabel;
    @EntityField(name = "下游端名称", type = ApiParamType.STRING)
    private String toName;
    @EntityField(name = "下游端标签", type = ApiParamType.STRING)
    private String toLabel;
    @EntityField(name = "下游端类型id", type = ApiParamType.LONG)
    private Long toTypeId;
    @EntityField(name = "下游端规则", type = ApiParamType.STRING)
    private String toRule;
    @EntityField(name = "下游端规则名称", type = ApiParamType.STRING)
    private String toRuleText;
    @EntityField(name = "下游端分组id", type = ApiParamType.LONG)
    private Long toGroupId;
    @EntityField(name = "下游端分组名称", type = ApiParamType.STRING)
    private String toGroupName;
    @EntityField(name = "下游端是否唯一", type = ApiParamType.INTEGER)
    private Integer toIsUnique;
    @EntityField(name = "下游端是否必填", type = ApiParamType.INTEGER)
    private Integer toIsRequired;
    @EntityField(name = "下游端是否级联删除", type = ApiParamType.INTEGER)
    private Integer toIsCascadeDelete;
    @EntityField(name = "下游端是否允许添加新配置项", type = ApiParamType.BOOLEAN)
    private Boolean toAllowInsert;
    @EntityField(name = "是否继承属性", type = ApiParamType.INTEGER)
    private Integer isExtended;
    @EntityField(name = "下游端是否虚拟模型", type = ApiParamType.INTEGER)
    private Integer toIsVirtual;
    @EntityField(name = "支持的搜索表达式列表", type = ApiParamType.JSONARRAY)
    private List<ValueTextVo> expressionList;
    @EntityField(name = "级联关系", type = ApiParamType.JSONARRAY)
    private List<RelativeRelVo> relativeRelList;
    @EntityField(name = "是否允许编辑", type = ApiParamType.INTEGER)
    private Integer allowEdit;
    @EntityField(name = "是否在拓扑图中显示", type = ApiParamType.INTEGER)
    private Integer isShowInTopo;
    @JSONField(serialize = false)
    private Long maxRelEntityCount = CiEntityVo.MAX_RELENTITY_COUNT;//限制查询时最多返回多少关系

    @EntityField(name = "当先关系的下一个关系", type = ApiParamType.JSONOBJECT)
    private RelVo nextRel;

    public RelVo() {

    }

    public RelVo(Long id, String direction) {
        this.id = id;
        this.direction = direction;
    }

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Long getMaxRelEntityCount() {
        return maxRelEntityCount;
    }

    public void setMaxRelEntityCount(Long maxRelEntityCount) {
        this.maxRelEntityCount = maxRelEntityCount;
    }

    public Integer getIsShowInTopo() {
        return isShowInTopo;
    }

    public void setIsShowInTopo(Integer isShowInTopo) {
        this.isShowInTopo = isShowInTopo;
    }

    public Integer getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Integer allowEdit) {
        this.allowEdit = allowEdit;
    }

    public List<RelativeRelVo> getRelativeRelList() {
        return relativeRelList;
    }

    public void setRelativeRelList(List<RelativeRelVo> relativeRelList) {
        this.relativeRelList = relativeRelList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Long getFromCiId() {
        return fromCiId;
    }

    public void setFromCiId(Long fromCiId) {
        this.fromCiId = fromCiId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public List<ValueTextVo> getExpressionList() {
        if (CollectionUtils.isEmpty(this.expressionList)) {
            expressionList = new ArrayList<>();
            for (SearchExpression expression : SearchExpression.values()) {
                if (expression == SearchExpression.LI || expression == SearchExpression.NL || expression == SearchExpression.NULL || expression == SearchExpression.NOTNULL) {//排除掉等于和不等于两种表达式
                    expressionList.add(new ValueTextVo(expression.getExpression(), expression.getText()));
                }
            }
        }
        return expressionList;
    }

    public String getFromLabel() {
        return fromLabel;
    }

    public void setFromLabel(String fromLabel) {
        this.fromLabel = fromLabel;
    }

    public Long getFromTypeId() {
        return fromTypeId;
    }

    public void setFromTypeId(Long fromTypeId) {
        this.fromTypeId = fromTypeId;
    }

    public String getFromRule() {
        return fromRule;
    }

    public void setFromRule(String fromRule) {
        this.fromRule = fromRule;
    }

    public Long getFromGroupId() {
        return fromGroupId;
    }

    public void setFromGroupId(Long fromGroupId) {
        this.fromGroupId = fromGroupId;
    }

    public Long getToCiId() {
        return toCiId;
    }

    public void setToCiId(Long toCiId) {
        this.toCiId = toCiId;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToLabel() {
        return toLabel;
    }

    public void setToLabel(String toLabel) {
        this.toLabel = toLabel;
    }

    public Long getToTypeId() {
        return toTypeId;
    }

    public void setToTypeId(Long toTypeId) {
        this.toTypeId = toTypeId;
    }

    public String getToRule() {
        return toRule;
    }

    public void setToRule(String toRule) {
        this.toRule = toRule;
    }

    public Long getToGroupId() {
        return toGroupId;
    }

    public void setToGroupId(Long toGroupId) {
        this.toGroupId = toGroupId;
    }

    public String getFromCiIcon() {
        return fromCiIcon;
    }

    public void setFromCiIcon(String fromCiIcon) {
        this.fromCiIcon = fromCiIcon;
    }

    public String getToCiIcon() {
        return toCiIcon;
    }

    public void setToCiIcon(String toCiIcon) {
        this.toCiIcon = toCiIcon;
    }

    public String getFromCiName() {
        return fromCiName;
    }

    public void setFromCiName(String fromCiName) {
        this.fromCiName = fromCiName;
    }

    public String getFromCiLabel() {
        return fromCiLabel;
    }

    public void setFromCiLabel(String fromCiLabel) {
        this.fromCiLabel = fromCiLabel;
    }

    public String getToCiName() {
        return toCiName;
    }

    public void setToCiName(String toCiName) {
        this.toCiName = toCiName;
    }

    public String getToCiLabel() {
        return toCiLabel;
    }

    public void setToCiLabel(String toCiLabel) {
        this.toCiLabel = toCiLabel;
    }

    public String getFromGroupName() {
        return fromGroupName;
    }

    public void setFromGroupName(String fromGroupName) {
        this.fromGroupName = fromGroupName;
    }

    public String getToGroupName() {
        return toGroupName;
    }

    public void setToGroupName(String toGroupName) {
        this.toGroupName = toGroupName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFromRuleText() {
        if (StringUtils.isNotBlank(fromRule) && StringUtils.isBlank(fromRuleText)) {
            fromRuleText = RelRuleType.getText(fromRule);
        }
        return fromRuleText;
    }

    public String getToRuleText() {
        if (StringUtils.isNotBlank(toRule) && StringUtils.isBlank(toRuleText)) {
            toRuleText = RelRuleType.getText(toRule);
        }
        return toRuleText;
    }

    public Integer getFromIsUnique() {
        return fromIsUnique;
    }

    public void setFromIsUnique(Integer fromIsUnique) {
        this.fromIsUnique = fromIsUnique;
    }

    public Integer getToIsUnique() {
        return toIsUnique;
    }

    public void setToIsUnique(Integer toIsUnique) {
        this.toIsUnique = toIsUnique;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public Boolean getFromAllowInsert() {
        return fromAllowInsert;
    }

    public void setFromAllowInsert(Boolean fromAllowInsert) {
        this.fromAllowInsert = fromAllowInsert;
    }

    public Boolean getToAllowInsert() {
        return toAllowInsert;
    }

    public void setToAllowInsert(Boolean toAllowInsert) {
        this.toAllowInsert = toAllowInsert;
    }

    public Integer getIsExtended() {
        return isExtended;
    }

    public void setIsExtended(Integer isExtended) {
        this.isExtended = isExtended;
    }

    public Integer getFromIsRequired() {
        return fromIsRequired;
    }

    public void setFromIsRequired(Integer fromIsRequired) {
        this.fromIsRequired = fromIsRequired;
    }

    public Integer getToIsRequired() {
        return toIsRequired;
    }

    public void setToIsRequired(Integer toIsRequired) {
        this.toIsRequired = toIsRequired;
    }

    public Integer getFromIsVirtual() {
        return fromIsVirtual;
    }

    public void setFromIsVirtual(Integer fromIsVirtual) {
        this.fromIsVirtual = fromIsVirtual;
    }

    public Integer getToIsVirtual() {
        return toIsVirtual;
    }

    public void setToIsVirtual(Integer toIsVirtual) {
        this.toIsVirtual = toIsVirtual;
    }

    @JSONField(serialize = false)
    public String getToCiTableName() {
        return TenantContext.get().getDataDbName() + ".`cmdb_" + this.getToCiId() + "`";
    }

    @JSONField(serialize = false)
    public String getFromCiTableName() {
        return TenantContext.get().getDataDbName() + ".`cmdb_" + this.getFromCiId() + "`";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelVo relVo = (RelVo) o;
        return id.equals(relVo.id) && direction.equals(relVo.direction);
    }

    public RelVo getNextRel() {
        return nextRel;
    }

    public void setNextRel(RelVo nextRel) {
        this.nextRel = nextRel;
    }

    public Integer getFromIsCascadeDelete() {
        return fromIsCascadeDelete;
    }

    public void setFromIsCascadeDelete(Integer fromIsCascadeDelete) {
        this.fromIsCascadeDelete = fromIsCascadeDelete;
    }

    public Integer getToIsCascadeDelete() {
        return toIsCascadeDelete;
    }

    public void setToIsCascadeDelete(Integer toIsCascadeDelete) {
        this.toIsCascadeDelete = toIsCascadeDelete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, direction);
    }
}
