/*
Copyright(c) $today.year NeatLogic Co., Ltd. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package neatlogic.framework.cmdb.dto.resourcecenter.entity;

import neatlogic.framework.cmdb.annotation.ResourceField;
import neatlogic.framework.cmdb.annotation.ResourceType;
import neatlogic.framework.common.constvalue.ApiParamType;
import neatlogic.framework.restful.annotation.EntityField;

/**
 * @author linbq
 * @since 2021/7/6 20:50
 **/
@ResourceType(name = "resource_appinstance_appinstancecluster", label = "应用实例与集群关系")
@ResourceType(name = "resource_dbinstance_dbcluster", label = "DB实例与集群关系")
@ResourceType(name = "resource_os_oscluster", label = "操作系统与集群关系")
public class ClusterVo {
    @EntityField(name = "资源id", type = ApiParamType.LONG)
    @ResourceField(name = "resource_id")
    private Long resourceId;
    @EntityField(name = "集群id", type = ApiParamType.LONG)
    @ResourceField(name = "cluster_id")
    private Long clusterId;
    @EntityField(name = "集群名", type = ApiParamType.STRING)
    @ResourceField(name = "cluster_name")
    private String clusterName;
    @EntityField(name = "集群类型id", type = ApiParamType.LONG)
    @ResourceField(name = "cluster_type_id")
    private Long clusterTypeId;

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public Long getClusterTypeId() {
        return clusterTypeId;
    }

    public void setClusterTypeId(Long clusterTypeId) {
        this.clusterTypeId = clusterTypeId;
    }
}
