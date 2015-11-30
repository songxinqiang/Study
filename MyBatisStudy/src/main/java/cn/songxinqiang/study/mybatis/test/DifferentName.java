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
 * 创建时间：2015年11月30日--下午2:06:30
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.songxinqiang.study.mybatis.mapper.OrderMapper;
import cn.songxinqiang.study.mybatis.model.Order;
import cn.songxinqiang.study.mybatis.util.MyBatisUtil;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年11月30日
 *
 */
public class DifferentName {

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
    public void testGetOrderById() {
        /**
         * 映射sql的标识字符串，mapper.orderMapper是orderMapper.
         * xml文件中mapper标签的namespace属性的值，
         * getOrderById是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.orderMapper.getOrderById";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
        System.out.println(order);// 打印结果：null，也就是没有查询出相应的记录
    }

    @Test
    public void testGetOrderById2() {
        /**
         * 映射sql的标识字符串，mapper.orderMapper是orderMapper.
         * xml文件中mapper标签的namespace属性的值，
         * selectOrder是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.orderMapper.selectOrder";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
        System.out.println(order);// 打印结果：Order [id=1, orderNo=aaaa, price=23.0]
    }

    @Test
    public void testGetOrderById3() {
        /**
         * 映射sql的标识字符串，mapper.orderMapper是orderMapper.
         * xml文件中mapper标签的namespace属性的值，
         * selectOrderResultMap是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.orderMapper.selectOrderResultMap";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成Order对象返回
        Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
        System.out.println(order);// 打印结果：Order [id=1, orderNo=aaaa, price=23.0]
    }

    @Test
    public void testAnnoSelect() {
        Order o = sqlSession.getMapper(OrderMapper.class).getById(2);
        System.out.println(o);
    }
}
