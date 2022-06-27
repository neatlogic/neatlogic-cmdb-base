package codedriver.framework.cmdb.enums;

import codedriver.framework.dependency.core.IFromType;

/**
 * @author longrf
 * @date 2022/3/10 5:14 下午
 */
public enum CmdbFromType implements IFromType {
    RESOURCE_ACCOUNT("resourceaccount", "资产账号");

    private String value;
    private String text;

    private CmdbFromType(String value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 被调用者类型值
     *
     * @return
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * 被调用者类型名
     *
     * @return
     */
    @Override
    public String getText() {
        return text;
    }
}