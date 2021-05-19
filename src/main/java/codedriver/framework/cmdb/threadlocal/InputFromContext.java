/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.threadlocal;

import codedriver.framework.cmdb.enums.InputFrom;
import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class InputFromContext implements Serializable {
    private static final long serialVersionUID = -5732345436786224L;
    @JSONField(serialize = false)
    private final transient static ThreadLocal<InputFromContext> instance = new ThreadLocal<>();
    private InputFrom inputFrom;

    public static void init(InputFrom inputFrom) {
        InputFromContext context = new InputFromContext();
        context.setInputFrom(inputFrom);
        instance.set(context);
    }

    public static InputFromContext get() {
        return instance.get();
    }

    public String getInputFrom() {
        return inputFrom.getValue();
    }

    public void setInputFrom(InputFrom inputFrom) {
        this.inputFrom = inputFrom;
    }

    public void release() {
        instance.remove();
    }
}
