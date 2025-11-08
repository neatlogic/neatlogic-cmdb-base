/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.framework.cmdb.dto.ci;

import com.alibaba.fastjson.annotation.JSONField;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;
import neatlogic.framework.util.Md5Util;

import java.io.Serializable;

/**
 * 级联关系对象
 */
public class RelativeRelVo implements Serializable {
    //为了兼容导出数据时忽略版本
    private static final long serialVersionUID = 1L;
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
