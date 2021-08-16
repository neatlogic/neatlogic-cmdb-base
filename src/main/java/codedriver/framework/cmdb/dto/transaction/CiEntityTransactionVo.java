/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.transaction;

import codedriver.framework.cmdb.dto.ci.AttrVo;
import codedriver.framework.cmdb.dto.ci.RelVo;
import codedriver.framework.cmdb.dto.cientity.CiEntityVo;
import codedriver.framework.cmdb.enums.EditModeType;
import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.cmdb.enums.TransactionActionType;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CiEntityTransactionVo implements Serializable {
    static Logger logger = LoggerFactory.getLogger(CiEntityTransactionVo.class);
    @JSONField(serialize = false)
    private transient String ciEntityUuid;// 批量添加时的临时ID，由前端生成
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "模型id", type = ApiParamType.LONG)
    private Long ciId;
    @EntityField(name = "配置项id", type = ApiParamType.LONG)
    private Long ciEntityId;
    @EntityField(name = "配置项名称", type = ApiParamType.STRING)
    private String name;
    @EntityField(name = "事务id", type = ApiParamType.LONG)
    private Long transactionId;
    @EntityField(name = "编辑模式", type = ApiParamType.ENUM, member = EditModeType.class)
    private String editMode = EditModeType.GLOBAL.getValue();
    @EntityField(name = "操作(删除、添加或修改)", type = ApiParamType.ENUM, member = TransactionActionType.class)
    private String action;
    @EntityField(name = "操作文本", type = ApiParamType.STRING)
    private String actionText;
    @EntityField(name = "属性对象，以'attr_'+attrId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject attrEntityData;
    @EntityField(name = "关系对象，以'relfrom_'+relId或'relto_'+relId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject relEntityData;
    @EntityField(name = "更新属性数量", type = ApiParamType.INTEGER)
    private int updateAttrCount;
    @EntityField(name = "更新关系数量", type = ApiParamType.INTEGER)
    private int updateRelCount;
    @JSONField(serialize = false)
    private transient List<AttrEntityTransactionVo> attrEntityTransactionList;
    @JSONField(serialize = false)
    private transient List<RelEntityTransactionVo> relEntityTransactionList;
    @JSONField(serialize = false)
    private transient String snapshot;// 修改前的快照
    @JSONField(serialize = false)
    private transient String content;//修改内容
    @JSONField(serialize = false)
    private transient CiEntityVo oldCiEntityVo;//就配置项信息
    @JSONField(serialize = false)
    private transient boolean allowCommit;//是否允许提交

    public CiEntityTransactionVo() {

    }

    public CiEntityTransactionVo(CiEntityVo ciEntityVo) {
        ciId = ciEntityVo.getCiId();
        ciEntityId = ciEntityVo.getId();
    }

    /**
     * 从修改数据中提取attrEntityTransaction实例
     *
     * @param attrId 属性id
     * @return AttrEntityTransactionVo
     */
    @JSONField(serialize = false)
    public AttrEntityTransactionVo getAttrEntityTransactionByAttrId(Long attrId) {
        if (MapUtils.isNotEmpty(attrEntityData) && attrEntityData.containsKey("attr_" + attrId)) {
            JSONObject attrDataObj = attrEntityData.getJSONObject("attr_" + attrId);
            AttrEntityTransactionVo attrEntityVo = new AttrEntityTransactionVo();
            attrEntityVo.setAttrId(attrId);
            attrEntityVo.setAttrType(attrDataObj.getString("type"));
            attrEntityVo.setAttrName(attrDataObj.getString("name"));
            attrEntityVo.setAttrLabel(attrDataObj.getString("label"));
            attrEntityVo.setCiId(attrDataObj.getLong("ciId"));
            attrEntityVo.setCiEntityId(this.getCiEntityId());
            attrEntityVo.setTargetCiId(attrDataObj.getLong("targetCiId"));
            attrEntityVo.setSaveMode(attrDataObj.getString("saveMode"));
            attrEntityVo.setValueList(attrDataObj.getJSONArray("valueList"));
            return attrEntityVo;
        }
        return null;
    }

    public CiEntityVo getOldCiEntityVo() {
        return oldCiEntityVo;
    }

    public void setOldCiEntityVo(CiEntityVo oldCiEntityVo) {
        this.oldCiEntityVo = oldCiEntityVo;
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

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public Long getCiEntityId() {
        // 创建配置项的时候没有配置项id，则生成一个新id
        if (ciEntityId == null) {
            ciEntityId = SnowflakeUtil.uniqueLong();
        }
        return ciEntityId;
    }

    public void setCiEntityId(Long ciEntityId) {
        this.ciEntityId = ciEntityId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 根据属性id删除属性数据
     *
     * @param attrId 属性id
     */
    public void removeAttrEntityData(Long attrId) {
        attrEntityData.remove("attr_" + attrId);
    }

    /**
     * 根据关系id和方向删除关系
     *
     * @param relId     关系id
     * @param direction 方向
     */
    public void removeRelEntityData(Long relId, String direction) {
        relEntityData.remove("rel" + direction + "_" + relId);
    }

    /**
     * 根据关系id、方向和目标删除关系
     *
     * @param relId     关系id
     * @param direction 方向
     * @param targetId  目标id
     */
    public void removeRelEntityData(Long relId, String direction, Long targetId) {
        if (MapUtils.isNotEmpty(relEntityData) && relEntityData.containsKey("rel" + direction + "_" + relId) && relEntityData.getJSONObject("rel" + direction + "_" + relId).containsKey("valueList")) {
            JSONArray relList = relEntityData.getJSONObject("rel" + direction + "_" + relId).getJSONArray("valueList");
            if (CollectionUtils.isNotEmpty(relList)) {
                List<Integer> removeList = new ArrayList<>();
                for (int i = 0; i < relList.size(); i++) {
                    JSONObject relObj = relList.getJSONObject(i);
                    //如果是新增加目标则不会有ciEntityId,所以必须要判断ciEntityId是否为空
                    if (relObj.containsKey("ciEntityId") && relObj.getLong("ciEntityId").equals(targetId)) {
                        removeList.add(i);
                    }
                }
                for (int index : removeList) {
                    relList.remove(index);
                }
                if (CollectionUtils.isEmpty(relList)) {
                    relEntityData.remove("rel" + direction + "_" + relId);
                }
            }
        }
    }

    /**
     * 判断关系是否存在
     *
     * @param relId     关系id
     * @param direction 方向
     * @param targetId  目标id
     * @return true/false
     */
    public boolean containRelEntityData(Long relId, String direction, Long targetId) {
        if (MapUtils.isNotEmpty(relEntityData)) {
            JSONArray dataList = relEntityData.getJSONObject("rel" + direction + "_" + relId).getJSONArray("valueList");
            if (CollectionUtils.isNotEmpty(dataList)) {
                for (int i = 0; i < dataList.size(); i++) {
                    JSONObject d = dataList.getJSONObject(i);
                    if (targetId.equals(d.getLong("ciEntityId"))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 添加一个空的属性修改数据，用在删除属性创建事务数据的场景
     *
     * @param attrId 属性id
     */
    public void addAttrEntityData(Long attrId) {
        if (attrEntityData == null) {
            attrEntityData = new JSONObject();
        }
        if (!attrEntityData.containsKey("attr_" + attrId)) {
            JSONObject dataObj = new JSONObject();
            dataObj.put("valueList", new JSONArray());
            attrEntityData.put("attr_" + attrId, dataObj);
        }
    }

    /**
     * 添加一个属性数据项
     *
     * @param attrId    属性id
     * @param attrVo    属性定义
     * @param valueList 值列表
     */
    public void addAttrEntityData(Long attrId, AttrVo attrVo, JSONArray valueList) {
        if (attrEntityData == null) {
            attrEntityData = new JSONObject();
        }
        JSONObject attrObj = new JSONObject();
        attrObj.put("name", attrVo.getName());
        attrObj.put("label", attrVo.getLabel());
        attrObj.put("type", attrVo.getType());
        attrObj.put("ciId", attrVo.getCiId());
        attrObj.put("targetCiId", attrVo.getTargetCiId());
        attrObj.put("valueList", valueList);
        attrEntityData.put("attr_" + attrId, attrObj);
    }

    /**
     * 添加需要操作的关系事务
     *
     * @param relVo      关系
     * @param direction  方向
     * @param ciId       目标模型id
     * @param ciEntityId 目标配置项id
     */
    public void addRelEntityData(RelVo relVo, String direction, Long ciId, Long ciEntityId) {
        addRelEntityData(relVo, direction, ciId, ciEntityId, null, null);
    }

    /**
     * 添加需要操作的关系事务
     *
     * @param relVo        关系
     * @param direction    方向
     * @param ciId         目标模型id
     * @param ciEntityId   目标配置项id
     * @param ciEntityName 目标配置项名称
     * @param action       操作,需要是RelActionType中的枚举
     */
    public void addRelEntityData(RelVo relVo, String direction, Long ciId, Long ciEntityId, String ciEntityName, String action) {
        if (relEntityData == null) {
            relEntityData = new JSONObject();
        }

        if (!relEntityData.containsKey("rel" + direction + "_" + relVo.getId())) {
            JSONObject dataObj = new JSONObject();
            dataObj.put("valueList", new JSONArray());
            dataObj.put("name", direction.equals(RelDirectionType.FROM.getValue()) ? relVo.getToName() : relVo.getFromName());
            dataObj.put("label", direction.equals(RelDirectionType.FROM.getValue()) ? relVo.getToLabel() : relVo.getFromLabel());
            dataObj.put("direction", direction);
            dataObj.put("fromCiId", relVo.getFromCiId());
            dataObj.put("toCiId", relVo.getToCiId());
            relEntityData.put("rel" + direction + "_" + relVo.getId(), dataObj);
        }
        JSONArray dataList = relEntityData.getJSONObject("rel" + direction + "_" + relVo.getId()).getJSONArray("valueList");
        boolean isExists = false;
        for (int i = 0; i < dataList.size(); i++) {
            JSONObject obj = dataList.getJSONObject(i);
            //如果是新增加目标则不会有ciEntityId,所以必须要判断ciEntityId是否为空
            if (obj.containsKey("ciEntityId") && obj.getLong("ciEntityId").equals(ciEntityId)) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            JSONObject newObj = new JSONObject();
            newObj.put("ciEntityId", ciEntityId);
            newObj.put("ciEntityName", ciEntityName);
            newObj.put("ciId", ciId);
            newObj.put("action", action);
            dataList.add(newObj);
        }
    }

    public void removeAttrEntityData(List<AttrEntityTransactionVo> attrEntityTransactionList) {
        if (CollectionUtils.isNotEmpty(attrEntityTransactionList)) {
            for (AttrEntityTransactionVo attrEntityTransactionVo : attrEntityTransactionList) {
                if (attrEntityTransactionVo.equals(this.getAttrEntityTransactionByAttrId(attrEntityTransactionVo.getAttrId()))) {
                    this.removeAttrEntityData(attrEntityTransactionVo.getAttrId());
                }
            }
        }

    }

    public List<AttrEntityTransactionVo> getAttrEntityTransactionList() {
        attrEntityTransactionList = new ArrayList<>();
        if (MapUtils.isNotEmpty(attrEntityData)) {
            for (String key : attrEntityData.keySet()) {
                Long attrId = null;
                try {
                    attrId = Long.parseLong(key.replace("attr_", ""));
                } catch (Exception ex) {
                    logger.error(ex.getMessage(), ex);
                }
                if (attrId != null) {
                    attrEntityTransactionList.add(this.getAttrEntityTransactionByAttrId(attrId));
                }
            }
        }
        return attrEntityTransactionList;
    }

    /**
     * 根据关系id和方向获取关系实体列表
     *
     * @param relId     关系id
     * @param direction 方向
     * @return 关系实体列表
     */
    @JSONField(serialize = false)
    public List<RelEntityTransactionVo> getRelEntityTransactionByRelIdAndDirection(Long relId, String direction) {
        List<RelEntityTransactionVo> relEntityTransactionList = new ArrayList<>();
        if (MapUtils.isNotEmpty(this.relEntityData) && relEntityData.containsKey("rel" + direction + "_" + relId)) {
            JSONArray relDataList = relEntityData.getJSONObject("rel" + direction + "_" + relId).getJSONArray("valueList");
            if (CollectionUtils.isNotEmpty(relDataList)) {
                for (int i = 0; i < relDataList.size(); i++) {
                    JSONObject relEntityObj = relDataList.getJSONObject(i);
                    RelEntityTransactionVo relEntityVo = new RelEntityTransactionVo();
                    relEntityVo.setRelId(relId);
                    if (direction.equals(RelDirectionType.FROM.getValue())) {
                        relEntityVo.setToCiId(relEntityObj.getLong("ciId"));
                        relEntityVo.setToCiEntityId(relEntityObj.getLong("ciEntityId"));
                        relEntityVo.setToCiEntityName(relEntityObj.getString("ciEntityName"));
                        relEntityVo.setDirection(RelDirectionType.FROM.getValue());
                        relEntityVo.setFromCiEntityName(this.getName());
                        relEntityVo.setFromCiEntityId(this.getCiEntityId());
                        relEntityVo.setFromCiId(this.getCiId());
                    } else {
                        relEntityVo.setFromCiId(relEntityObj.getLong("ciId"));
                        relEntityVo.setFromCiEntityId(relEntityObj.getLong("ciEntityId"));
                        relEntityVo.setFromCiEntityName(relEntityObj.getString("ciEntityName"));
                        relEntityVo.setDirection(RelDirectionType.TO.getValue());
                        relEntityVo.setToCiEntityName(this.getName());
                        relEntityVo.setToCiEntityId(this.getCiEntityId());
                        relEntityVo.setToCiId(this.getCiId());
                    }
                    relEntityVo.setAction(relEntityObj.getString("action"));// 如果不提供，默认是添加关系
                    relEntityTransactionList.add(relEntityVo);
                }
            }
        }
        return relEntityTransactionList;
    }

    public List<RelEntityTransactionVo> getRelEntityTransactionList() {
        relEntityTransactionList = new ArrayList<>();
        if (MapUtils.isNotEmpty(relEntityData)) {
            for (String key : relEntityData.keySet()) {
                Long relId = null;
                String direction = "";
                if (key.startsWith("relfrom_")) {
                    direction = RelDirectionType.FROM.getValue();
                    relId = Long.parseLong(key.replace("relfrom_", ""));
                } else if (key.startsWith("relto_")) {
                    direction = RelDirectionType.TO.getValue();
                    relId = Long.parseLong(key.replace("relto_", ""));
                }
                if (relId != null) {
                    relEntityTransactionList.addAll(getRelEntityTransactionByRelIdAndDirection(relId, direction));
                }
            }
        }
        return relEntityTransactionList;
    }

    /**
     * 数据库写入时通过此方法取得json值
     *
     * @return json
     */
    @JSONField(serialize = false)
    public String getContent() {
        if (StringUtils.isBlank(content)) {
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("attrEntityData", this.getAttrEntityData());
            jsonObj.put("relEntityData", this.getRelEntityData());
            content = jsonObj.toJSONString();
        }
        return content;
    }

    public void setContent(String content) {
        if (StringUtils.isNotBlank(content)) {
            try {
                JSONObject jsonObj = JSONObject.parseObject(content);
                this.attrEntityData = jsonObj.getJSONObject("attrEntityData");
                this.relEntityData = jsonObj.getJSONObject("relEntityData");
            } catch (Exception ignored) {

            }
        }
    }

    public String getEditMode() {
        return editMode;
    }

    public void setEditMode(String editMode) {
        this.editMode = editMode;
    }

    public String getActionText() {
        if (StringUtils.isNotBlank(action) && StringUtils.isBlank(actionText)) {
            actionText = TransactionActionType.getText(action);
        }
        return actionText;
    }


    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    /**
     * 从快照中恢复数据
     */
    public boolean restoreSnapshot() {
        if (StringUtils.isNotBlank(snapshot)) {
            try {
                JSONObject jsonObj = JSONObject.parseObject(snapshot);
                this.attrEntityData = jsonObj.getJSONObject("attrEntityData");
                this.relEntityData = jsonObj.getJSONObject("relEntityData");
                return true;
            } catch (Exception ignored) {

            }
        }
        return false;
    }

    public String getName() {
        if (StringUtils.isBlank(name) && this.oldCiEntityVo != null) {
            name = this.oldCiEntityVo.getName();
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCiEntityUuid() {
        return ciEntityUuid;
    }

    public void setCiEntityUuid(String ciEntityUuid) {
        this.ciEntityUuid = ciEntityUuid;
    }


    public JSONObject getAttrEntityData() {
        return attrEntityData;
    }

    /**
     * 根据属性id获取属性数据
     *
     * @param attrId 属性id
     * @return 属性数据json
     */
    public JSONObject getAttrEntityDataByAttrId(Long attrId) {
        if (MapUtils.isNotEmpty(attrEntityData)) {
            return attrEntityData.getJSONObject("attr_" + attrId);
        } else {
            return null;
        }
    }

    /**
     * 根据关系id和方向获取关系数据
     *
     * @param relId     关系id
     * @param direction 方向
     * @return 关系数据json
     */
    public JSONObject getRelEntityDataByRelIdAndDirection(Long relId, String direction) {
        return relEntityData.getJSONObject("rel" + direction + "_" + relId);
    }

    public void setAttrEntityData(JSONObject attrEntityData) {
        this.attrEntityData = attrEntityData;
    }

    public JSONObject getRelEntityData() {
        return relEntityData;
    }

    public void setRelEntityData(JSONObject relEntityData) {
        this.relEntityData = relEntityData;
    }

    public int getUpdateAttrCount() {
        if (MapUtils.isNotEmpty(this.getAttrEntityData())) {
            return this.getAttrEntityData().keySet().size();
        } else {
            return 0;
        }
    }


    public int getUpdateRelCount() {
        if (MapUtils.isNotEmpty(this.getRelEntityData())) {
            return this.getRelEntityData().keySet().size();
        } else {
            return 0;
        }
    }

    public boolean isAllowCommit() {
        return allowCommit;
    }

    public void setAllowCommit(boolean allowCommit) {
        this.allowCommit = allowCommit;
    }
}
