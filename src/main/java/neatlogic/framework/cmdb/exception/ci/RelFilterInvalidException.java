package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.exception.core.ApiRuntimeException;

/** 关系过滤条件校验异常，错误原因及参数上下文统一走国际化。 */
public class RelFilterInvalidException extends ApiRuntimeException {
    private static final long serialVersionUID = 1L;

    /** 使用明确的错误原因和动态参数生成提示。 */
    public RelFilterInvalidException(Reason reason, Object... arguments) {
        super(reason.getKey(), arguments);
    }

    /** 在保存入口补充两端字段上下文，保留已翻译的具体原因和异常链。 */
    public RelFilterInvalidException(String parameter, RelFilterInvalidException cause) {
        super("exception.cmdb.relfilterinvalidexception.parameter", cause, parameter, cause.getMessage());
    }

    /** 枚举约束错误键，避免校验调用方拼接或硬编码用户提示。 */
    public enum Reason {
        MODEL_MISSING("exception.cmdb.relfilterinvalidexception.model_missing"),
        CHILD_MODEL_INVALID("exception.cmdb.relfilterinvalidexception.child_model_invalid"),
        GROUP_INVALID("exception.cmdb.relfilterinvalidexception.group_invalid"),
        ATTRIBUTE_INVALID("exception.cmdb.relfilterinvalidexception.attribute_invalid"),
        ATTRIBUTE_OPERATOR_INVALID("exception.cmdb.relfilterinvalidexception.attribute_operator_invalid"),
        GLOBAL_ATTRIBUTE_INVALID("exception.cmdb.relfilterinvalidexception.global_attribute_invalid"),
        RELATION_INVALID("exception.cmdb.relfilterinvalidexception.relation_invalid"),
        COLLECTION_OPERATOR_INVALID("exception.cmdb.relfilterinvalidexception.collection_operator_invalid"),
        UNSUPPORTED_FIELD("exception.cmdb.relfilterinvalidexception.unsupported_field"),
        ARRAY_REQUIRED("exception.cmdb.relfilterinvalidexception.array_required"),
        INVALID_CONDITION("exception.cmdb.relfilterinvalidexception.invalid_condition"),
        UNSUPPORTED_CONDITION_FIELD("exception.cmdb.relfilterinvalidexception.unsupported_condition_field"),
        OPERATOR_INVALID("exception.cmdb.relfilterinvalidexception.operator_invalid"),
        DIRECTION_INVALID("exception.cmdb.relfilterinvalidexception.direction_invalid"),
        VALUE_REQUIRED("exception.cmdb.relfilterinvalidexception.value_required"),
        RANGE_BOUNDS_REQUIRED("exception.cmdb.relfilterinvalidexception.range_bounds_required"),
        VALUE_INVALID("exception.cmdb.relfilterinvalidexception.value_invalid"),
        VALUE_EMPTY("exception.cmdb.relfilterinvalidexception.value_empty"),
        RANGE_ARRAY_UNSUPPORTED("exception.cmdb.relfilterinvalidexception.range_array_unsupported"),
        RANGE_BOUND_REQUIRED("exception.cmdb.relfilterinvalidexception.range_bound_required"),
        ID_INVALID("exception.cmdb.relfilterinvalidexception.id_invalid");

        private final String key;

        Reason(String key) {
            this.key = key;
        }

        /** 返回该原因对应的翻译键。 */
        public String getKey() {
            return key;
        }
    }
}
