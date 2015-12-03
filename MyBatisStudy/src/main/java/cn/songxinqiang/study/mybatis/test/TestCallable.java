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
 * 创建时间：2015年12月3日--下午3:26:09
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.test;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.songxinqiang.study.mybatis.util.MyBatisUtil;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年12月3日
 *
 */
public class TestCallable {

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
    public void testGetUserCount() {
        /**
         * 映射sql的标识字符串，mapper.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUserCount是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "mapper.userMapper.getUserCount";// 映射sql的标识字符串
        Map<String, Integer> parameterMap = new HashMap<String, Integer>();
        parameterMap.put("sexid", 0);
        parameterMap.put("usercount", -1);
        sqlSession.selectOne(statement, parameterMap);
        Integer result = parameterMap.get("usercount");
        System.out.println(result);
    }

}
