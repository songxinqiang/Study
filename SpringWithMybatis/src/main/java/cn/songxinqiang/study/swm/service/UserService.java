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
 * 创建时间：2015年12月8日--上午10:49:56
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.service;

import java.util.List;

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
public interface UserService {

    /**
     * 登陆成功返回用户信息描述对象，失败返回{@code null}
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param name
     *            用户名
     * @param password
     *            用户密码
     * @return 成功返回用户信息，失败返回{@code null}
     */
    public User login(String name, String password);

    /**
     * 根据用户的用户名获取用户信息描述对象
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param name
     *            用户名
     * @return 用户信息
     */
    public User find(String name);

    /**
     * 获取用户信息列表
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @return 用户信息列表
     */
    public List<User> list();

}
