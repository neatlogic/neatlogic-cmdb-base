package neatlogic.framework.cmdb.exception.cicatalog;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiCatalogNameRepeatException extends ApiRuntimeException {

    public CiCatalogNameRepeatException(String name) {
        super("nfcec.cicatalognamerepeatexception.cicatalognamerepeatexception", name);
    }
}
