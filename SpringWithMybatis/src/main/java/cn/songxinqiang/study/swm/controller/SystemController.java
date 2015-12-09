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
 * 创建时间：2015年12月8日--上午10:41:13
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import cn.songxinqiang.study.swm.model.User;

/**
 * 系统控制器
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月8日
 *
 */
@Controller
@RequestMapping(value = { "/system", "/**" })
public class SystemController extends BaseController {

    private static final long serialVersionUID = 3975329422726290208L;

    /**
     *
     * @author 阿信sxq-2015年12月9日
     *
     * @return
     */
    @RequestMapping(value = { "/login", "/**" }, method = RequestMethod.GET)
    public String toLogin() {
        return "index/login";
    }

    /**
     *
     * @author 阿信sxq-2015年12月9日
     *
     * @param uname
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("uname") String uname,
            @RequestParam("password") String password, HttpSession session) {
        User user = userService.login(uname, password);
        Map<String, Object> map = new HashMap<>();
        if (user != null) {
            map.put(JSON_NAME_RESULT, true);
            _addUserToSession(session, user);
        } else {
            map.put(JSON_NAME_RESULT, false);
        }
        return JSON.toJSONString(map);
    }

    /**
     *
     * @author 阿信sxq-2015年12月9日
     *
     * @return
     */
    @RequestMapping(value = "/index")
    public String toIndex() {
        return "index/admin";
    }
    
    /**
     *
     * @author 阿信sxq-2015年12月9日
     *
     * @param lan
     * @param session
     * @param response
     * @return
     */
    @RequestMapping(value = "/lan/{lan:\\w+}")
    public String setLan(@PathVariable("lan") String lan, HttpSession session,
            HttpServletResponse response) {
        _setLan(lan, session, response);
        return "index/login";
    }

}
