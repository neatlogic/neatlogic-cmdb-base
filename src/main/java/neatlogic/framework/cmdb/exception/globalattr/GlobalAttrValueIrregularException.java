package neatlogic.framework.cmdb.exception.globalattr;

import neatlogic.framework.cmdb.dto.globalattr.GlobalAttrVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class GlobalAttrValueIrregularException extends ApiRuntimeException {

    public GlobalAttrValueIrregularException(GlobalAttrVo globalAttrVo, String value) {
        super("nfceg.globalattrvalueirregularexception.globalattrvalueirregularexception", globalAttrVo.getLabel(), globalAttrVo.getName(), value);
    }

    public GlobalAttrValueIrregularException(String ciLabel, String ciName, GlobalAttrVo globalAttrVo, String value, String configurationPath, String actualPath) {
        super("nfceg.globalattrvalueirregularexception.globalattrvalueirregularexception_b", ciLabel, ciName, globalAttrVo.getLabel(), globalAttrVo.getName(), value, configurationPath, actualPath);
    }
}
