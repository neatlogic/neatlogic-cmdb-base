/*
 * Copyright(c) 2021 TechSure Co., Ltd. All Rights Reserved.
 * 本内容仅限于深圳市赞悦科技有限公司内部传阅，禁止外泄以及用于其他的商业项目。
 */

package codedriver.framework.cmdb.annotation;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ResourceField {

    String name() default "";

    String targetView() default "";

    /**
     * 关系中源视图的字段名
     */
    String fromColumnName() default "";

    /**
     * 关系中目标视图的字段名
     */
    String targetColumnName() default "";

}
