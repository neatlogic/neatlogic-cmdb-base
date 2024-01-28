package neatlogic.framework.cmdb.exception.ci;

import neatlogic.framework.cmdb.dto.ci.CiVo;
import neatlogic.framework.exception.core.ApiRuntimeException;

public class DownwardCiNotFoundException extends ApiRuntimeException {

    public DownwardCiNotFoundException(CiVo rootCi, String ciName) {
        super("nfcec.downwardcinotfoundexception.downwardcinotfoundexception", rootCi.getLabel(), rootCi.getName(), ciName);
    }

    public DownwardCiNotFoundException(CiVo rootCi, String ciName, String configurationPath, String actualPath) {
        super("在配置项模型“{0}({1})”的下游模型中找不到配置项模型“{2}”，配置路径：{3}，实际路径：{4}", rootCi.getLabel(), rootCi.getName(), ciName, configurationPath, actualPath);
    }
}
