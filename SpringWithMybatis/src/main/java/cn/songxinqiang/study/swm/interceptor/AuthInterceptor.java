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
 * 创建时间：2015年12月10日--下午3:53:02
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.interceptor;

import java.util.Base64;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 401基本认证拦截器示例，会获取请求头的{@code Authorization}信息，获取到的信息形式如
 * {@code Basic YWRtaW46YWRtaW4=},需要将后面的有效部分({@code YWRtaW46YWRtaW4=}
 * )进行Base64的解码,得到{@code admin:admin}
 * ,其中前面是用户名后面是密码，可以进行相关的权限验证.要注意的是，设置头的“WWW-authenticate”的时候必须给出“Basic
 * Realm”，即使是空字符串，但是要小心这里的乱码问题
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月10日
 * 
 * @see Base64#getDecoder()
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2)
            throws Exception {
        String auth = request.getHeader("Authorization");
        System.out.println("-------------" + auth + "--------------------");
        if (checkHeaderAuth(auth)) {
            return true;
        } else {
            response.setStatus(401);
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", 0);
            response.setHeader("WWW-authenticate", "Basic Realm=" + "456123中文");
            return false;
        }
    }

    private boolean checkHeaderAuth(String auth) {
        if (auth == null || auth.length() < 6) {
            return false;
        }

        auth = auth.substring(6);

        String decodedAuth = getFromBASE64(auth);
        System.out.println("auth decoded from base64 is " + decodedAuth);

        return true;
    }

    private String getFromBASE64(String s) {
        byte[] encodeBase64 = Base64.getDecoder().decode(s);
        return new String(encodeBase64);

    }
}
