package neatlogic.framework.cmdb.exception.cicatalog;

import neatlogic.framework.exception.core.ApiRuntimeException;

public class CiCatalogNotFoundException extends ApiRuntimeException {

    public CiCatalogNotFoundException(Long id) {
        super("nfcec.cicatalognotfoundexception.cicatalognotfoundexception", id);
    }

    public CiCatalogNotFoundException(String name) {
        super("nfcec.cicatalognotfoundexception.cicatalognotfoundexception", name);
    }
}
