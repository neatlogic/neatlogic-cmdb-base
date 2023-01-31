/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
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
