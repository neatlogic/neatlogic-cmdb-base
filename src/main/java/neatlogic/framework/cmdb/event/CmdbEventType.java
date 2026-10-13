package neatlogic.framework.cmdb.event;

import neatlogic.framework.util.$;

/** 配置项事件点，与旧生命周期事件独立。 */
public enum CmdbEventType {
    CIENTITY_CREATE_PENDING("CIENTITY_CREATE_PENDING", "term.cmdb.event.cientity_create_pending.name", "term.cmdb.event.cientity_create_pending.desc"),
    CIENTITY_CREATE_COMMITTED("CIENTITY_CREATE_COMMITTED", "term.cmdb.event.cientity_create_committed.name", "term.cmdb.event.cientity_create_committed.desc"),
    CIENTITY_UPDATE_PENDING("CIENTITY_UPDATE_PENDING", "term.cmdb.event.cientity_update_pending.name", "term.cmdb.event.cientity_update_pending.desc"),
    CIENTITY_UPDATE_COMMITTED("CIENTITY_UPDATE_COMMITTED", "term.cmdb.event.cientity_update_committed.name", "term.cmdb.event.cientity_update_committed.desc"),
    CIENTITY_DELETE_PENDING("CIENTITY_DELETE_PENDING", "term.cmdb.event.cientity_delete_pending.name", "term.cmdb.event.cientity_delete_pending.desc"),
    CIENTITY_DELETE_COMMITTED("CIENTITY_DELETE_COMMITTED", "term.cmdb.event.cientity_delete_committed.name", "term.cmdb.event.cientity_delete_committed.desc"),
    CIENTITY_RECOVER("CIENTITY_RECOVER", "term.cmdb.event.cientity_recover.name", "term.cmdb.event.cientity_recover.desc"),
    TRANSACTION_ROLLBACK("TRANSACTION_ROLLBACK", "term.cmdb.event.transaction_rollback.name", "term.cmdb.event.transaction_rollback.desc"),
    TRANSACTION_CREATE_COMMIT("TRANSACTION_CREATE_COMMIT", "term.cmdb.event.transaction_create_commit.name", "term.cmdb.event.transaction_create_commit.desc"),
    TRANSACTION_UPDATE_COMMIT("TRANSACTION_UPDATE_COMMIT", "term.cmdb.event.transaction_update_commit.name", "term.cmdb.event.transaction_update_commit.desc"),
    TRANSACTION_DELETE_COMMIT("TRANSACTION_DELETE_COMMIT", "term.cmdb.event.transaction_delete_commit.name", "term.cmdb.event.transaction_delete_commit.desc"),
    CIENTITY_PASSIVE_UPDATE("CIENTITY_PASSIVE_UPDATE", "term.cmdb.event.cientity_passive_update.name", "term.cmdb.event.cientity_passive_update.desc");

    private final String name;
    private final String label;
    private final String description;

    CmdbEventType(String name, String label, String description) {
        this.name = name;
        this.label = label;
        this.description = description;
    }

    /** 返回稳定事件标识。 */
    public String getName() { return name; }
    /** 返回国际化事件名称。 */
    public String getLabel() { return $.t(label); }
    /** 返回国际化事件说明。 */
    public String getDescription() { return $.t(description); }
    /** 按标识定位事件点。 */
    public static CmdbEventType get(String name) {
        for (CmdbEventType type : values()) {
            if (type.name.equals(name)) { return type; }
        }
        return null;
    }
    /** 按标识返回事件名称。 */
    public static String getLabel(String name) {
        CmdbEventType type = get(name);
        if (type != null) { return type.getLabel(); }
        return "";
    }
}
