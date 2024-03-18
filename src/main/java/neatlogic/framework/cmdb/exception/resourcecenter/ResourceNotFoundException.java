/*Copyright (C) $today.year  深圳极向量科技有限公司 All Rights Reserved.

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
