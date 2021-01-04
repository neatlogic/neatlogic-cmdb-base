package codedriver.framework.cmdb.attrvaluehandler.core;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author:chenqiwei
 * @Time:Sep 1, 2020
 * @ClassName: AttrValueUtil
 * @Description: 处理真实属性值工具类
 */
public class AttrValueUtil {

    public static List<String> getValueList(List<String> hashList) {
        if (CollectionUtils.isNotEmpty(hashList)) {
            return hashList.stream().map(AttrValueUtil::getValue).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    public static List<String> getHashList(String propHandler, List<String> valueList) {
        if (CollectionUtils.isNotEmpty(valueList)) {
            return valueList.stream().map(new Function<String, String>() {
                @Override
                public String apply(String s) {
                    if (StringUtils.isNotBlank(s)) {
                        IAttrValueHandler handler = AttrValueHandlerFactory.getHandler("hash");
                        if (handler != null) {
                            return handler.getTransferedValue(propHandler, s);
                        }
                    }
                    return s;
                }
            }).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    private static String getValue(String hash) {
        IAttrValueHandler handler = AttrValueHandlerFactory.getHandler("hash");
        if (handler != null) {
            return handler.getActualValue(hash);
        }
        return hash;
    }

}
