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
 * 创建时间：2015年12月7日--下午5:01:10
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.swm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.songxinqiang.study.swm.model.User;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月7日
 *
 */
@Repository
public interface UserMapper {

    /**
     * 全部用户
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @return 全部用户的列表
     */
    List<User> listAll();

    /**
     * 通过用户记录编号获取用户信息
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param id
     *            记录编号
     * @return 用户信息
     */
    User find(@Param("id")int id);

    /**
     * 通过用户名获取用户信息
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param userName
     *            用户名
     * @return 用户信息
     */
    User getUser(@Param("uname")String userName);

    /**
     * 统计指定用户名和密码的用户记录数，其中密码是已经经过了MD5处理的
     *
     * @author 阿信sxq-2015年12月8日
     *
     * @param uname
     *            用户名
     * @param password
     *            密码，已采用MD5进行处理
     * @return 记录的数目
     */
    int login(@Param("uname") String uname, @Param("password") String password);

}
