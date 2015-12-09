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
 * 创建时间：2015年12月8日--上午11:53:35
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.songxinqiang.study.swm.mapper.UserMapper;
import cn.songxinqiang.study.swm.model.User;
import cn.songxinqiang.study.swm.service.UserService;
import cn.songxinqiang.tool.MD5Code;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月8日
 *
 */
@Service
public class UserServiceImpl implements UserService {

    private MD5Code md5Code;
    private UserMapper userDao;

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月9日
     *
     */
    @Override
    public User login(String name, String password) {
        return userDao.login(name, md5Code.getCode(password));
    }

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public User find(String name) {
        if (name != null && name.length() > 0) {
            return userDao.getUser(name);
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}<br>
     *
     * @author 阿信sxq-2015年12月8日
     *
     */
    @Override
    public List<User> list() {
        return userDao.listAll();
    }

    @Resource
    public void setMd5Code(MD5Code md5Code) {
        this.md5Code = md5Code;
    }

    @Resource
    public void setUserDao(UserMapper userDao) {
        this.userDao = userDao;
    }

}
