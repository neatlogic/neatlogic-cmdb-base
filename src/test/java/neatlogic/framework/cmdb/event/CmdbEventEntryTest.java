package neatlogic.framework.cmdb.event;

import com.alibaba.fastjson.JSON;
import neatlogic.framework.cmdb.dto.transaction.CiEntityTransactionVo;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

/** 验证商业处理器可选且不会阻断配置项操作。 */
public class CmdbEventEntryTest {
    /** 无商业模块时不访问输入，包含空参数也直接返回。 */
    @Test public void absentCommercialIsNoOp() {
        CmdbEventEntry.register(null);
        CmdbEventEntry.doEvent(new CiEntityTransactionVo() {
            @Override public Long getCiEntityId() { throw new AssertionError("无商业模块不能读取配置项标识"); }
            @Override public Long getTransactionId() { throw new AssertionError("无商业模块不能读取事务标识"); }
        }, CmdbEventType.CIENTITY_UPDATE_COMMITTED);
        CmdbEventEntry.doEvent(null, null);
        Assert.assertEquals(12, CmdbEventType.values().length);
    }

    /** 统一入口原样传递事务对象，保留操作及属性、关系数据。 */
    @Test public void transactionInputIsPassedWithoutConversion() {
        CiEntityTransactionVo input = new CiEntityTransactionVo();
        input.setCiEntityId(20L);
        input.setCiId(10L);
        input.setTransactionId(30L);
        input.setAction("update");
        input.setAttrEntityData(JSON.parseObject("{attr_1:{valueList:['value'],saveMode:'merge'}}"));
        input.setRelEntityData(JSON.parseObject("{relfrom_2:{valueList:[{ciEntityId:99,action:'delete'}]}}"));
        AtomicInteger called = new AtomicInteger();
        BiConsumer<CiEntityTransactionVo, CmdbEventType> callback = (vo, type) -> {
            called.incrementAndGet();
            Assert.assertSame(input, vo);
            Assert.assertEquals(CmdbEventType.CIENTITY_UPDATE_COMMITTED, type);
            Assert.assertEquals(Long.valueOf(20L), vo.getCiEntityId());
            Assert.assertEquals(Long.valueOf(30L), vo.getTransactionId());
            Assert.assertEquals("update", vo.getAction());
            Assert.assertEquals("merge", vo.getAttrEntityData().getJSONObject("attr_1").getString("saveMode"));
            Assert.assertEquals("delete", vo.getRelEntityData().getJSONObject("relfrom_2").getJSONArray("valueList").getJSONObject(0).getString("action"));
        };
        try {
            CmdbEventEntry.register(callback);
            CmdbEventEntry.doEvent(input, CmdbEventType.CIENTITY_UPDATE_COMMITTED);
            Assert.assertEquals(1, called.get());
        } finally {
            CmdbEventEntry.unregister(callback);
        }
    }

    /** 上下文销毁仅移除自己的回调，异常被入口隔离。 */
    @Test public void registrationIsOwnedAndExceptionsAreIsolated() {
        AtomicInteger called = new AtomicInteger();
        BiConsumer<CiEntityTransactionVo, CmdbEventType> old = (vo, type) -> Assert.fail("旧回调不应调用");
        BiConsumer<CiEntityTransactionVo, CmdbEventType> current = (vo, type) -> {
            called.incrementAndGet();
            throw new IllegalStateException("模拟商业采集失败");
        };
        try {
            CmdbEventEntry.register(old);
            CmdbEventEntry.register(current);
            CmdbEventEntry.unregister(old);
            CmdbEventEntry.doEvent(new CiEntityTransactionVo(), CmdbEventType.CIENTITY_UPDATE_COMMITTED);
            Assert.assertEquals(1, called.get());
            CmdbEventEntry.unregister(current);
            CmdbEventEntry.doEvent(null, null);
            Assert.assertEquals(1, called.get());
        } finally {
            CmdbEventEntry.unregister(current);
        }
    }
}
