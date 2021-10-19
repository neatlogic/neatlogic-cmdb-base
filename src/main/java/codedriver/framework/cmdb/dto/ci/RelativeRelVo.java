/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.dto.ci;

import codedriver.framework.common.constvalue.ApiParamType;
import codedriver.framework.restful.annotation.EntityField;
import com.alibaba.fastjson.annotation.JSONField;
import org.apache.commons.lang3.StringUtils;

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
    @EntityField(name = "起点路径名称", type = ApiParamType.STRING)
    private String fromPathStr;
    @EntityField(name = "终点路径名称", type = ApiParamType.STRING)
    private String toPathStr;
    @JSONField(serialize = false)
    private String fullPath;

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

    public String getFromPathStr() {
        return fromPathStr;
    }

    public void setFromPathStr(String fromPathStr) {
        this.fromPathStr = fromPathStr;
    }

    public String getFullPath() {
        if (StringUtils.isBlank(fullPath) && StringUtils.isNotBlank(fromPath) && StringUtils.isNotBlank(toPath)) {
            fullPath = fromPath + ">" + toPath;
        }
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public String getToPathStr() {
        return toPathStr;
    }

    public void setToPathStr(String toPathStr) {
        this.toPathStr = toPathStr;
    }
}
