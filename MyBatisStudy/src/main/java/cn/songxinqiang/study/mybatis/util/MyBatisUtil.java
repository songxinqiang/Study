/*
 * Copyright (c) 2006, 2015, ZYCOO. and/or its affiliates. All rights reserved.
 * ZYCOO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
/*
 * 创建时间：2015年11月26日--下午3:58:54
 * 作者：宋信强(xinqiang.song)
 */
package cn.songxinqiang.study.mybatis.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author 宋信强-2015年11月26日
 *
 */
public class MyBatisUtil {

    /**
     * 获取SqlSessionFactory
     * 
     * @return SqlSessionFactory
     */
    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "conf.xml";
        InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        return factory;
    }

    /**
     * 获取SqlSession
     * 
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        return getSqlSessionFactory().openSession();
    }

    /**
     * 获取SqlSession
     * 
     * @param isAutoCommit
     *            true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
     *            false
     *            表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.
     *            commit()提交事务
     * @return SqlSession
     */
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        return getSqlSessionFactory().openSession(isAutoCommit);
    }
}
