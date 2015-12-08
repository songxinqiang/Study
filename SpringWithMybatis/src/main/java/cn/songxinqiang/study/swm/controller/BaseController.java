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
 * 创建时间：2015年12月8日--上午10:11:48
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import cn.songxinqiang.study.swm.conf.SupportLanguage;
import cn.songxinqiang.study.swm.model.User;
import cn.songxinqiang.study.swm.service.ProductService;
import cn.songxinqiang.study.swm.service.UserService;
import cn.songxinqiang.tool.SharePager;

/**
 * 控制器基类
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月8日
 *
 */
public abstract class BaseController implements Serializable {

    private static final long serialVersionUID = -1753199310966977546L;

    ProductService productService;
    UserService userService;

    int startRow;
    final int PAGE_SIZE = 15;
    final String TOTAL_ROW = "totalRow";
    final String TOTAL_PAGE = "totalPage";
    final String CURRENT_PAGE = "currentPage";

    /**
     * session中保存登录用户信息属性名称
     */
    public static final String SESSION_USER = "user";
    /**
     * session中保存用户选择的语言的属性名称
     */
    public static final String SESSION_LANGUAGE = "lan";

    /**
     * 已经用于界面显示的日志的ID记录编号，也就是下次界面获取的最小记录编号（不包含），记录在session中，每次获取日志记录都读取，
     * 获取到记录都更新记录值
     */
    public static final String SESSION_LOG_MIN_ID = "min_log";
    /**
     * 是否需要点击“应用”按钮
     */
    public static final String SESSION_SHOULD_APPLY = "apply";
    /**
     * 发送的cookie中关于用户选择语言的名称
     */
    public static final String COOKIE_LANGUAGE = "lan";

    /**
     * 以JSON格式返回“验证”、“检查”数据的时候“结果”的名称
     */
    public static final String JSON_NAME_RESULT = "result";
    /**
     * 以JSON格式返回“统计数目”的时候的数目的名称
     */
    public static final String JSON_NAME_COUNT = "count";
    /**
     * 控制器进行跳转的时候的控制语句，客户端跳转！
     */
    public static final String TARGET_REDIRECT = "redirect:";
    /**
     * 返回的无意义字符串，避免客户端等待无结果报错
     */
    public static final String RETURN_STR = "OK";

    /**
     * 分页，在调用本方法进行分页操作前应先得到总的记录条数和目前所处的页码，返回的信息使用{@code Map<String, Integer>}
     * 的形式返回
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param totalRow
     *            总的记录条数
     * @param currentPage
     *            当前页码
     * @return 分页的信息的键值对封装
     */
    public Map<String, Integer> _paging(int totalRow, int currentPage) {
        Map<String, Integer> map = new HashMap<>();
        map.put(TOTAL_ROW, totalRow);

        SharePager pager = new SharePager(totalRow, PAGE_SIZE);
        pager.jump(currentPage);

        startRow = pager.getStartRow();

        map.put(CURRENT_PAGE, pager.getCurrentPage());
        map.put(TOTAL_PAGE, pager.getTotalPage());

        return map;
    }

    /**
     * 跳转到最后一页，在调用前需要获取总的记录条数
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param totalRow
     *            总的记录条数
     * @return 最后一页的页码
     */
    public int _lastPageNumber(int totalRow) {
        SharePager pager = new SharePager(totalRow, PAGE_SIZE);
        pager.last();
        return pager.getCurrentPage();
    }

    /**
     * 获取指定行序号所在的页码号
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param rowIndex
     *            行序号
     * @return 所在页码
     */
    public int _rowPageNumber(int rowIndex) {
        int index = rowIndex / PAGE_SIZE;
        // 不是整除，需要在下一页
        if (rowIndex % PAGE_SIZE != 0) {
            index += 1;
        }
        return index;
    }

    /**
     * 在session中添加用户信息，统一进行这项操作是为了便于管理和修改，在用户访问某一些路径时会检查用户是否已经登录
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param session
     *            用户会话
     * @param user
     *            用户信息
     */
    public void _addUserToSession(HttpSession session, User user) {
        session.setAttribute(SESSION_USER, user);
    }

    /**
     * 从session之中获取用户信息
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param session
     *            用户会话
     * @return 得到的用户信息
     */
    public User _getUserFromSession(HttpSession session) {
        return (User) session.getAttribute(SESSION_USER);
    }

    /**
     * 从session中移除用户信息
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param session
     *            用户会话
     */
    public void _removeUserFromSession(HttpSession session) {
        session.removeAttribute(SESSION_USER);
    }

    /**
     * 设置用户选择的语言<br>
     * 同时设置到用户会话和用户浏览器的cookie中，cookie保存90天<br>
     * 用户会话中设置的语言信息，使用{@linkplain Locale}的形式保存
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param lan
     *            选择的语言
     * @param session
     *            用户会话
     * @param response
     *            对浏览器的响应
     * 
     * @see Cookie
     * @see HttpServletResponse#addCookie(Cookie)
     * @see HttpSession#setAttribute(String, Object)
     * @see SupportLanguage
     * @see SessionLocaleResolver
     */
    public void _setLan(String lan, HttpSession session, HttpServletResponse response) {
        SupportLanguage language = SupportLanguage.value(lan);
        session.setAttribute(SESSION_LANGUAGE, language.toString());
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
                language.getLocale());

        Cookie cookie = new Cookie(COOKIE_LANGUAGE, language.toString());
        cookie.setPath("/");
        // 设置最长保留时间，按秒计，保留90天，
        cookie.setMaxAge(3 * 30 * 24 * 60 * 60);
        response.addCookie(cookie);
    }

    /**
     * 在session中设置用户选择的语言
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param lan
     *            用户选择的语言
     * @param session
     *            用户会话
     */
    public void _setLan(SupportLanguage lan, HttpSession session) {
        session.setAttribute(SESSION_LANGUAGE, lan.toString());
    }

    /**
     * 获取{@code session}中保存的用户选择的语言的值，这个值获取的是枚举变量
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param session
     *            用户会话
     * @return 用于当前选择的语言的枚举值
     */
    public SupportLanguage _getLan(HttpSession session) {
        return SupportLanguage.value(session.getAttribute(SESSION_LANGUAGE).toString());
    }

    @Resource
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Resource
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
