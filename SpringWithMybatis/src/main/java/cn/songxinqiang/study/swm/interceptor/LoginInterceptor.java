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
 * 创建时间：2015年12月8日--上午9:39:34
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.songxinqiang.study.swm.controller.BaseController;
import cn.songxinqiang.study.swm.model.User;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月8日
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 用户未登录时的登陆界面地址
     */
    private String loginPath;

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        Object o = request.getSession().getAttribute(BaseController.SESSION_USER);

        if (o instanceof User) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + loginPath);
            return false;
        }
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }

}
