package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class DownwardCiNotFoundException extends ApiRuntimeException {

    public DownwardCiNotFoundException(CiVo rootCi, String ciName) {
        super("nfcec.downwardcinotfoundexception.downwardcinotfoundexception", rootCi.getLabel(), rootCi.getName(), ciName);
    }

    public DownwardCiNotFoundException(CiVo rootCi, String ciName, String configurationPath, String actualPath) {
        super("nfcec.downwardcinotfoundexception.downwardcinotfoundexception_b", rootCi.getLabel(), rootCi.getName(), ciName, configurationPath, actualPath);
    }
}
