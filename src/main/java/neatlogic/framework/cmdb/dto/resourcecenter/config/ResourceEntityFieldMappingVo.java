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

package neatlogic.framework.cmdb.dto.resourcecenter.config;

public class ResourceEntityFieldMappingVo {

    private String field;
    private String type;
    private String fromCi;
    private String fromAttr;
    private String toCi;
    private String toAttr;
    private String direction;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFromCi() {
        return fromCi;
    }

    public void setFromCi(String fromCi) {
        this.fromCi = fromCi;
    }

    public String getFromAttr() {
        return fromAttr;
    }

    public void setFromAttr(String fromAttr) {
        this.fromAttr = fromAttr;
    }

    public String getToCi() {
        return toCi;
    }

    public void setToCi(String toCi) {
        this.toCi = toCi;
    }

    public String getToAttr() {
        return toAttr;
    }

    public void setToAttr(String toAttr) {
        this.toAttr = toAttr;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
