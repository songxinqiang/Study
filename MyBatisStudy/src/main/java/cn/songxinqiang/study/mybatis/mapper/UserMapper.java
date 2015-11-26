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
 * 创建时间：2015年11月26日--下午4:53:03
 * 作者：阿信sxq(songxinqiang@vip.qq.com)
 */
package cn.songxinqiang.study.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.songxinqiang.study.mybatis.model.User;

/**
 *
 * <p>
 * 众里寻她千百度, 蓦然回首, 那人却在灯火阑珊处.
 * </p>
 *
 * @author 阿信sxq-2015年11月26日
 *
 */
public interface UserMapper {

    // 使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into users(name, age) values(#{name}, #{age})")
    public int add(User user);

    // 使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from users where id=#{id}")
    public int deleteById(int id);

    // 使用@Update注解指明update方法要执行的SQL
    @Update("update users set name=#{name},age=#{age} where id=#{id}")
    public int update(User user);

    // 使用@Select注解指明getById方法要执行的SQL
    @Select("select * from users where id=#{id}")
    public User getById(int id);

    // 使用@Select注解指明getAll方法要执行的SQL
    @Select("select * from users")
    public List<User> getAll();
}
