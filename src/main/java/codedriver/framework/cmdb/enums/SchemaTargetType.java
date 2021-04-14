/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.enums;

public enum SchemaTargetType {
    CI("ci"), CIENTITY("cientity"), ATTR("attr"), REL("rel");
    private final String type;

    private SchemaTargetType(String _type) {
        this.type = _type;
    }

    public String toString() {
        return type;
    }

}
