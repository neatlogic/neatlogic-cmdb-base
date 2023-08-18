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

package neatlogic.framework.cmdb.dto.resourcecenter.sceneviewfielddeclare;

import com.alibaba.fastjson.JSONObject;
import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityConfigVo;
import neatlogic.framework.cmdb.dto.resourcecenter.config.ResourceEntityFieldMappingVo;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

import java.util.ArrayList;
import java.util.List;

@ResourceType(name = "scence_env", label = "环境场景")
public class EnvVo {
    @EntityField(name = "id", type = ApiParamType.LONG)
    @ResourceField(name = "id")
    private Long id;

    @EntityField(name = "名称", type = ApiParamType.STRING)
    @ResourceField(name = "name")
    private String name;

    @EntityField(name = "序号", type = ApiParamType.STRING)
    @ResourceField(name = "env_seq_no")
    private String envSeqNo;

    @EntityField(name = "描述", type = ApiParamType.STRING)
    @ResourceField(name = "description")
    private String description;

    public ResourceEntityConfigVo getConfig() {
        ResourceEntityConfigVo config = new ResourceEntityConfigVo();
        config.setMainCi("APPEnv");
        List<ResourceEntityFieldMappingVo> list = new ArrayList<>();
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("id");
            fieldMappingVo.setType("const");
            fieldMappingVo.setFromCi("APPEnv");
            fieldMappingVo.setFromAttr("_id");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("name");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("APPEnv");
            fieldMappingVo.setFromAttr("name");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("description");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("APPEnv");
            fieldMappingVo.setFromAttr("label");
            list.add(fieldMappingVo);
        }
        {
            ResourceEntityFieldMappingVo fieldMappingVo = new ResourceEntityFieldMappingVo();
            fieldMappingVo.setField("env_seq_no");
            fieldMappingVo.setType("attr");
            fieldMappingVo.setFromCi("APPEnv");
            fieldMappingVo.setFromAttr("seq_no");
            list.add(fieldMappingVo);
        }
        config.setFieldMappingList(list);
        return config;
    }

    public static void main(String[] args) {
        EnvVo envVo = new EnvVo();
        System.out.println(JSONObject.toJSONString(envVo.getConfig()));
    }
}
