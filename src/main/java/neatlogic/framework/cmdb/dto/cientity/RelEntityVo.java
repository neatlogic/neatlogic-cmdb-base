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

package neatlogic.framework.cmdb.dto.cientity;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.base.Objects;
import neatlogic.framework.cmdb.dto.transaction.RelEntityTransactionVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.common.dto.BasePageVo;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;

import java.util.Date;

public class RelEntityVo extends BasePageVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "关系id", type = ApiParamType.LONG)
    private Long relId;
    @EntityField(name = "关系对端唯一标识", type = ApiParamType.STRING)
    private String relName;
    @EntityField(name = "关系对端名称", type = ApiParamType.STRING)
    private String relLabel;
    @EntityField(name = "关系类型id", type = ApiParamType.LONG)
    private Long relTypeId;
    @EntityField(name = "关系类型名称", type = ApiParamType.STRING)
    private String relTypeName;
    @EntityField(name = "来源配置项id", type = ApiParamType.LONG)
    //@ESKey(type = ESKeyType.PKEY, name = "id")
    private Long fromCiEntityId;
    @EntityField(name = "来源配置项名称", type = ApiParamType.STRING)
    private String fromCiEntityName;
    @EntityField(name = "目标配置项id", type = ApiParamType.LONG)
    //@ESKey(type = ESKeyType.PKEY, name = "id")
    private Long toCiEntityId;
    @EntityField(name = "目标配置项名称", type = ApiParamType.STRING)
    private String toCiEntityName;
    @EntityField(name = "生效事务id", type = ApiParamType.LONG)
    private Long transactionId;
    @EntityField(name = "方向", type = ApiParamType.STRING)
    private String direction;
    @EntityField(name = "目标模型id", type = ApiParamType.LONG)
    private Long toCiId;
    @EntityField(name = "来源模型id", type = ApiParamType.LONG)
    private Long fromCiId;
    @EntityField(name = "来源模型图标", type = ApiParamType.STRING)
    private String fromCiIcon;
    @EntityField(name = "目标模型图标", type = ApiParamType.STRING)
    private String toCiIcon;
    @EntityField(name = "目标模型层级id", type = ApiParamType.LONG)
    private Long toCiTypeId;
    @EntityField(name = "来源模型层级id", type = ApiParamType.LONG)
    private Long fromCiTypeId;
    @JSONField(serialize = false)
    private Integer fromIndex;//用于给前面数据排序，searchCiEntity时使用可以提升效率，不用返回全部数据
    @JSONField(serialize = false)
    private Integer toIndex;//用于给前面数据排序，searchCiEntity时使用可以提升效率，不用返回全部数据
    @EntityField(name = "添加时间", type = ApiParamType.LONG)
    private Date insertTime;
    @EntityField(name = "过期时间", type = ApiParamType.LONG)
    private Date expiredTime;
    @EntityField(name = "有效天数，为空代表永远有效", type = ApiParamType.INTEGER)
    private Integer validDay;
    @JSONField(serialize = false)
    private String relativeRelHash;//级联关系路径
    @JSONField(serialize = false)
    private Long sourceRelEntityId;//级联关系的来源关系id

    public RelEntityVo() {

    }

    public RelEntityVo(RelEntityTransactionVo relEntityTransactionVo) {
        relId = relEntityTransactionVo.getRelId();
        fromCiEntityId = relEntityTransactionVo.getFromCiEntityId();
        toCiEntityId = relEntityTransactionVo.getToCiEntityId();
        direction = relEntityTransactionVo.getDirection();
        transactionId = relEntityTransactionVo.getTransactionId();
        validDay = relEntityTransactionVo.getValidDay();
    }

    public Long getSourceRelEntityId() {
        return sourceRelEntityId;
    }

    public void setSourceRelEntityId(Long sourceRelEntityId) {
        this.sourceRelEntityId = sourceRelEntityId;
    }

    public String getRelativeRelHash() {
        return relativeRelHash;
    }

    public void setRelativeRelHash(String relativeRelHash) {
        this.relativeRelHash = relativeRelHash;
    }

    public Long getToCiTypeId() {
        return toCiTypeId;
    }

    public void setToCiTypeId(Long toCiTypeId) {
        this.toCiTypeId = toCiTypeId;
    }

    public Long getFromCiTypeId() {
        return fromCiTypeId;
    }

    public void setFromCiTypeId(Long fromCiTypeId) {
        this.fromCiTypeId = fromCiTypeId;
    }

    public Integer getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(Integer fromIndex) {
        this.fromIndex = fromIndex;
    }

    public Integer getToIndex() {
        return toIndex;
    }

    public void setToIndex(Integer toIndex) {
        this.toIndex = toIndex;
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

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public Long getFromCiEntityId() {
        return fromCiEntityId;
    }

    public void setFromCiEntityId(Long fromCiEntityId) {
        this.fromCiEntityId = fromCiEntityId;
    }

    public Long getToCiEntityId() {
        return toCiEntityId;
    }

    public void setToCiEntityId(Long toCiEntityId) {
        this.toCiEntityId = toCiEntityId;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getFromCiEntityName() {
        return fromCiEntityName;
    }

    public void setFromCiEntityName(String fromCiEntityName) {
        this.fromCiEntityName = fromCiEntityName;
    }

    public String getToCiEntityName() {
        return toCiEntityName;
    }

    public void setToCiEntityName(String toCiEntityName) {
        this.toCiEntityName = toCiEntityName;
    }

    @Override
    public int hashCode() {
        String key = "";
        if (getRelId() != null) {
            key += getRelId() + "_";
        }
        if (getFromCiEntityId() != null) {
            key += getFromCiEntityId() + "_";
        }
        if (getToCiEntityId() != null) {
            key += getToCiEntityId() + "_";
        }
        /*if (StringUtils.isNotBlank(this.direction)) {
            key += this.direction;
        }*/
        return key.hashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof RelEntityVo)) {
            return false;
        }
        final RelEntityVo rel = (RelEntityVo) other;
        /* && Objects.equal(getDirection(), rel.getDirection())*/
        return Objects.equal(getRelId(), rel.getRelId()) && Objects.equal(getFromCiEntityId(), rel.getFromCiEntityId())
                && Objects.equal(getToCiEntityId(), rel.getToCiEntityId());
    }

    public Long getToCiId() {
        return toCiId;
    }

    public void setToCiId(Long toCiId) {
        this.toCiId = toCiId;
    }

    public Long getFromCiId() {
        return fromCiId;
    }

    public void setFromCiId(Long fromCiId) {
        this.fromCiId = fromCiId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getRelTypeId() {
        return relTypeId;
    }

    public void setRelTypeId(Long relTypeId) {
        this.relTypeId = relTypeId;
    }

    public String getRelTypeName() {
        return relTypeName;
    }

    public void setRelTypeName(String relTypeName) {
        this.relTypeName = relTypeName;
    }

    public String getRelName() {
        return relName;
    }

    public void setRelName(String relName) {
        this.relName = relName;
    }

    public String getRelLabel() {
        return relLabel;
    }

    public void setRelLabel(String relLabel) {
        this.relLabel = relLabel;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Integer getValidDay() {
        return validDay;
    }

    public void setValidDay(Integer validDay) {
        this.validDay = validDay;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }

    public void setExpiredTime(Date expiredTime) {
        this.expiredTime = expiredTime;
    }
}
