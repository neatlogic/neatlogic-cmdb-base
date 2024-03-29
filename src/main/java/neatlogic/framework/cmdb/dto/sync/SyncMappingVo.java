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

package neatlogic.framework.cmdb.dto.sync;

import neatlogic.framework.cmdb.enums.RelActionType;
import neatlogic.framework.cmdb.enums.RelDirectionType;
import neatlogic.framework.cmdb.enums.sync.MatchMode;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.SnowflakeUtil;
import org.apache.commons.lang3.StringUtils;

public class SyncMappingVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    private Long id;
    @EntityField(name = "nmcaa.getattrapi.input.param.desc.id", type = ApiParamType.LONG)
    private Long attrId;
    @EntityField(name = "nmcac.searchcientityapi.input.param.desc.relid", type = ApiParamType.LONG)
    private Long relId;
    @EntityField(name = "term.cmdb.globalattrid", type = ApiParamType.LONG)
    private Long globalAttrId;
    @EntityField(name = "term.rdm.reldirection", type = ApiParamType.ENUM, member = RelDirectionType.class)
    private String direction;
    @EntityField(name = "目标字段，支持jsonpath语法", type = ApiParamType.STRING)
    private String field;
    @EntityField(name = "模型集合id", type = ApiParamType.LONG)
    private Long ciCollectionId;
    @EntityField(name = "匹配模式", type = ApiParamType.ENUM, member = MatchMode.class)
    private String matchMode;
    @EntityField(name = "操作", type = ApiParamType.ENUM, member = RelActionType.class)
    private String action;

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

    public Long getGlobalAttrId() {
        return globalAttrId;
    }

    public void setGlobalAttrId(Long globalAttrId) {
        this.globalAttrId = globalAttrId;
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
