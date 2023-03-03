/*
 * Copyright(c) 2023 NeatLogic Co., Ltd. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
