/*
 * Copyright(c) 2021 TechSureCo.,Ltd.AllRightsReserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.exception.resourcecenter;

import codedriver.framework.exception.core.ApiRuntimeException;

/**
 * @author linbq
 * @since 2021/6/22 18:11
 **/
public class ResourceNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8748508038438348100L;

    public ResourceNotFoundException(Long id){
        super("资源：'" + id+ "'不存在");
    }

    public ResourceNotFoundException(String name){
        super("资源：'" + name + "'不存在");
    }
}
