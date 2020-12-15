package codedriver.framework.cmdb.attrvaluehandler.core;

/**
 * @Author:chenqiwei
 * @Time:Sep 1, 2020
 * @ClassName: IAttrValueHandler
 * @Description: 获取属性真实值
 */
public interface IAttrValueHandler {
    public String getProtocol();

    public String getTransferedValue(String propHandler, String value);

    public String getActualValue(String value);
}
