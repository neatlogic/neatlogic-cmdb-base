/*
 * Copyright(c) 2022 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.sync;

import codedriver.framework.cmdb.enums.RelActionType;
import codedriver.framework.cmdb.enums.RelDirectionType;
import codedriver.framework.cmdb.enums.sync.MatchMode;
import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import codedriver.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

public class SyncMappingVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "属性id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "关系id", type = ApiParamType.LONG)
    private Long relId;
    @EntityField(name = "关系方向", type = ApiParamType.ENUM, member = RelDirectionType.class)
    private String direction;
    @EntityField(name = "目标字段，支持jsonpath语法", type = ApiParamType.STRING)
    private String field;
    @EntityField(name = "模型集合id", type = ApiParamType.LONG)
    private Long ciCollectionId;
    @EntityField(name = "匹配模式", type = ApiParamType.ENUM, member = MatchMode.class)
    private String matchMode;
    @EntityField(name = "操作", type = ApiParamType.ENUM, member = RelActionType.class)
    private String action;//这里只支持insert和replace

    public Long getId() {
        if (id == null) {
            id = SnowflakeUtil.uniqueLong();
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getAttrId() {
        return attrId;
    }

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

   /* public static void main(String[] arg) {
        String parentKey = "abc.ab.a";
        String field = "a.b.c.d";
        int dotCount = parentKey.split("\\.").length;
        String tmp = "";
        String[] fields = field.split("\\.");
        for (int i = dotCount; i < fields.length; i++) {
            if (StringUtils.isNotBlank(tmp)) {
                tmp += ".";
            }
            tmp += fields[i];
        }
        System.out.println(tmp);
    }*/

    public String getField() {
        return field;
    }

    public String getField(String parentKey) {
        if (StringUtils.isNotBlank(field) && StringUtils.isNotBlank(parentKey)) {
            if (this.getMatchMode().equals(MatchMode.KEY.getValue())) {
                /*if (field.indexOf(parentKey) == 0) {
                    return field.substring(parentKey.length() + 1);
                }*/
                return field;
            } else if (this.getMatchMode().equals(MatchMode.LEVEL.getValue())) {
                int dotCount = parentKey.split("\\.").length;
                String[] fields = field.split("\\.");
                /*当前键值层次大于父键才进行替换，否则代表需要获取上层属性，直接返回原键值即可
                例如parentKey=A,field=C.B或C.B.E，最终会返回A.B和A.B.E，如果field=B，由于B不比A要多层级，所以直接返回B即可
                */
                if (fields.length > dotCount) {
                    String tmp = "";
                    for (int i = dotCount; i < fields.length; i++) {
                        if (StringUtils.isNotBlank(tmp)) {
                            tmp += ".";
                        }
                        tmp += fields[i];
                    }
                    return parentKey + "." + tmp;
                }
            }
        }
        return field;
    }

    public String getAction() {
        if (StringUtils.isBlank(action)) {
            action = RelActionType.INSERT.getValue();
        }
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Long getCiCollectionId() {
        return ciCollectionId;
    }

    public void setCiCollectionId(Long ciCollectionId) {
        this.ciCollectionId = ciCollectionId;
    }

    public String getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(String matchMode) {
        this.matchMode = matchMode;
    }
}
