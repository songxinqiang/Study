/**
 * <pre>
 * Copyright 2014,2015 阿信sxq(songxinqiang@vip.qq.com).
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </pre>
 */
/*
 * 创建时间：2015年12月8日--上午10:25:32
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.conf;

import java.util.Locale;

/**
 * 手支持语言
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月8日
 *
 */
public enum SupportLanguage {

    english(1, "英语", "lan_en_US", Locale.US),
    chinese(2, "中文", "lan_zh_CN", Locale.CHINA);

    int index;
    String name;
    String resFile;
    Locale locale;

    /**
     * 支持语言的构造方法，设置必要的属性
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param index
     *            序号
     * @param name
     *            语言名称，用于对语言的选择的判断处理
     * @param resFileName
     *            语言的资源文件名
     * @param locale
     *            语言对应的本地化描述对象
     */
    SupportLanguage(int index, String name, String resFileName, Locale locale) {
        this.index = index;
        this.name = name;
        this.resFile = resFileName;
        this.locale = locale;
    }

    /**
     * {@inheritDoc}<br>
     * 在这里返回语言的语言文件的文件名
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public String toString() {
        return resFile;
    }

    /**
     * 判断语言是否是界面支持的语言<br>
     * 界面进行多语言显示，需要准备好多语言文件之后才处于“受支持”状态，在准备好语言文件之后要在这里添加对应的枚举
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param str
     *            待检测的语言描述字符串，需要和枚举中的属性对应
     * @return 若有匹配的语言返回true，否则返回false
     */
    public static boolean isSupportedLanguage(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }
        SupportLanguage[] lans = SupportLanguage.values();
        for (SupportLanguage lan : lans) {
            if (lan.resFile.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据对语言的字符串描述，获取语言的枚举
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param str
     *            对语言的字符串描述
     * @return 受支持语言的枚举，若没有找到对应的语言，则返回英语
     */
    public static SupportLanguage value(String str) {
        SupportLanguage[] lans = SupportLanguage.values();
        for (SupportLanguage lan : lans) {
            if (lan.resFile.equals(str)) {
                return lan;
            }
        }
        return english;
    }

    /**
     * 获取本地化描述对象
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @return 语言对应的本地化描述对象
     */
    public Locale getLocale() {
        return locale;
    }

}
