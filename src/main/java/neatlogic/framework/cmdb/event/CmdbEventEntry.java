package neatlogic.framework.cmdb.event;

import neatlogic.framework.cmdb.dto.transaction.CiEntityTransactionVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.function.BiConsumer;

/** 配置项商业事件的可选入口，无商业处理器时不执行任何操作。 */
public final class CmdbEventEntry {
    private static final Logger logger = LoggerFactory.getLogger(CmdbEventEntry.class);
    private static volatile BiConsumer<CiEntityTransactionVo, CmdbEventType> handler;

    private CmdbEventEntry() {
    }

    /** 商业模块初始化时注册处理器。 */
    public static synchronized void register(BiConsumer<CiEntityTransactionVo, CmdbEventType> consumer) {
        handler = consumer;
    }

    /** 仅注销对应实例，避免旧上下文销毁时清除新处理器。 */
    public static synchronized void unregister(BiConsumer<CiEntityTransactionVo, CmdbEventType> consumer) {
        if (handler == consumer) {
            handler = null;
        }
    }

    /** 委托商业核心登记事件，处理失败不影响配置项业务事务。 */
    public static void doEvent(CiEntityTransactionVo ciEntityTransactionVo, CmdbEventType eventType) {
        BiConsumer<CiEntityTransactionVo, CmdbEventType> consumer = handler;
        if (consumer == null) {
            return;
        }
        try {
            consumer.accept(ciEntityTransactionVo, eventType);
        } catch (Exception ex) {
            logger.error("配置项商业事件登记失败，事件类型：{}", eventType, ex);
        }
    }
}
