/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package neatlogic.framework.cmdb.dto.ci;

import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.Md5Util;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

/**
 * 级联关系对象
 */
public class RelativeRelVo implements Serializable {
    @EntityField(name = "自增id", type = ApiParamType.LONG)//由于实际的唯一键是relId,relativeRelId,fromPath和toPath，所以增加一个id方便删除和引用
    private Long id;
    @EntityField(name = "关系id", type = ApiParamType.LONG)
    private Long relId;
    @EntityField(name = "目标关系id", type = ApiParamType.LONG)
    private Long relativeRelId;
    @EntityField(name = "关系名称", type = ApiParamType.STRING)
    private String relativeRelLabel;
    @EntityField(name = "起点路径", type = ApiParamType.STRING)
    private String fromPath;//从起点到达关系上游端的路径
    @EntityField(name = "终点路径", type = ApiParamType.STRING)
    private String toPath;//从终点到达关系下游端的路径
    @JSONField(serialize = false)
    private String fullPath;
    @EntityField(name = "整个关系路径的散列值", type = ApiParamType.STRING)
    private String hash;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRelativeRelId() {
        return relativeRelId;
    }

    public void setRelativeRelId(Long relativeRelId) {
        this.relativeRelId = relativeRelId;
    }

    public Long getRelId() {
        return relId;
    }

    public void setRelId(Long relId) {
        this.relId = relId;
    }

    public String getFromPath() {
        return fromPath;
    }

    public void setFromPath(String fromPath) {
        this.fromPath = fromPath;
    }

    public String getToPath() {
        return toPath;
    }

    public void setToPath(String toPath) {
        this.toPath = toPath;
    }

    public String getRelativeRelLabel() {
        return relativeRelLabel;
    }

    public void setRelativeRelLabel(String relativeRelLabel) {
        this.relativeRelLabel = relativeRelLabel;
    }


    public String getHash() {
        if (fromPath != null && toPath != null) {
            hash = Md5Util.encryptMD5(fromPath + ">" + toPath);
        }
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
