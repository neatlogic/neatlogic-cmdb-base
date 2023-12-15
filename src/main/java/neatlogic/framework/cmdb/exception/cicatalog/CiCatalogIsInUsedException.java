package neatlogic.framework.cmdb.exception.cicatalog;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiCatalogIsInUsedException extends ApiRuntimeException {

    public CiCatalogIsInUsedException(String name) {
        super("nfcec.cicatalogisinusedexception.cicatalogisinusedexception", name);
    }
}
