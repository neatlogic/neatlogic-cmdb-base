package neatlogic.framework.cmdb.exception.globalattr;

import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class GlobalAttrValueIrregularException extends ApiRuntimeException {

    public GlobalAttrValueIrregularException(GlobalAttrVo globalAttrVo, String value) {
        super("nfceg.globalattrvalueirregularexception.globalattrvalueirregularexception", globalAttrVo.getLabel(), globalAttrVo.getName(), value);
    }

    static public class MultipleException extends ApiRuntimeException {
        public MultipleException(GlobalAttrVo globalAttrVo) {
            super("全局属性“" + globalAttrVo.getLabel() + "”不支持多选");
        }
    }
}
