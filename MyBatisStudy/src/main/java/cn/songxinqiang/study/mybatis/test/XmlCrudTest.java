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
 * 创建时间：2015年11月26日--下午2:04:13
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
public class XmlCrudTest {

    SqlSession sqlSession;

    @Before
    public void before() {
        sqlSession = MyBatisUtil.getSqlSession(true);
    }

    @After
    public void after() {
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        sqlSession.close();
    }

    @Test
    public void testAdd() {
        /**
         * 映射sql的标识字符串，mapper.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.userMapper.addUser";// 映射sql的标识字符串
        User user = new User();
        user.setName("用户孤傲苍狼");
        user.setAge(20);
        // 执行插入操作
        int retResult = sqlSession.insert(statement, user);
        System.out.println(retResult);
    }

    @Test
    public void testUpdate() {
        /**
         * 映射sql的标识字符串，mapper.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * updateUser是update标签的id属性值，通过update标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.userMapper.updateUser";// 映射sql的标识字符串
        User user = new User();
        user.setId(3);
        user.setName("孤傲苍狼");
        user.setAge(25);
        // 执行修改操作
        int retResult = sqlSession.update(statement, user);
        System.out.println(retResult);
    }

    @Test
    public void testDelete() {
        /**
         * 映射sql的标识字符串，mapper.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * deleteUser是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.userMapper.deleteUser";// 映射sql的标识字符串
        // 执行删除操作
        int retResult = sqlSession.delete(statement, 5);
        System.out.println(retResult);
    }

    @Test
    public void testGetAll() {
        /**
         * 映射sql的标识字符串，mapper.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getAllUsers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.userMapper.getAllUsers";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成List<User>返回
        List<User> lstUsers = sqlSession.selectList(statement);
        System.out.println(lstUsers);
    }

}
