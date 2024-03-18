/*Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU Affero General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU Affero General Public License for more details.

You should have received a copy of the GNU Affero General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package neatlogic.framework.cmdb.dao.ognl;

import java.text.SimpleDateFormat;

/**
 * 处理配置项查询属性between表达式，一定会返回一个长度为2的数组，代表前后两个值，如果处理不了则返回最小值和最大值，保证sql不出错
 */
public class Between {
    public static Object[] parse(String type, String str) {
        switch (type) {
            case "number": {
                Double[] s = new Double[]{null, null};
                if (str.contains("~")) {
                    String[] ss = str.split("~");
                    try {
                        s[0] = Double.parseDouble(ss[0]);
                    } catch (Exception ignored) {

                    }
                    if (ss.length > 1) {
                        try {
                            s[1] = Double.parseDouble(ss[1]);
                        } catch (Exception ignored) {

                        }
                    }
                }
                if (s[0] == null && s[1] == null) {
                    s[0] = -Double.MAX_VALUE;
                    s[1] = Double.MAX_VALUE;
                }
                return s;
            }
            case "date": {
                //MySQL 日期查询使用字符串即可，可以自动转换
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String[] s = new String[]{null, null};
                if (str.contains("~")) {
                    String[] ss = str.split("~");
                    try {
                        sdf.parse(ss[0]);
                        s[0] = "'" + ss[0] + "'";
                    } catch (Exception ignored) {

                    }
                    if (ss.length > 1) {
                        try {
                            sdf.parse(ss[1]);
                            s[1] = "'" + ss[1] + "'";
                        } catch (Exception ignored) {

                        }
                    }
                }
                return s;
            }
            case "time": {
                //MySQL 日期查询使用字符串即可，可以自动转换
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String[] s = new String[]{null, null};
                if (str.contains("~")) {
                    String[] ss = str.split("~");
                    try {
                        sdf.parse(ss[0]);
                        s[0] = "'" + ss[0] + "'";
                    } catch (Exception ignored) {

                    }
                    if (ss.length > 1) {
                        try {
                            sdf.parse(ss[1]);
                            s[1] = "'" + ss[1] + "'";
                        } catch (Exception ignored) {

                        }
                    }
                }
                return s;
            }
            case "datetime": {
                //MySQL 日期查询使用字符串即可，可以自动转换
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String[] s = new String[]{null, null};
                if (str.contains("~")) {
                    String[] ss = str.split("~");
                    try {
                        sdf.parse(ss[0]);
                        s[0] = "'" + ss[0] + "'";
                    } catch (Exception ignored) {

                    }
                    if (ss.length > 1) {
                        try {
                            sdf.parse(ss[1]);
                            s[1] = "'" + ss[1] + "'";
                        } catch (Exception ignored) {

                        }
                    }
                }
                return s;
            }
        }
        return new String[2];
    }
}
