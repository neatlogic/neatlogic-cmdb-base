package codedriver.framework.cmdb.dto.transaction;

import codedriver.framework.cmdb.constvalue.EditModeType;
import codedriver.framework.cmdb.constvalue.RelActionType;
import codedriver.framework.cmdb.constvalue.RelDirectionType;
import codedriver.framework.cmdb.constvalue.TransactionActionType;
import codedriver.framework.cmdb.dto.cientity.CiEntityVo;
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

import java.util.ArrayList;
import java.util.List;

public class CiEntityTransactionVo {
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
    @JSONField(serialize = false)
    private transient TransactionActionType transactionMode;// 事务动作（删除、添加或修改）
    @EntityField(name = "编辑模式", type = ApiParamType.ENUM, member = EditModeType.class)
    private String editMode = EditModeType.GLOBAL.getValue();
    @EntityField(name = "操作", type = ApiParamType.ENUM, member = TransactionActionType.class)
    private String action;
    @EntityField(name = "操作文本", type = ApiParamType.STRING)
    private String actionText;
    @EntityField(name = "属性对象，以'attr_'+attrId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject attrEntityData;
    @EntityField(name = "关系对象，以'relfrom_'+relId或'relto_'+relId为key", type = ApiParamType.JSONOBJECT)
    private JSONObject relEntityData;
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
        JSONArray relList = relEntityData.getJSONArray("rel" + direction + "_" + relId);
        if (CollectionUtils.isNotEmpty(relList)) {
            List<Integer> removeList = new ArrayList<>();
            for (int i = 0; i < relList.size(); i++) {
                JSONObject relObj = relList.getJSONObject(i);
                if (relObj.getLong("ciEntityId").equals(targetId)) {
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

    /**
     * 判断关系是否存在
     *
     * @param relId     关系id
     * @param direction 方向
     * @param targetId  目标id
     * @return true/false
     */
    public boolean containRelEntityData(Long relId, String direction, Long targetId) {
        boolean isContain = false;
        JSONArray dataList = relEntityData.getJSONArray("rel" + direction + "_" + relId);
        if (CollectionUtils.isNotEmpty(dataList)) {
            for (int i = 0; i < dataList.size(); i++) {
                JSONObject d = dataList.getJSONObject(i);
                if (targetId.equals(d.getLong("ciEntityId"))) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 添加需要操作的关系事务
     *
     * @param relId      关系id
     * @param direction  方向
     * @param targetId   目标id
     * @param actionType 操作
     */
    public void addRelEntityData(Long relId, String direction, Long targetId, RelActionType actionType) {
        if (relEntityData == null) {
            relEntityData = new JSONObject();
        }

        if (!relEntityData.containsKey("rel" + direction + "_" + relId)) {
            JSONArray dataList = new JSONArray();
            relEntityData.put("rel" + direction + "_" + relId, dataList);
        }
        JSONArray dataList = relEntityData.getJSONArray("rel" + direction + "_" + relId);
        boolean isExists = false;
        for (int i = 0; i < dataList.size(); i++) {
            JSONObject obj = dataList.getJSONObject(i);
            if (obj.getLong("ciEntityId").equals(targetId)) {
                isExists = true;
                break;
            }
        }
        if (!isExists) {
            JSONObject newObj = new JSONObject();
            newObj.put("ciEntityId", targetId);
            newObj.put("action", actionType.getValue());
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

            JSONArray relDataList = relEntityData.getJSONArray("rel" + direction + "_" + relId);
            if (CollectionUtils.isNotEmpty(relDataList)) {
                for (int i = 0; i < relDataList.size(); i++) {
                    JSONObject relEntityObj = relDataList.getJSONObject(i);
                    RelEntityTransactionVo relEntityVo = new RelEntityTransactionVo();
                    relEntityVo.setRelId(relId);
                    if (direction.equals(RelDirectionType.FROM.getValue())) {
                        relEntityVo.setToCiEntityId(relEntityObj.getLong("ciEntityId"));
                        relEntityVo.setToCiEntityName(relEntityObj.getString("ciEntityName"));
                        relEntityVo.setDirection(RelDirectionType.FROM.getValue());
                        relEntityVo.setFromCiEntityId(this.getCiEntityId());
                    } else {
                        relEntityVo.setFromCiEntityId(relEntityObj.getLong("ciEntityId"));
                        relEntityVo.setFromCiEntityName(relEntityObj.getString("ciEntityName"));
                        relEntityVo.setDirection(RelDirectionType.TO.getValue());
                        relEntityVo.setToCiEntityId(this.getCiEntityId());
                    }
                    relEntityVo.setAction(relEntityObj.getString("action"));// 默认是添加关系
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

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }


    public String getSnapshot() {
        return snapshot;
    }

    public void setSnapshot(String snapshot) {
        this.snapshot = snapshot;
    }

    public String getName() {
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

    public TransactionActionType getTransactionMode() {
        return transactionMode;
    }

    public void setTransactionMode(TransactionActionType transactionMode) {
        this.transactionMode = transactionMode;
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
        return attrEntityData.getJSONObject("attr_" + attrId);
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
}
