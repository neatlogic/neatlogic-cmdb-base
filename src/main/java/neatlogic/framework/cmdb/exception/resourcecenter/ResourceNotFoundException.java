/*
Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.

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

package neatlogic.framework.cmdb.exception.resourcecenter;

import neatlogic.framework.exception.core.ApiRuntimeException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @author linbq
 * @since 2021/6/22 18:11
 **/
public class ResourceNotFoundException extends ApiRuntimeException {

    private static final long serialVersionUID = 8748508038438348100L;

    public ResourceNotFoundException(Long id) {
        super("nfcer.resourcenotfoundexception.resourcenotfoundexception.id", id);
    }

    public ResourceNotFoundException(String name) {
        super("nfcer.resourcenotfoundexception.resourcenotfoundexception.id", name);
    }

    public ResourceNotFoundException(List<String> nameList) {
        super("common.errorMessage.empty.resource", String.join(",", nameList));

    }

    public ResourceNotFoundException() {
        super("nfcer.resourcenotfoundexception.resourcenotfoundexception.id", StringUtils.EMPTY);

    }

    public ResourceNotFoundException(String ip, Integer port, String nodeName, String nodeType) {
        super("nfcer.resourcenotfoundexception.resourcenotfoundexception.ip", ip, port, nodeName, nodeType);
    }

    public ResourceNotFoundException(String ip, Integer port, String nodeName) {
        super("nfcer.resourcenotfoundexception.resourcenotfoundexception.ipname", ip, port, nodeName);
    }
}
