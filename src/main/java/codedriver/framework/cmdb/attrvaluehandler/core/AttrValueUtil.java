package codedriver.framework.cmdb.attrvaluehandler.core;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author:chenqiwei
 * @Time:Sep 1, 2020
 * @ClassName: AttrValueUtil
 * @Description: 处理真实属性值工具类
 */
public class AttrValueUtil {

    public static List<String> getActualValueList(List<String> valueList) {
        if (CollectionUtils.isNotEmpty(valueList)) {
            return valueList.stream().map(v -> getActualValue(v)).collect(Collectors.toList());
        } else {
            return valueList;
        }
    }

    public static List<String> getTransferValueList(List<String> valueList) {
        if (CollectionUtils.isNotEmpty(valueList)) {
            return valueList.stream().map(new Function<String, String>() {
                @Override
                public String apply(String s) {
                    if (StringUtils.isNotBlank(s)) {
                        if (s.length() > 1000) {
                            IAttrValueHandler handler = AttrValueHandlerFactory.getHandler("hash");
                            if (handler != null) {
                                return handler.getTransferedValue(s);
                            }
                        }
                    }
                    return s;
                }
            }).collect(Collectors.toList());
        } else {
            return valueList;
        }
    }

    private static String getActualValue(String value) {
        int endindex = value.indexOf("}");
        if (value.startsWith("{") && endindex > -1) {
            String protocol = value.substring(1, endindex);
            IAttrValueHandler handler = AttrValueHandlerFactory.getHandler(protocol);
            if (handler != null) {
                return handler.getActualValue(value.substring(endindex + 1));
            }
        }
        return value;
    }

}
