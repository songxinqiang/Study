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
 * 创建时间：2015年12月1日--下午5:06:09
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.songxinqiang.study.mybatis.model.Classes;
import cn.songxinqiang.study.mybatis.util.MyBatisUtil;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月1日
 *
 */
public class OneToOneRelation {

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
    public void testGetClass() {
        /**
         * 映射sql的标识字符串，
         * mapper.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
         * getClass是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.classMapper.getClass";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成Classes对象返回
        Classes clazz = sqlSession.selectOne(statement, 1);// 查询class表中id为1的记录
        System.out.println(clazz);
        // 打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1,
        // name=teacher1]]
    }

    @Test
    public void testGetClass2() {
        /**
         * 映射sql的标识字符串，
         * mapper.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
         * getClass2是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.classMapper.getClass2";// 映射sql的标识字符串
        // 执行查询操作，将查询结果自动封装成Classes对象返回
        Classes clazz = sqlSession.selectOne(statement, 1);// 查询class表中id为1的记录
        System.out.println(clazz);
        // 打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1,
        // name=teacher1]]
    }

}
