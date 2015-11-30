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
 * 创建时间：2015年11月26日--下午5:45:06
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.songxinqiang.study.mybatis.mapper.UserMapper;
import cn.songxinqiang.study.mybatis.model.User;
import cn.songxinqiang.study.mybatis.util.MyBatisUtil;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年11月26日
 *
 */
public class AnnoCrudTest {

    SqlSession sqlSession;
    UserMapper mapper;

    @Before
    public void before() {
        sqlSession = MyBatisUtil.getSqlSession(true);
        // 得到UserMapper接口的实现类对象，UserMapper接口的实现类对象由sqlSession.getMapper(UserMapper.class)动态构建出来
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void after() {
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testAdd() {
        User user = new User();
        user.setName("用户xdp");
        user.setAge(20);
        int add = mapper.add(user);
        System.out.println(add);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(3);
        user.setName("孤傲苍狼_xdp");
        user.setAge(26);
        // 执行修改操作
        int retResult = mapper.update(user);
        System.out.println(retResult);
    }

    @Test
    public void testDelete() {
        // 执行删除操作
        int retResult = mapper.deleteById(7);
        System.out.println(retResult);
    }

    @Test
    public void testGetUser() {
        // 执行查询操作，将查询结果自动封装成User返回
        User user = mapper.getById(8);
        System.out.println(user);
    }

    @Test
    public void testGetAll() {
        // 执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = mapper.getAll();
        System.out.println(lstUsers);
    }
}
